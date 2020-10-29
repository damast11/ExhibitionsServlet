package com.kulishd.database.dao.service;

import com.kulishd.database.dao.HallDAO;
import com.kulishd.database.pool.ConnectorDb;
import com.kulishd.entity.Exposition;
import com.kulishd.entity.Hall;
import com.kulishd.mapper.HallMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HallService implements HallDAO {
    private static Logger logger = Logger.getLogger("HallService");
    private static final String FIND_HALL_BY_ID = "select * from hall where id=?";
    private static final String FIND_ALL_HALLS = "select * from hall";
    private static final String ADD_HALL_AND_EXPOSITIONS = "insert into exposition_hall (exposition_id,hall_id) values (?,?)";
    private static final String FIND_HALLS_BY_EXPOSITION_ID = "select name from hall  right join exposition_hall on hall_id=id where exposition_id=?";

    private final Connection connection = ConnectorDb.getConnection();
    private final HallMapper hallMapper = new HallMapper();

    @Override
    public Hall findHallById(Long id) {
        Hall hall = new Hall();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_HALL_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                hall.setId(rs.getLong("id"));
                hall.setName(rs.getString("name"));
                logger.info("findHallById returning");
            }
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findHallById");
            throwables.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return hall;
    }

    @Override
    public List<Hall> findHalls() {
        List<Hall> hallList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_ALL_HALLS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Hall hall = hallMapper.extractFromResultSet(rs);
                hallList.add(hall);
            }
            logger.info("findHallById returning " + hallList);
            return hallList;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findHalls");
            throwables.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean addHallsAndExpositions(Long expositionId, Long hallId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ADD_HALL_AND_EXPOSITIONS);

            preparedStatement.setLong(1, expositionId);
            preparedStatement.setLong(2, hallId);
            preparedStatement.executeUpdate();
            logger.info("findHallById returning " );
            return true;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method addHallsAndExpositions");
            throwables.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Hall> findHallsByExpositionId(Long id) {
        List<Hall> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_HALLS_BY_EXPOSITION_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Hall hall = hallMapper.extractFromResultSet(resultSet);
            list.add(hall);
            logger.info("findHallById returning " + list);
            return list;
        } catch (SQLException throwables) {
            logger.log(Level.SEVERE ,"SQL Exception in method findHallsByExpositionId");
            throwables.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


}