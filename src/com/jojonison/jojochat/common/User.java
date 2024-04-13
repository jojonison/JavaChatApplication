package com.jojonison.jojochat.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private boolean isBanned = false;
    private List<User> bookmarks = new ArrayList<User>();

    public User(int id, String username, String password, boolean isBanned, List<User> bookmarks) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isBanned = isBanned;
        this.bookmarks = bookmarks;
    }

    public List<User> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<User> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
