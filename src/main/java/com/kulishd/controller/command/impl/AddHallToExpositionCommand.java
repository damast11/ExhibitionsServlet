package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.database.dao.service.HallService;
import com.kulishd.entity.Exposition;
import com.kulishd.entity.Hall;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class AddHallToExpositionCommand implements Command {
    private static Logger logger = Logger.getLogger("AddHallToExpositionCommand");
    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        Long hallId = Long.valueOf(request.getParameter("hallId"));
        HallService hallService = new HallService();
        hallService.addHallsAndExpositions(id,hallId);
        logger.info("AddHallToExpositionCommand finished ");
        return "redirect:/showExpositions";
    }
}
