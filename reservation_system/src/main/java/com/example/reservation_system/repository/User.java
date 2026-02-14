package com.example.reservation_system.repository;

import java.time.LocalDate;

public class User {
    private long id;
    private String name;
    private String email;
    private LocalDate birthdate;
    private Integer age;


    public User(Long id, String name, String email, LocalDate birthdate, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthdate = birthdate;
        this.age = age;
    }

    public User() {
    }

    public Integer getAge() {
        return age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
