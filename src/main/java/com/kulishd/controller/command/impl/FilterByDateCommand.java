package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class FilterByDateCommand implements Command {
    private static Logger logger = Logger.getLogger("FilterByDateCommand");
    @Override
    public String execute(HttpServletRequest request) {
        LocalDate date = LocalDate.parse(request.getParameter("filterDate"));
        System.out.println("date = "+date);
        ExpositionService expositionService = new ExpositionService();
        List<Exposition> expositionList = expositionService.filterByDate(date);
        request.setAttribute("expositions",expositionList);
        request.setAttribute("filterDate",date);
        logger.info("FilterByDateCommand finished with attributes: " + expositionList + " and " + date );
        return "/main.jsp";
    }
}
