package com.epam.java.lab.railway.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by SerJey on 08.05.2015.
 */
@Entity
public class AuthToken implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private User userId;
    private String token;
    private Date expireDate;

    public AuthToken() {
    }

    public AuthToken(User userId, String token, Date expireDate) {
        this.userId = userId;
        this.token = token;
        this.expireDate = expireDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
