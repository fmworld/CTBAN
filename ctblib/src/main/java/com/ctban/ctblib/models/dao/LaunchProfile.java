package com.ctban.ctblib.models.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table LAUNCH_PROFILE.
 */
public class LaunchProfile {

    /** Not-null value. */
    private String img;
    private String link;
    private String tag;
    private String type;

    public LaunchProfile() {
    }

    public LaunchProfile(String img, String link, String tag, String type) {
        this.img = img;
        this.link = link;
        this.tag = tag;
        this.type = type;
    }

    /** Not-null value. */
    public String getImg() {
        return img;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}