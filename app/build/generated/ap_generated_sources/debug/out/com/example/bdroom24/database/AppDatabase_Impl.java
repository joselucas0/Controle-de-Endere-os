package com.example.bdroom24.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.bdroom24.dao.CidadeDao;
import com.example.bdroom24.dao.CidadeDao_Impl;
import com.example.bdroom24.dao.EnderecoDao;
import com.example.bdroom24.dao.EnderecoDao_Impl;
import com.example.bdroom24.dao.UsuarioDao;
import com.example.bdroom24.dao.UsuarioDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UsuarioDao _usuarioDao;

  private volatile CidadeDao _cidadeDao;

  private volatile EnderecoDao _enderecoDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(6) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Usuario` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `email` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Cidade` (`cidadeId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `estado` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `endereco` (`enderecoId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `descricao` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `cidadeId` INTEGER NOT NULL, `nomeCidadeEndereco` TEXT, FOREIGN KEY(`cidadeId`) REFERENCES `Cidade`(`cidadeId`) ON UPDATE CASCADE ON DELETE CASCADE )");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8817d16c1e9d68c1c272d2c9c46a3b13')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `Usuario`");
        db.execSQL("DROP TABLE IF EXISTS `Cidade`");
        db.execSQL("DROP TABLE IF EXISTS `endereco`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsuario = new HashMap<String, TableInfo.Column>(3);
        _columnsUsuario.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuario.put("nome", new TableInfo.Column("nome", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuario.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsuario = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsuario = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsuario = new TableInfo("Usuario", _columnsUsuario, _foreignKeysUsuario, _indicesUsuario);
        final TableInfo _existingUsuario = TableInfo.read(db, "Usuario");
        if (!_infoUsuario.equals(_existingUsuario)) {
          return new RoomOpenHelper.ValidationResult(false, "Usuario(com.example.bdroom24.entities.Usuario).\n"
                  + " Expected:\n" + _infoUsuario + "\n"
                  + " Found:\n" + _existingUsuario);
        }
        final HashMap<String, TableInfo.Column> _columnsCidade = new HashMap<String, TableInfo.Column>(3);
        _columnsCidade.put("cidadeId", new TableInfo.Column("cidadeId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCidade.put("nome", new TableInfo.Column("nome", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCidade.put("estado", new TableInfo.Column("estado", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCidade = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCidade = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCidade = new TableInfo("Cidade", _columnsCidade, _foreignKeysCidade, _indicesCidade);
        final TableInfo _existingCidade = TableInfo.read(db, "Cidade");
        if (!_infoCidade.equals(_existingCidade)) {
          return new RoomOpenHelper.ValidationResult(false, "Cidade(com.example.bdroom24.entities.Cidade).\n"
                  + " Expected:\n" + _infoCidade + "\n"
                  + " Found:\n" + _existingCidade);
        }
        final HashMap<String, TableInfo.Column> _columnsEndereco = new HashMap<String, TableInfo.Column>(6);
        _columnsEndereco.put("enderecoId", new TableInfo.Column("enderecoId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("descricao", new TableInfo.Column("descricao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("cidadeId", new TableInfo.Column("cidadeId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEndereco.put("nomeCidadeEndereco", new TableInfo.Column("nomeCidadeEndereco", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEndereco = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysEndereco.add(new TableInfo.ForeignKey("Cidade", "CASCADE", "CASCADE", Arrays.asList("cidadeId"), Arrays.asList("cidadeId")));
        final HashSet<TableInfo.Index> _indicesEndereco = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEndereco = new TableInfo("endereco", _columnsEndereco, _foreignKeysEndereco, _indicesEndereco);
        final TableInfo _existingEndereco = TableInfo.read(db, "endereco");
        if (!_infoEndereco.equals(_existingEndereco)) {
          return new RoomOpenHelper.ValidationResult(false, "endereco(com.example.bdroom24.entities.Endereco).\n"
                  + " Expected:\n" + _infoEndereco + "\n"
                  + " Found:\n" + _existingEndereco);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8817d16c1e9d68c1c272d2c9c46a3b13", "757f3332c668b10616a143ed73652858");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Usuario","Cidade","endereco");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Usuario`");
      _db.execSQL("DELETE FROM `Cidade`");
      _db.execSQL("DELETE FROM `endereco`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UsuarioDao.class, UsuarioDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CidadeDao.class, CidadeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EnderecoDao.class, EnderecoDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UsuarioDao usuarioDao() {
    if (_usuarioDao != null) {
      return _usuarioDao;
    } else {
      synchronized(this) {
        if(_usuarioDao == null) {
          _usuarioDao = new UsuarioDao_Impl(this);
        }
        return _usuarioDao;
      }
    }
  }

  @Override
  public CidadeDao cidadeDao() {
    if (_cidadeDao != null) {
      return _cidadeDao;
    } else {
      synchronized(this) {
        if(_cidadeDao == null) {
          _cidadeDao = new CidadeDao_Impl(this);
        }
        return _cidadeDao;
      }
    }
  }

  @Override
  public EnderecoDao enderecoDao() {
    if (_enderecoDao != null) {
      return _enderecoDao;
    } else {
      synchronized(this) {
        if(_enderecoDao == null) {
          _enderecoDao = new EnderecoDao_Impl(this);
        }
        return _enderecoDao;
      }
    }
  }
}
