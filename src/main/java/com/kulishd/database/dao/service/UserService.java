package com.kulishd.database.dao.service;


import com.kulishd.database.dao.UserDAO;
import com.kulishd.database.pool.ConnectorDb;
import com.kulishd.entity.User;
import com.kulishd.mapper.UserMapper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService implements UserDAO {
    private static Logger logger = Logger.getLogger("UserService");
    private static final String FIND_USER_BY_USERNAME_AND_PASSWORD = "select * from usr left join user_role on usr.id=user_role.user_id \n" +
            "where username = ? and password = ?";
    private static final String FIND_ALL_USERS = "select * from usr left join user_role on id=user_id";
    private static final String INSERT_USER = "insert into usr(password,username) values(?, ?)";

    private static final String INSERT_USERROLE = "insert into user_role (user_id,role) values ((select usr.id from usr where username=?),'USER')";
    private final Connection connection = ConnectorDb.getConnection();
    private UserMapper userMapper = new UserMapper();

    @Override
    public User findUserByEmailAndPassword(String username, String password) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = userMapper.extractFromResultSet(resultSet);
                user.setRole(resultSet.getString("role"));
                logger.info("findUserByEmailAndPassword returning " + user);
                return user;
            }
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findUserByEmailAndPassword");
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(FIND_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));
                list.add(user);
            }
            logger.info("findAllUsers returning " + list);
            return list;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findAllUsers");
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(String password, String name) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, name);
            preparedStatement.executeUpdate();
            logger.info("save returning ");
            return true;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method save");
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean insertUserRole(String userName) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(INSERT_USERROLE);
            preparedStatement.setString(1, userName);
            preparedStatement.executeUpdate();
            logger.info("insertUserRole returning ");
            return true;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method insertUserRole");
            throwables.printStackTrace();
        }
        return false;
    }
}
