package com.kulishd.controller;


import com.kulishd.controller.command.Command;
import com.kulishd.controller.command.impl.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Logger;

public class Servlet extends HttpServlet {
    private static Logger logger = Logger.getLogger("Servlet");
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig){

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
        commands.put("/registration",
                new RegistrationCommand());
        commands.put("/admin/userList",
                new UserListCommand());
        commands.put("/filterByDate",
                new FilterByDateCommand());
        commands.put("/admin/statistics",
                new StatisticsCommand());
        commands.put("/buyTicket",
                new BuyTicketCommand());
        commands.put("/admin/addHallsToExposition",
                new AddHallToExpositionCommand());
        commands.put("/admin/addHalls",
                new AddHallsCommand());
        commands.put("/admin/addExposition",
                new AddExpositionCommand());
        commands.put("/admin/deleteExposition",
                new DeleteExpositionCommand());
        commands.put("/admin/editExposition",
                new EditExpositionCommand());
        commands.put("/admin/updateExposition",
                new UpdateExpositionCommand());
        commands.put("/showExpositions",
                new ShowExpositionsCommand());
        commands.put("/logout",
                new LogOutCommand());
        commands.put("/login",
                new LoginCommand());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession(false)==null){
            response.sendRedirect("/error.jsp");
        }
        String path = request.getRequestURI();
        Command command = commands.get(path);
        String page = command.execute(request);
        if(page.contains("redirect:")){
            logger.info("redirecting" + page);
            response.sendRedirect(page.replace("redirect:", ""));
        }else {
            logger.info("forwarding" + page);
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
