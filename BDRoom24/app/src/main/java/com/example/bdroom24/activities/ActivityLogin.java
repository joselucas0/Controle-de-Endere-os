package com.example.bdroom24.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.bdroom24.R;

public class ActivityLogin extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                Button buttonCadastrar = findViewById(R.id.buttonCadastro);
                buttonCadastrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(ActivityLogin.this, ActivityCadastro.class);
                                startActivity(intent);
                        }
                });
        }
}
