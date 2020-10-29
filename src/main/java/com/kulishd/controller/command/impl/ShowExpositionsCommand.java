package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class ShowExpositionsCommand implements Command {
    private static Logger logger = Logger.getLogger("ShowExpositionsCommand");
    @Override
    public String execute(HttpServletRequest request) {
        ExpositionService expositionService = new ExpositionService();
        int page = 1;
        int recordsPerPage = 2;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        List<Exposition> expositions = expositionService.findAll();
        int noOfRecords = expositions.size();
        List<Exposition> expositionList = expositions.subList((page - 1) * recordsPerPage, ((page - 1) * recordsPerPage)+recordsPerPage);
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfPages",noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("expositions",expositionList);
        logger.info("ShowExpositionsCommand finished with attributes: " + noOfPages + ", " + page + " and " + expositionList);
        return "/main.jsp";
    }
}
