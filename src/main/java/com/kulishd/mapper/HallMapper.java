package com.kulishd.mapper;

import com.kulishd.entity.Exposition;
import com.kulishd.entity.Hall;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class HallMapper implements ObjectMapper<Hall>{
    @Override
    public Hall extractFromResultSet(ResultSet rs) throws SQLException {
        Hall hall = new Hall();
        hall.setId(rs.getLong("id"));
        hall.setName(rs.getString("name"));
        return hall;
    }

    @Override
    public Hall makeUnique(Map<Long, Hall> cache, Hall hall) {
        cache.putIfAbsent(hall.getId(), hall);
        return cache.get(hall.getId());
    }
}
