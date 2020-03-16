package org.javaboy.cacheredis;

import java.io.Serializable;

/**
 * User实体类
 * @author daniel
 * @version 1.0.0
 * @date 2020/3/15 10:51
 */
public class User implements Serializable {

    private Integer id;
    private String username;
    private String address;

    public User() {
    }

    public User(String username, String address) {
        this.username = username;
        this.address = address;
    }

    public User(Integer id, String username, String address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
