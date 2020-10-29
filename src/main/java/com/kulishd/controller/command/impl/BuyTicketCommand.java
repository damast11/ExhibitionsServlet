package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class BuyTicketCommand implements Command {
    private static Logger logger = Logger.getLogger("BuyTicketCommand");

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        ExpositionService expositionService = new ExpositionService();
        expositionService.buyTicket(id);
        logger.info("BuyTicketCommand finished ");
        return "ticketBought.jsp";
    }
}
