package com.example.bdroom24.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.bdroom24.dao.UsuarioDao;
import com.example.bdroom24.entities.Usuario;
@Database(entities = {Usuario.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{
    private static AppDatabase INSTANCE;
    public static AppDatabase getDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,"ControleDeUsuarios")
                    .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public abstract UsuarioDao usuarioDao();
}
