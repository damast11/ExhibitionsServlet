package com.kulishd;

import com.kulishd.database.dao.service.UserService;
import com.kulishd.database.pool.ConnectorDb;
import com.kulishd.entity.User;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ConnectorDb.getConnection();
        UserService userService = new UserService();
        List<User> allUsers = userService.findAllUsers();
        System.out.println(allUsers);


    }
}
