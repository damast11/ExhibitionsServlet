package com.kulishd.controller.command;

import com.kulishd.entity.UserRole;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.logging.Logger;

public class CommandUtility {
    private static Logger logger = Logger.getLogger("CommandUtility");

    public static void setUserRole(HttpServletRequest request,
                                   UserRole role, String name) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        session.setAttribute("userName", name);
        session.setAttribute("role", role);
        logger.info("method setUserRole finished with attributes: " + name + " and "+role);
    }

    public static boolean checkUserIsLogged(HttpServletRequest request, String userName) {
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if (loggedUsers.stream().anyMatch(userName::equals)) {
            logger.info("method checkUserIsLogged finished "+userName + " already logged");
            return true;
        }
        loggedUsers.add(userName);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        logger.info("method checkUserIsLogged finished "+userName + " add");
        return false;
    }
}
