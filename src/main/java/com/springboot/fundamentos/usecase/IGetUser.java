package com.springboot.fundamentos.usecase;

import com.springboot.fundamentos.entity.User;

import java.util.List;

public interface IGetUser {
    List<User> getAll();
}
