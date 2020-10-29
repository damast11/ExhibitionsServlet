package com.kulishd.controller.command.impl;


import com.kulishd.controller.command.Command;
import com.kulishd.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

public class LogOutCommand implements Command {
    private static Logger logger = Logger.getLogger("LogOutCommand");
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession(false).invalidate();
        logger.info("Log Out success");
        return "redirect:/login.jsp";
    }
}
