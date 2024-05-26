package com.example.bdroom24.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bdroom24.R;
import com.example.bdroom24.database.DatabaseHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityLogin extends AppCompatActivity {

        private EditText userEmailText, userPasswordText;
        private TextView errorTextLogin;
        private DatabaseHelper dbHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                userEmailText = findViewById(R.id.userEmailLoginValue);
                userPasswordText = findViewById(R.id.userPasswordLoginValue);
                errorTextLogin = findViewById(R.id.errorTextLogin);

                dbHelper = new DatabaseHelper(this);

                Button buttonLogin = findViewById(R.id.buttonLogin);
                buttonLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                getLoginValues();
                        }
                });

                Button buttonCadastrar = findViewById(R.id.buttonCadastro);
                buttonCadastrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(ActivityLogin.this, ActivityCadastro.class);
                                startActivity(intent);
                        }
                });
        }

        private void getLoginValues() {
                String userEmail = userEmailText.getText().toString();
                String userPassword = userPasswordText.getText().toString();

                if (userEmail.isEmpty() || userPassword.isEmpty()) {
                        errorTextLogin.setVisibility(View.VISIBLE);
                        errorTextLogin.setText("Preencha e-mail e senha.");
                } else if (!validateEmail(userEmail)) {
                        errorTextLogin.setVisibility(View.VISIBLE);
                        errorTextLogin.setText("E-mail inserido é inválido.");
                } else {
                        loginUser(userEmail, userPassword);
                }
        }

        private void loginUser(String userEmail, String userPassword) {
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                String[] projection = {
                        DatabaseHelper.COLUMN_ID,
                        DatabaseHelper.COLUMN_NAME,
                        DatabaseHelper.COLUMN_EMAIL,
                        DatabaseHelper.COLUMN_PASSWORD
                };

                String selection = DatabaseHelper.COLUMN_EMAIL + " = ? AND " + DatabaseHelper.COLUMN_PASSWORD + " = ?";
                String[] selectionArgs = { userEmail, userPassword };

                Cursor cursor = db.query(
                        DatabaseHelper.TABLE_USERS,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null
                );

                if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        Toast.makeText(ActivityLogin.this, "Login bem-sucedido!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                } else {
                        errorTextLogin.setVisibility(View.VISIBLE);
                        errorTextLogin.setText("E-mail ou senha incorretos.");
                }

                if (cursor != null) {
                        cursor.close();
                }

                db.close();
        }

        private static boolean validateEmail(String inputEmail) {
                String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(inputEmail);
                return matcher.matches();
        }
}
