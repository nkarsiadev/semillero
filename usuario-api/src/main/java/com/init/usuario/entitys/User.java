package com.init.usuario.entitys;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150)
    public String name;

    @Column(length = 30)
    private String password;

    @Column(length = 13)
    public String identification;

    @Column(length = 100)
    public String email;

    @OneToMany(mappedBy = "user")
    public Set<Account> accounts;

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getIdentification() {
        return identification;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
