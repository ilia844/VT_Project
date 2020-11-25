package com.lowcostairline.dao.impl;

import com.lowcostairline.beans.aircraft.Aircraft;
import com.lowcostairline.beans.lowCostAirlines.LowCostAirlines;
import com.lowcostairline.connection.ConnectionCreator;
import com.lowcostairline.dao.Dao;
import com.lowcostairline.dao.exception.DAOException;
import com.lowcostairline.service.XmlParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class AircraftDao implements Dao<Aircraft> {

    private List<Aircraft> aircrafts = new ArrayList<>();

    public AircraftDao(){
        Connection connection = ConnectionCreator.create();
        XmlParser xmlParser = new XmlParser();
        LowCostAirlines lowCostAirlines = xmlParser.loadModel();
        Aircraft aircraft = lowCostAirlines.getLowCostAirlineTrips().get(0).getAircraft();
        aircrafts.add(aircraft);
        List<String> data= Arrays.asList(aircraft.getModel(), String.valueOf(aircraft.getSeatAmount()),
                String.valueOf(aircraft.getTankCapacity()));

        String query = "insert into aircraft(model, seat_amount, tank_capacity) values(?,?,?)";
        try {
            executeQuery(query, data, connection);
        } catch (DAOException e) {
            e.printStackTrace();
        }

        aircraft = lowCostAirlines.getLowCostAirlineTrips().get(1).getAircraft();
        aircrafts.add(aircraft);
        data = Arrays.asList(aircraft.getModel(), String.valueOf(aircraft.getSeatAmount()),
                String.valueOf(aircraft.getTankCapacity()));

        try{
            executeQuery(query, data, connection);
        }
        catch (DAOException e){
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
    public Optional<Aircraft> get(int id) throws DAOException {
        return Optional.ofNullable(aircrafts.get((int) id));
    }

    @Override
    public List<Aircraft> getAll() throws DAOException{
        return aircrafts;
    }

    @Override
    public void save(Aircraft entity)  throws DAOException{
        aircrafts.add(entity);
    }

    @Override
    public void update(Aircraft entity, String[] params) throws DAOException{
        if (params.length == 3){
            entity.setModel(Objects.requireNonNull(params[0], "Model cannot be null."));
            entity.setSeatAmount(Integer.parseInt(params[1]));
            entity.setTankCapacity(Integer.parseInt(params[2]));
            aircrafts.add(entity);
        }
    }

    @Override
    public void delete(Aircraft entity)  throws DAOException{
        aircrafts.remove(entity);
    }
}
