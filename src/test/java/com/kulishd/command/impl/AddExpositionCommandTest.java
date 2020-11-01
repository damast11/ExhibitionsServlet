package com.kulishd.command.impl;

import com.kulishd.controller.command.impl.AddExpositionCommand;
import com.kulishd.database.dao.service.ExpositionService;
import com.kulishd.entity.Exposition;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddExpositionCommandTest {
    private final static String path = "redirect:/admin/addExposition.jsp";
    private static Logger logger = Logger.getLogger("AddExpositionCommandTest");



    @Mock
    public HttpServletRequest request;
    @Mock
    public AddExpositionCommand addExpositionCommand;
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Test
    public void executeTest() {
        when(addExpositionCommand.execute(request)).thenReturn("redirect:/admin/addExposition.jsp");
        assertEquals("redirect:/admin/addExposition.jsp",addExpositionCommand.execute(request));

    }
}
