package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class DeleteExpositionCommand implements Command {
    private static Logger logger = Logger.getLogger("DeleteExpositionCommand");
    @Override
    public String execute(HttpServletRequest request) {
        ExpositionService expositionService = new ExpositionService();
        expositionService.deleteExposition(Long.valueOf(request.getParameter("id")));
        logger.info("Exposition deleted");
        return "redirect:/showExpositions";
    }
}
