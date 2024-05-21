package com.example.bdroom24.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.bdroom24.R;
import com.example.bdroom24.database.AppDatabase;
import com.example.bdroom24.entities.Usuario;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppDatabase db;
    private List<Usuario> usuarioList;
    private ListView listUsuarios;
    private Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=AppDatabase.getDatabase(getApplicationContext());
        listUsuarios=findViewById(R.id.listViewUsuarios);
    }
    @Override
    protected void onResume(){
        super.onResume();
        intent=new Intent(this, ControleDeUsuarios.class);
        buscarUsuarios();
    }
    private void buscarUsuarios() {
        usuarioList=db.usuarioDao().getAll();
        ArrayAdapter<Usuario> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, usuarioList);
        listUsuarios.setAdapter(adapter);
    }
    public void adicionaUsuario(View view) {
        startActivity(intent);
    }
}