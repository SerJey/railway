package com.epam.java.lab.railway.model;

import javax.persistence.*;
import java.io.Serializable;
@NamedQueries({
        @NamedQuery(name = "findUserByUsername", query = "select u from User u where u.username=:username"),
        @NamedQuery(name = "findUser", query = "select u from User u")
})
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true, nullable=false)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String patronymic;

    public User() {
    }

    public User(String username, String password, String firstName, String lastName, String patronymic) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "User {\n" + getUsername() + " \n" + getPassword() + " \n" + getFirstName() + " \n" + getLastName() + " \n" + getPatronymic() + "\n}";
    }
}
