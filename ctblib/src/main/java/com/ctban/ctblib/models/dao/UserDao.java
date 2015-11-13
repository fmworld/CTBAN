package com.ctban.ctblib.models.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USER.
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Account = new Property(0, String.class, "account", false, "ACCOUNT");
        public final static Property Password = new Property(1, String.class, "password", false, "PASSWORD");
        public final static Property Token = new Property(2, String.class, "token", false, "TOKEN");
        public final static Property Role = new Property(3, String.class, "role", false, "ROLE");
        public final static Property State = new Property(4, String.class, "state", false, "STATE");
        public final static Property UserMobile = new Property(5, String.class, "userMobile", false, "USER_MOBILE");
        public final static Property InnerHead = new Property(6, String.class, "innerHead", false, "INNER_HEAD");
        public final static Property InnerName = new Property(7, String.class, "innerName", false, "INNER_NAME");
        public final static Property Islogin = new Property(8, Boolean.class, "islogin", false, "ISLOGIN");
        public final static Property Id = new Property(9, Long.class, "id", true, "_id");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'ACCOUNT' TEXT NOT NULL ," + // 0: account
                "'PASSWORD' TEXT NOT NULL ," + // 1: password
                "'TOKEN' TEXT," + // 2: token
                "'ROLE' TEXT," + // 3: role
                "'STATE' TEXT," + // 4: state
                "'USER_MOBILE' TEXT," + // 5: userMobile
                "'INNER_HEAD' TEXT," + // 6: innerHead
                "'INNER_NAME' TEXT," + // 7: innerName
                "'ISLOGIN' INTEGER," + // 8: islogin
                "'_id' INTEGER PRIMARY KEY );"); // 9: id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getAccount());
        stmt.bindString(2, entity.getPassword());
 
        String token = entity.getToken();
        if (token != null) {
            stmt.bindString(3, token);
        }
 
        String role = entity.getRole();
        if (role != null) {
            stmt.bindString(4, role);
        }
 
        String state = entity.getState();
        if (state != null) {
            stmt.bindString(5, state);
        }
 
        String userMobile = entity.getUserMobile();
        if (userMobile != null) {
            stmt.bindString(6, userMobile);
        }
 
        String innerHead = entity.getInnerHead();
        if (innerHead != null) {
            stmt.bindString(7, innerHead);
        }
 
        String innerName = entity.getInnerName();
        if (innerName != null) {
            stmt.bindString(8, innerName);
        }
 
        Boolean islogin = entity.getIslogin();
        if (islogin != null) {
            stmt.bindLong(9, islogin ? 1l: 0l);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(10, id);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.getString(offset + 0), // account
            cursor.getString(offset + 1), // password
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // token
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // role
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // state
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // userMobile
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // innerHead
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // innerName
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // islogin
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9) // id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setAccount(cursor.getString(offset + 0));
        entity.setPassword(cursor.getString(offset + 1));
        entity.setToken(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setRole(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setState(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUserMobile(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setInnerHead(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setInnerName(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIslogin(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setId(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}