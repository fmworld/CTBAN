package com.ctban.ctblib.models.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table WEATHER.
*/
public class WeatherDao extends AbstractDao<Weather, Void> {

    public static final String TABLENAME = "WEATHER";

    /**
     * Properties of entity Weather.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Cityid = new Property(0, String.class, "cityid", false, "CITYID");
        public final static Property City = new Property(1, String.class, "city", false, "CITY");
        public final static Property Temp = new Property(2, String.class, "temp", false, "TEMP");
    };


    public WeatherDao(DaoConfig config) {
        super(config);
    }
    
    public WeatherDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'WEATHER' (" + //
                "'CITYID' TEXT NOT NULL ," + // 0: cityid
                "'CITY' TEXT," + // 1: city
                "'TEMP' TEXT);"); // 2: temp
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'WEATHER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Weather entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getCityid());
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(2, city);
        }
 
        String temp = entity.getTemp();
        if (temp != null) {
            stmt.bindString(3, temp);
        }
    }

    /** @inheritdoc */
    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    /** @inheritdoc */
    @Override
    public Weather readEntity(Cursor cursor, int offset) {
        Weather entity = new Weather( //
            cursor.getString(offset + 0), // cityid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // city
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // temp
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Weather entity, int offset) {
        entity.setCityid(cursor.getString(offset + 0));
        entity.setCity(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTemp(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Void updateKeyAfterInsert(Weather entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    /** @inheritdoc */
    @Override
    public Void getKey(Weather entity) {
        return null;
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
