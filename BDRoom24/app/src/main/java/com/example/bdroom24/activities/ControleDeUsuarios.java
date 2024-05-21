package com.example.bdroom24.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bdroom24.R;
import com.example.bdroom24.database.AppDatabase;
import com.example.bdroom24.entities.Usuario;
public class ControleDeUsuarios extends AppCompatActivity {
    private AppDatabase db;
    private EditText edtUsuario,edtEmail;
    private int dbUsuarioId;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controle_de_usuarios);
        db=AppDatabase.getDatabase(getApplicationContext());
        edtUsuario=findViewById(R.id.edtUsuario);
        edtEmail=findViewById(R.id.edtEmail);
        dbUsuarioId=getIntent().getIntExtra("usuario_id",-1);
    }
    public void salvarUsuario(View view) {
        String nome=edtUsuario.getText().toString();
        String email=edtEmail.getText().toString();
        if(!nome.equals("")&&!email.equals("")){
            Usuario novoUsuario=new Usuario();
            novoUsuario.setNome(nome);
            novoUsuario.setEmail(email);
            if(dbUsuarioId!=-1){
                usuario=db.usuarioDao().getUser(dbUsuarioId);
                usuario.setId(dbUsuarioId);
                db.usuarioDao().update(usuario);
            }else{
                db.usuarioDao().insertAll(novoUsuario);
                Toast.makeText(this, "Usuário Inserido",
                        Toast.LENGTH_LONG).show();
            }
            finish();
        }
    }
}