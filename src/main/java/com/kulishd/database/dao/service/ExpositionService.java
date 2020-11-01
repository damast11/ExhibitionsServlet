package com.kulishd.database.dao.service;

import com.kulishd.database.dao.ExpositionDAO;
import com.kulishd.database.pool.ConnectorDb;
import com.kulishd.entity.Exposition;
import com.kulishd.entity.Hall;
import com.kulishd.mapper.ExpositionMapper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpositionService implements ExpositionDAO {
    private static Logger logger = Logger.getLogger("ExpositionService");

    private static final String FIND_ALL_EXPOSITIONS = "select * from exposition";
    private static final String FIND_BY_ID = "select * from exposition where id=?";
    private static final String UPDATE_EXPOSITION = "update exposition set theme =?, price=?, date=? where id=? ";
    private static final String DELETE_EXPOSITION = "delete from exposition where id=?";
    private static final String ADD_EXPOSITION = "insert into exposition (theme,price,date) values(?,?,?)";
    private static final String FIND_HALLS_BY_EXPOSITION_ID = "select name from hall  right join exposition_hall on hall_id=id where exposition_id=?";
    private static final String UPDATE_COUNT_OF_TICKETS = "update exposition set count_of_tickets=count_of_tickets+1 where id=?";
    private static final String FILTER_BY_DATE = "select * from exposition where date=?";

    private final Connection connection = ConnectorDb.getConnection();
    private final ExpositionMapper expositionMapper = new ExpositionMapper();

    public List<Hall> findHallsByExpositionId(Long id) {
        List<Hall> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_HALLS_BY_EXPOSITION_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Hall hall = new Hall();
                hall.setName(resultSet.getString("name"));
                list.add(hall);
            }
            logger.info("findHallsByExpositionId returning: " + list);
            return list;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findHallsByExpositionId");
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Exposition> findAll() {
        List<Exposition> expositionList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_ALL_EXPOSITIONS);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Exposition exposition = expositionMapper.extractFromResultSet(rs);
                exposition.setHalls(findHallsByExpositionId(exposition.getId()));
                expositionList.add(exposition);
            }
            logger.info("findAll returning: " + expositionList);
            return expositionList;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findAll");
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public Exposition findExpositionById(Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) return expositionMapper.extractFromResultSet(rs);
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findExpositionById");
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean updateExposition(Exposition exposition) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_EXPOSITION);
            preparedStatement.setString(1, exposition.getTheme());
            preparedStatement.setBigDecimal(2, exposition.getPrice());
            preparedStatement.setDate(3, Date.valueOf(exposition.getDate()));
            preparedStatement.setLong(4, exposition.getId());
            preparedStatement.executeUpdate();
            logger.info("updateExposition updated");
            return true;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findExpositionById");
            throwables.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public boolean deleteExposition(Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(DELETE_EXPOSITION);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            logger.info("deleteExposition deleted");
            return true;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findExpositionById");
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
        return false;
    }

    @Override
    public boolean addExposition(Exposition exposition) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ADD_EXPOSITION);
            preparedStatement.setString(1, exposition.getTheme());
            preparedStatement.setBigDecimal(2, exposition.getPrice());
            Date date = Date.valueOf(exposition.getDate());
            preparedStatement.setDate(3, date);
            preparedStatement.executeUpdate();
            logger.info("Exposition added");
            return true;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findExpositionById");
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean buyTicket(Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_COUNT_OF_TICKETS);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            logger.info("Ticket bought ");
            return true;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findExpositionById");
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Exposition> filterByDate(LocalDate date) {
        List<Exposition> expositionList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FILTER_BY_DATE);
            preparedStatement.setDate(1, Date.valueOf(date));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Exposition exposition = expositionMapper.extractFromResultSet(rs);
                exposition.setHalls(findHallsByExpositionId(exposition.getId()));
                expositionList.add(exposition);
            }
            logger.info("filterByDate returning " + expositionList);
            return expositionList;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findExpositionById");
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
