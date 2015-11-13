package com.ctban.ctblib.models.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table USER.
 */
public class User {

    /** Not-null value. */
    private String account;
    /** Not-null value. */
    private String password;
    private String token;
    private String role;
    private String state;
    private String userMobile;
    private String innerHead;
    private String innerName;
    private Boolean islogin;
    private Long id;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String account, String password, String token, String role, String state, String userMobile, String innerHead, String innerName, Boolean islogin, Long id) {
        this.account = account;
        this.password = password;
        this.token = token;
        this.role = role;
        this.state = state;
        this.userMobile = userMobile;
        this.innerHead = innerHead;
        this.innerName = innerName;
        this.islogin = islogin;
        this.id = id;
    }

    /** Not-null value. */
    public String getAccount() {
        return account;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setAccount(String account) {
        this.account = account;
    }

    /** Not-null value. */
    public String getPassword() {
        return password;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getInnerHead() {
        return innerHead;
    }

    public void setInnerHead(String innerHead) {
        this.innerHead = innerHead;
    }

    public String getInnerName() {
        return innerName;
    }

    public void setInnerName(String innerName) {
        this.innerName = innerName;
    }

    public Boolean getIslogin() {
        return islogin;
    }

    public void setIslogin(Boolean islogin) {
        this.islogin = islogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}