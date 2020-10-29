package com.kulishd.controller.command.impl;


import com.kulishd.controller.command.Command;
import com.kulishd.controller.command.CommandUtility;
import com.kulishd.database.dao.service.UserService;
import com.kulishd.entity.User;
import com.kulishd.entity.UserRole;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class LoginCommand implements Command {
    private static Logger logger = Logger.getLogger("LoginCommand");
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            logger.info("Please input name or pass");
            return "/login.jsp";
        }
        UserService userDAO = new UserService();
        User userByEmailAndPassword = userDAO.findUserByEmailAndPassword(name, pass);
        if(CommandUtility.checkUserIsLogged(request, name)){
            logger.info("User "+ name+" already logged.");
            return "/WEB-INF/error.jsp";
        }
        if (userByEmailAndPassword.getRole().equals("ADMIN")){
            CommandUtility.setUserRole(request, UserRole.ADMIN, name);
            logger.info("Admin "+ name+" logged successfully.");
            return "redirect:/showExpositions";
        } else if(userByEmailAndPassword.getRole().equals("USER")){
            CommandUtility.setUserRole(request, UserRole.USER, name);
            logger.info("User "+ name+" logged successfully.");
            return "redirect:/showExpositions";
        } else{
            logger.info("Invalid attempt of login user:'"+ name+"'");
            return "/login.jsp";
        }
    }

}
