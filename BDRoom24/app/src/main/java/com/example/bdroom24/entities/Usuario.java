package com.example.bdroom24.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nome;
    String email;
    public Usuario(){}
    public int getId() {        return id;    }
    public void setId(int id) {        this.id = id;    }
    public String getNome() {        return nome;    }
    public void setNome(String nome) {        this.nome = nome;    }
    public String getEmail() {        return email;    }
    public void setEmail(String email) {        this.email = email;    }
    @Override
    public String toString() {
        return id +": " + nome + ", email=" + email;
    }
}
