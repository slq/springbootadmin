package com.esens.admin.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tab_uzytkownik", schema = "auth")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= AUTO)
    @Column(name = "id_uzytkownik")
    private Long id;

    private String login;

    @Column(name = "haslo")
    private String password;

    protected User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
