package com.ctban.ctblib.models.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table MY_PROPERTY.
 */
public class MyProperty {

    /** Not-null value. */
    private String key;
    private String value;
    private Long id;

    public MyProperty() {
    }

    public MyProperty(Long id) {
        this.id = id;
    }

    public MyProperty(String key, String value, Long id) {
        this.key = key;
        this.value = value;
        this.id = id;
    }

    /** Not-null value. */
    public String getKey() {
        return key;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
