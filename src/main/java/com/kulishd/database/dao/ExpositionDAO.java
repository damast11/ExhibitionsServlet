package com.kulishd.database.dao;

import com.kulishd.entity.Exposition;

import java.time.LocalDate;
import java.util.List;

public interface ExpositionDAO {
 List<Exposition> findAll();
 Exposition findExpositionById(Long id);
 boolean updateExposition(Exposition exposition);
 boolean deleteExposition(Long id);
 boolean addExposition(Exposition exposition);

 boolean buyTicket(Long id);
 List<Exposition> filterByDate(LocalDate date);
}
