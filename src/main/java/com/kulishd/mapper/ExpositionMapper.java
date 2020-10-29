package com.kulishd.mapper;

import com.kulishd.entity.Exposition;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;

public class ExpositionMapper implements ObjectMapper<Exposition> {

    @Override
    public Exposition extractFromResultSet(ResultSet rs) throws SQLException {
        Exposition exposition = new Exposition();
        exposition.setId(rs.getLong("id"));
        exposition.setTheme(rs.getString("theme"));
        exposition.setPrice(rs.getBigDecimal("price"));
        Date date = rs.getDate("date");
        exposition.setDate(date.toLocalDate());
        exposition.setCountOfTickets(rs.getInt("count_of_tickets"));
        return exposition;
    }

    @Override
    public Exposition makeUnique(Map<Long, Exposition> cache, Exposition exposition) {
        cache.putIfAbsent(exposition.getId(), exposition);
        return cache.get(exposition.getId());
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toLocalDate();
    }
}
