package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.logging.Logger;

public class UpdateExpositionCommand implements Command {
    private static Logger logger = Logger.getLogger("UpdateExpositionCommand");
    @Override
    public String execute(HttpServletRequest request) {
        ExpositionService expositionService = new ExpositionService();
        String id = request.getParameter("id");
        Exposition exposition = expositionService.findExpositionById(Long.valueOf(id));
        request.setAttribute("exposition", exposition);
        logger.info("UpdateExpositionCommand finished with attributes: " + exposition);
        return "/admin/updateExposition.jsp";
    }
}
