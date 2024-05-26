package com.example.bdroom24.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.bdroom24.entities.Cidade;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CidadeDao_Impl implements CidadeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cidade> __insertionAdapterOfCidade;

  private final EntityDeletionOrUpdateAdapter<Cidade> __deletionAdapterOfCidade;

  private final EntityDeletionOrUpdateAdapter<Cidade> __updateAdapterOfCidade;

  public CidadeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCidade = new EntityInsertionAdapter<Cidade>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Cidade` (`cidadeId`,`nome`,`estado`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cidade entity) {
        statement.bindLong(1, entity.cidadeId);
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getEstado() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEstado());
        }
      }
    };
    this.__deletionAdapterOfCidade = new EntityDeletionOrUpdateAdapter<Cidade>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Cidade` WHERE `cidadeId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cidade entity) {
        statement.bindLong(1, entity.cidadeId);
      }
    };
    this.__updateAdapterOfCidade = new EntityDeletionOrUpdateAdapter<Cidade>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Cidade` SET `cidadeId` = ?,`nome` = ?,`estado` = ? WHERE `cidadeId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cidade entity) {
        statement.bindLong(1, entity.cidadeId);
        if (entity.getNome() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNome());
        }
        if (entity.getEstado() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEstado());
        }
        statement.bindLong(4, entity.cidadeId);
      }
    };
  }

  @Override
  public void inserirCidade(final Cidade cidade) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCidade.insert(cidade);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletarCidade(final Cidade cidade) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCidade.handle(cidade);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void atualizarCidade(final Cidade cidade) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCidade.handle(cidade);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Cidade> getAll() {
    final String _sql = "SELECT * FROM Cidade";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCidadeId = CursorUtil.getColumnIndexOrThrow(_cursor, "cidadeId");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final List<Cidade> _result = new ArrayList<Cidade>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Cidade _item;
        _item = new Cidade();
        _item.cidadeId = _cursor.getInt(_cursorIndexOfCidadeId);
        final String _tmpNome;
        if (_cursor.isNull(_cursorIndexOfNome)) {
          _tmpNome = null;
        } else {
          _tmpNome = _cursor.getString(_cursorIndexOfNome);
        }
        _item.setNome(_tmpNome);
        final String _tmpEstado;
        if (_cursor.isNull(_cursorIndexOfEstado)) {
          _tmpEstado = null;
        } else {
          _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        }
        _item.setEstado(_tmpEstado);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cidade getCidadePorNome(final String nomeCidade) {
    final String _sql = "SELECT * FROM cidade WHERE nome = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (nomeCidade == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nomeCidade);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCidadeId = CursorUtil.getColumnIndexOrThrow(_cursor, "cidadeId");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfEstado = CursorUtil.getColumnIndexOrThrow(_cursor, "estado");
      final Cidade _result;
      if (_cursor.moveToFirst()) {
        _result = new Cidade();
        _result.cidadeId = _cursor.getInt(_cursorIndexOfCidadeId);
        final String _tmpNome;
        if (_cursor.isNull(_cursorIndexOfNome)) {
          _tmpNome = null;
        } else {
          _tmpNome = _cursor.getString(_cursorIndexOfNome);
        }
        _result.setNome(_tmpNome);
        final String _tmpEstado;
        if (_cursor.isNull(_cursorIndexOfEstado)) {
          _tmpEstado = null;
        } else {
          _tmpEstado = _cursor.getString(_cursorIndexOfEstado);
        }
        _result.setEstado(_tmpEstado);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
