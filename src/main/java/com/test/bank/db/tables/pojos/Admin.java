/*
 * This file is generated by jOOQ.
 */
package com.test.bank.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;

import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Admin implements Serializable {

    private static final long serialVersionUID = 1923686174;

    private UInteger id;
    private String   account;
    private String   password;
    private String   salt;

    public Admin() {}

    public Admin(Admin value) {
        this.id = value.id;
        this.account = value.account;
        this.password = value.password;
        this.salt = value.salt;
    }

    public Admin(
        UInteger id,
        String   account,
        String   password,
        String   salt
    ) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.salt = salt;
    }

    public UInteger getId() {
        return this.id;
    }

    public void setId(UInteger id) {
        this.id = id;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Admin (");

        sb.append(id);
        sb.append(", ").append(account);
        sb.append(", ").append(password);
        sb.append(", ").append(salt);

        sb.append(")");
        return sb.toString();
    }
}
