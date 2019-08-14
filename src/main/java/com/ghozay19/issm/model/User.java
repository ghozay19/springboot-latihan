package com.ghozay19.issm.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Transient //ga di save ke table
    private String token;
    @NotNull
    private String name;
    @NotNull
    private String username;
    @JsonIgnore
    @NotNull
    private String password;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
            //eager = bawa entity
            //fetchtype.lazy = ga bawa entity penggunaan tergantung kondisi...
    List<Address> addressList;
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @CreatedDate
    private  Date createdDate;
    @LastModifiedDate
    private Date updatedDate;


    public User(){

    }

    public User(String token, @NotNull String name, @NotNull String username, @NotNull String password, List<Address> addressList, Date birthDate) {
        this.token = token;
        this.name = name;
        this.username = username;
        this.password = password;
        this.addressList = addressList;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}