package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class RegistrationCommand implements Command {
    private static Logger logger = Logger.getLogger("RegistrationCommand");
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            logger.info("Pleas input login or pass");
            return "/registration.jsp";
        }
        UserService userService = new UserService();
        userService.save(pass,name);
        userService.insertUserRole(name);
        logger.info("New user created");
        return "redirect:/login";
    }
}
