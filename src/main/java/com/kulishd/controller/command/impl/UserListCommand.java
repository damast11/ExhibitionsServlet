package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.UserService;
import com.kulishd.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

public class UserListCommand implements Command {
    private static Logger logger = Logger.getLogger("UpdateExpositionCommand");
    @Override
    public String execute(HttpServletRequest request) {
        UserService userService = new UserService();
        List<User> allUsers = userService.findAllUsers();
        request.setAttribute("users",allUsers);
        logger.info("UpdateExpositionCommand finished with attributes: " + allUsers);
        return "/admin/userList.jsp";
    }
}
