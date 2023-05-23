package com.springboot.fundamentos.dto;

import java.time.LocalDate;

public class UserDto {
    private String name;
    private String email;
    private LocalDate birthDate;

    public UserDto(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
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
