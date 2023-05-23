package com.springboot.fundamentos.dto;

import java.time.LocalDate;

public class UserDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;

    public UserDto(Long id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nUser: " +
                "\n\tname: " + name +
                ",\n\temail: '" + email + '\'' +
                ",\n\tbirthDate: '" + birthDate + '\'';
    }
}
