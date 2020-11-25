package com.lowcostairline.dao.impl;

import com.lowcostairline.beans.crew.AircraftCrew;
import com.lowcostairline.beans.lowCostAirlines.LowCostAirlines;
import com.lowcostairline.connection.ConnectionCreator;
import com.lowcostairline.dao.Dao;
import com.lowcostairline.dao.exception.DAOException;
import com.lowcostairline.service.XmlParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class StewardDao implements Dao<AircraftCrew> {

    public List<AircraftCrew> stewards = new ArrayList<>();

    public StewardDao(){
        Connection connection = ConnectionCreator.create();
        XmlParser xmlParser = new XmlParser();
        LowCostAirlines lowCostAirlines = xmlParser.loadModel();
        AircraftCrew steward = lowCostAirlines.getLowCostAirlineTrips().get(0).getSteward();
        stewards.add(steward);
        List<String> data= Arrays.asList(steward.getName(),steward.getLastName(),
                String.valueOf(steward.getWorkExperience()),steward.getJobDescription(),
                String.valueOf(steward.getSalary()));
        String query = "insert into employee(name, lastname, work_experience, job_description, salary) values(?,?,?,?,?)";

        try {
            executeQuery(query, data, connection);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        steward = lowCostAirlines.getLowCostAirlineTrips().get(1).getSteward();
        stewards.add(steward);
        data = Arrays.asList(steward.getName(), steward.getLastName(),
                String.valueOf(steward.getWorkExperience()),steward.getJobDescription(),
                String.valueOf(steward.getSalary()));

        try {
            executeQuery(query, data, connection);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }


    protected void executeQuery(String sqlQuery, List<String> parameters, Connection c) throws DAOException {
        try (PreparedStatement preparedStatement = buildStatement(sqlQuery, parameters,c)) {
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new DAOException(exception.getMessage(), exception);
        }
    }

    private PreparedStatement buildStatement(String sqlQuery, List<String> parameters,Connection connection) throws DAOException {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            if (parameters != null) {
                int parameterIndex = 1;
                for (String parameter : parameters) {
                    preparedStatement.setObject(parameterIndex++, parameter);
                }
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<AircraftCrew> get(int id)  throws DAOException {
        return Optional.ofNullable(stewards.get((int) id));
    }

    @Override
    public List<AircraftCrew> getAll() throws DAOException {
        return stewards;
    }

    @Override
    public void save(AircraftCrew entity) throws DAOException {
        stewards.add(entity);
    }

    @Override
    public void update(AircraftCrew entity, String[] params) throws Exception {
        if (params.length == 3){
            entity.setName(Objects.requireNonNull(params[0], "Name cannot be null."));
            entity.setLastName(Objects.requireNonNull(params[1], "Surname cannot be null."));
            entity.setWorkExperience(Integer.parseInt(params[2]));
        }
    }

    @Override
    public void delete(AircraftCrew entity) throws DAOException{
        stewards.remove(entity);
    }
}
