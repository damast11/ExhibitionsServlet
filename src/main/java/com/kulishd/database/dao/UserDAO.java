package com.kulishd.database.dao;


import com.kulishd.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserDAO {
    User findUserByEmailAndPassword(String email, String password) ;
    List<User> findAllUsers();
    boolean save(String password,String name);
}
