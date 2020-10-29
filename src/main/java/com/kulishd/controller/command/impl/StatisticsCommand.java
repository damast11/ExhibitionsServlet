package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

public class StatisticsCommand implements Command {
    private static Logger logger = Logger.getLogger("StatisticsCommand");
    @Override
    public String execute(HttpServletRequest request) {
        ExpositionService expositionService = new ExpositionService();
        int page = 1;
        int recordsPerPage = 2;
        List<Exposition> expositions = expositionService.findAll();
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int noOfRecords = expositions.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("expositions",expositions);
        request.setAttribute("noOfPages",noOfPages);
        request.setAttribute("currentPage", page);
        logger.info("StatisticsCommand finished with attributes: " + expositions + ", " + noOfPages + " and " + page);
        return "/admin/statistics.jsp";
    }
}
