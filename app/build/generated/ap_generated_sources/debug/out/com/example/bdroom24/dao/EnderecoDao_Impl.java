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
import com.example.bdroom24.entities.Endereco;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EnderecoDao_Impl implements EnderecoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Endereco> __insertionAdapterOfEndereco;

  private final EntityDeletionOrUpdateAdapter<Endereco> __deletionAdapterOfEndereco;

  private final EntityDeletionOrUpdateAdapter<Endereco> __updateAdapterOfEndereco;

  public EnderecoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEndereco = new EntityInsertionAdapter<Endereco>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `endereco` (`enderecoId`,`descricao`,`latitude`,`longitude`,`cidadeId`,`nomeCidadeEndereco`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Endereco entity) {
        statement.bindLong(1, entity.enderecoId);
        if (entity.getDescricao() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDescricao());
        }
        statement.bindDouble(3, entity.getLatitude());
        statement.bindDouble(4, entity.getLongitude());
        statement.bindLong(5, entity.getCidadeId());
        if (entity.getNomeCidadeEndereco() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getNomeCidadeEndereco());
        }
      }
    };
    this.__deletionAdapterOfEndereco = new EntityDeletionOrUpdateAdapter<Endereco>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `endereco` WHERE `enderecoId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Endereco entity) {
        statement.bindLong(1, entity.enderecoId);
      }
    };
    this.__updateAdapterOfEndereco = new EntityDeletionOrUpdateAdapter<Endereco>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `endereco` SET `enderecoId` = ?,`descricao` = ?,`latitude` = ?,`longitude` = ?,`cidadeId` = ?,`nomeCidadeEndereco` = ? WHERE `enderecoId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Endereco entity) {
        statement.bindLong(1, entity.enderecoId);
        if (entity.getDescricao() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDescricao());
        }
        statement.bindDouble(3, entity.getLatitude());
        statement.bindDouble(4, entity.getLongitude());
        statement.bindLong(5, entity.getCidadeId());
        if (entity.getNomeCidadeEndereco() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getNomeCidadeEndereco());
        }
        statement.bindLong(7, entity.enderecoId);
      }
    };
  }

  @Override
  public void inserirEndereco(final Endereco endereco) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEndereco.insert(endereco);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deletarEndereco(final Endereco endereco) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEndereco.handle(endereco);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void atualizarEndereco(final Endereco endereco) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEndereco.handle(endereco);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Endereco> getAll() {
    final String _sql = "SELECT * FROM Endereco";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEnderecoId = CursorUtil.getColumnIndexOrThrow(_cursor, "enderecoId");
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfCidadeId = CursorUtil.getColumnIndexOrThrow(_cursor, "cidadeId");
      final int _cursorIndexOfNomeCidadeEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "nomeCidadeEndereco");
      final List<Endereco> _result = new ArrayList<Endereco>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Endereco _item;
        _item = new Endereco();
        _item.enderecoId = _cursor.getInt(_cursorIndexOfEnderecoId);
        final String _tmpDescricao;
        if (_cursor.isNull(_cursorIndexOfDescricao)) {
          _tmpDescricao = null;
        } else {
          _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        }
        _item.setDescricao(_tmpDescricao);
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        _item.setLatitude(_tmpLatitude);
        final double _tmpLongitude;
        _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        _item.setLongitude(_tmpLongitude);
        final int _tmpCidadeId;
        _tmpCidadeId = _cursor.getInt(_cursorIndexOfCidadeId);
        _item.setCidadeId(_tmpCidadeId);
        final String _tmpNomeCidadeEndereco;
        if (_cursor.isNull(_cursorIndexOfNomeCidadeEndereco)) {
          _tmpNomeCidadeEndereco = null;
        } else {
          _tmpNomeCidadeEndereco = _cursor.getString(_cursorIndexOfNomeCidadeEndereco);
        }
        _item.setNomeCidadeEndereco(_tmpNomeCidadeEndereco);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Endereco getEnderecoPorDescricao(final String descricaoEndereco) {
    final String _sql = "SELECT * FROM endereco WHERE descricao = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (descricaoEndereco == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, descricaoEndereco);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEnderecoId = CursorUtil.getColumnIndexOrThrow(_cursor, "enderecoId");
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
      final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
      final int _cursorIndexOfCidadeId = CursorUtil.getColumnIndexOrThrow(_cursor, "cidadeId");
      final int _cursorIndexOfNomeCidadeEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "nomeCidadeEndereco");
      final Endereco _result;
      if (_cursor.moveToFirst()) {
        _result = new Endereco();
        _result.enderecoId = _cursor.getInt(_cursorIndexOfEnderecoId);
        final String _tmpDescricao;
        if (_cursor.isNull(_cursorIndexOfDescricao)) {
          _tmpDescricao = null;
        } else {
          _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        }
        _result.setDescricao(_tmpDescricao);
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        _result.setLatitude(_tmpLatitude);
        final double _tmpLongitude;
        _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
        _result.setLongitude(_tmpLongitude);
        final int _tmpCidadeId;
        _tmpCidadeId = _cursor.getInt(_cursorIndexOfCidadeId);
        _result.setCidadeId(_tmpCidadeId);
        final String _tmpNomeCidadeEndereco;
        if (_cursor.isNull(_cursorIndexOfNomeCidadeEndereco)) {
          _tmpNomeCidadeEndereco = null;
        } else {
          _tmpNomeCidadeEndereco = _cursor.getString(_cursorIndexOfNomeCidadeEndereco);
        }
        _result.setNomeCidadeEndereco(_tmpNomeCidadeEndereco);
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
