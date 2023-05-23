package com.springboot.fundamentos.usecase;

import com.springboot.fundamentos.entity.User;
import com.springboot.fundamentos.service.UserService;

import java.util.List;

public class GetUserImpl implements IGetUser {
    private UserService userService;

    public GetUserImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @Override
    public List<User> getAllPaging(int page, int size) {
        return userService.getAllPaging(page, size);
    }
}
