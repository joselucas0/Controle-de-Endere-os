package com.example.bdroom24.activities;

import android.content.ContentValues;
import android.content.Intent;
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

public class ActivityCadastro extends AppCompatActivity {

    private EditText editNome, editEmail, editSenha;
    private TextView errorTextFields;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        errorTextFields = findViewById(R.id.errorTextFields);
        dbHelper = new DatabaseHelper(this);

        Button buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRegisterValues();
            }
        });

        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCadastro.this, ActivityLogin.class);
                startActivity(intent);
            }
        });
    }

    private void getRegisterValues() {
        boolean isAllFieldsOk = true;

        String userName = editNome.getText().toString();
        String userEmail = editEmail.getText().toString();
        String userPassword = editSenha.getText().toString();

        if (userName.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty()) {
            errorTextFields.setVisibility(View.VISIBLE);
            errorTextFields.setText("Preencha todos os campos.");
            isAllFieldsOk = false;
        } else if (!userEmail.isEmpty() && !validateEmail(userEmail)) {
            errorTextFields.setVisibility(View.VISIBLE);
            errorTextFields.setText("E-mail inserido é inválido.");
            isAllFieldsOk = false;
        }

        if (isAllFieldsOk) {
            registerUser(userName, userEmail, userPassword);
        }
    }

    private void registerUser(String userName, String userEmail, String userPassword) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, userName);
        values.put(DatabaseHelper.COLUMN_EMAIL, userEmail);
        values.put(DatabaseHelper.COLUMN_PASSWORD, userPassword);

        long newRowId = db.insert(DatabaseHelper.TABLE_USERS, null, values);

        if (newRowId != -1) {
            Toast.makeText(ActivityCadastro.this, "Usuário registrado com sucesso!", Toast.LENGTH_LONG).show();
            // Limpar campos após o registro bem-sucedido
            editNome.setText("");
            editEmail.setText("");
            editSenha.setText("");
        } else {
            Toast.makeText(ActivityCadastro.this, "Erro ao registrar usuário.", Toast.LENGTH_LONG).show();
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
