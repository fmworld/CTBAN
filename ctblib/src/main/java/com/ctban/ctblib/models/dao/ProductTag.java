package com.ctban.ctblib.models.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PRODUCT_TAG.
 */
public class ProductTag {

    /** Not-null value. */
    private String tag_id;
    /** Not-null value. */
    private String tag_name;
    private String item_count;
    private String item_seq;
    private String tag_seq;
    private Long id;

    public ProductTag() {
    }

    public ProductTag(Long id) {
        this.id = id;
    }

    public ProductTag(String tag_id, String tag_name, String item_count, String item_seq, String tag_seq, Long id) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
        this.item_count = item_count;
        this.item_seq = item_seq;
        this.tag_seq = tag_seq;
        this.id = id;
    }

    /** Not-null value. */
    public String getTag_id() {
        return tag_id;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    /** Not-null value. */
    public String getTag_name() {
        return tag_name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getItem_count() {
        return item_count;
    }

    public void setItem_count(String item_count) {
        this.item_count = item_count;
    }

    public String getItem_seq() {
        return item_seq;
    }

    public void setItem_seq(String item_seq) {
        this.item_seq = item_seq;
    }

    public String getTag_seq() {
        return tag_seq;
    }

    public void setTag_seq(String tag_seq) {
        this.tag_seq = tag_seq;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
