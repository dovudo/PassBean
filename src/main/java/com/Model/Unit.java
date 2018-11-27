package com.Model;


import javax.persistence.*;

@Entity
@Table(name = "unit", schema = "public")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true, nullable = false)
    private long id;

    @Column(name = "email", unique = true, nullable = false,length = 64)
    private String email;

    @Column(name = "data")
    private String data = "[]";

    @Column(name = "token", unique = true, length = 256)
    private String token = null;

    @Column(name = "timestamp")
    private long timestamp;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Unit(String email,String data,String token, long time){
        setEmail(email);
        setData(data);
        setToken(token);
        setTimestamp(time);
    }

    public Unit(){}

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", data='" + data + '\'' +
                ", token='" + token + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
