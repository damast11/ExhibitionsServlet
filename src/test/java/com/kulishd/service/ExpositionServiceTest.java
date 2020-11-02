package com.kulishd.service;

import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;
import com.kulishd.entity.Hall;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ExpositionServiceTest {
    private static Logger logger = Logger.getLogger("ExpositionService");

    private ExpositionService expositionService;

    @Before
    public void setUp()  {
        expositionService = new ExpositionService();
    }

    @Test
    public void findHallsByExpositionIdTest() {
        List<Hall> hallsByExpositionId = expositionService.findHallsByExpositionId(23L);
        logger.info(String.valueOf(hallsByExpositionId));
        assertFalse(hallsByExpositionId.size() > 0);
    }

    @Test
    public void findAllTest() {
        List<Exposition> all = expositionService.findAll();
        logger.info(String.valueOf(all));
        assertTrue(all.size() > 0);
    }

    @Test
    public void findExpositionByIdTest() {
        Exposition expositionById = expositionService.findExpositionById(22L);
        logger.info(String.valueOf(expositionById));
        assertNotNull(expositionById);
    }

    @Test
    public void deleteExpositionTest() {
        boolean b = expositionService.deleteExposition(21L);
        logger.info(String.valueOf(b));
        assertTrue(b);
    }
    @Test
    public void addExpositionTest(){
        Exposition exposition = new Exposition();
        exposition.setTheme("Test");
        exposition.setPrice(BigDecimal.valueOf(100));
        exposition.setDate(LocalDate.now());
        boolean b = expositionService.addExposition(exposition);
        logger.info(String.valueOf(b));
        assertTrue(b);
    }

    @Test
    public void buyTicket(){
        boolean b = expositionService.buyTicket(21L);
        logger.info(String.valueOf(b));
        assertTrue(b);
    }

}
