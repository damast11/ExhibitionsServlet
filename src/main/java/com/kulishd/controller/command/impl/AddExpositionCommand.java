package com.kulishd.controller.command.impl;

import com.kulishd.controller.command.Command;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Logger;

public class AddExpositionCommand implements Command {
    private static Logger logger = Logger.getLogger("AddExpositionCommand");

    @Override
    public String execute(HttpServletRequest request) {
        String theme = request.getParameter("theme");
        String priceStr = request.getParameter("price");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        float pricef = Float.parseFloat(priceStr);
        BigDecimal price = BigDecimal.valueOf(pricef);
        Exposition exposition = new Exposition(theme, price, date);
        ExpositionService expositionService = new ExpositionService();
        expositionService.addExposition(exposition);
        logger.info("AddExpositionCommand finished");
        return "redirect:/admin/addExposition.jsp";
    }
}
