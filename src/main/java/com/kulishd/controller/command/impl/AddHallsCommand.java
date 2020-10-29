package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.database.dao.service.HallService;
import com.kulishd.entity.Exposition;
import com.kulishd.entity.Hall;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Logger;

public class AddHallsCommand implements Command {
    private static Logger logger = Logger.getLogger("AddHallsCommand");
    @Override
    public String execute(HttpServletRequest request) {
        ExpositionService expositionService = new ExpositionService();
        Exposition exposition = expositionService.findExpositionById(Long.valueOf(request.getParameter("id")));
        HallService hallService = new HallService();
        List<Hall> halls = hallService.findHalls();
        request.setAttribute("halls",halls);
        request.setAttribute("exposition",exposition);
        logger.info("AddHallsCommand finished with attributes: "+ halls + " and " + exposition);
        return "/admin/addHalls.jsp";
    }
}
