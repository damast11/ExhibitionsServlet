package com.kulishd.database.dao;

import com.kulishd.entity.Hall;

import java.util.List;

public interface HallDAO {
    Hall findHallById(Long id);
    List<Hall> findHalls();

    boolean addHallsAndExpositions(Long expositionId,Long hallId);

    List<Hall> findHallsByExpositionId(Long id);
}
