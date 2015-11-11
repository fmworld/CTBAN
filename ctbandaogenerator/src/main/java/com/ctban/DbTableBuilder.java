package com.ctban;


import java.util.ArrayList;
import java.util.List;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by zhoufeng'an on 2015/8/4.
 */
public class DbTableBuilder {

    private Schema schema;
    private List<String> notNullStrProperties;
    private List<String> strProperties;
    private List<String> dateProperties;
    private List<String> booleanProperties;
    private String tableName;
    private boolean addedIdProperty;

    public DbTableBuilder(Schema schema) {
        this.schema = schema;
        initPropertyContainer();
    }

    private void initPropertyContainer() {
        notNullStrProperties = new ArrayList<String>();
        strProperties = new ArrayList<String>();
        booleanProperties = new ArrayList<String>();
        dateProperties = new ArrayList<String>();
    }

    private void clearPropertyContainer() {
        notNullStrProperties.clear();
        strProperties.clear();
        booleanProperties.clear();
    }

    public DbTableBuilder prepareTable(String table) {
        clearPropertyContainer();
        tableName = table;
        addedIdProperty = false;
        return this;
    }

    public DbTableBuilder addIdProperty() {
        addedIdProperty = true;
        return this;
    }

    public DbTableBuilder addStringProperty(String property) {
        strProperties.add(property);
        return this;
    }

    public DbTableBuilder addStringPropertyNotNull(String property) {
        notNullStrProperties.add(property);
        return this;
    }

    public DbTableBuilder addDateProperty(String property) {
        dateProperties.add(property);
        return this;
    }

    public DbTableBuilder addBooleanProperty(String property) {
        booleanProperties.add(property);
        return this;
    }


    public void build() {
        Entity mEntity = schema.addEntity(tableName);
        for (String item : notNullStrProperties) {
            mEntity.addStringProperty(item).notNull();
        }

        for (String item : strProperties) {
            mEntity.addStringProperty(item);
        }

        for (String item : dateProperties) {
            mEntity.addDateProperty(item);
        }

        for (String item : booleanProperties) {
            mEntity.addBooleanProperty(item);
        }
        if (addedIdProperty) {
            mEntity.addIdProperty();
        }
    }
}
