package com.lowcostairline.dao;

import com.lowcostairline.connection.ConnectionManager;
import com.lowcostairline.dao.exception.DAOException;

import java.sql.*;
import java.util.List;

public abstract class AbstractDAO<T> {

    private static final ThreadLocal<ConnectionManager> threadLocal = new ThreadLocal<>();


    protected abstract List<String> getEntityParameters(T entity);

    protected abstract T buildEntity(ResultSet result) throws DAOException;

    protected void executeQuery(String sqlQuery, List<String> parameters) throws DAOException {
        try (PreparedStatement preparedStatement = buildStatement(sqlQuery, parameters)) {
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new DAOException(exception.getMessage(), exception);
        }
    }

    protected T getEntity(String sqlQuery, List<String> params) throws DAOException {
        try {
            PreparedStatement preparedStatement = buildStatement(sqlQuery, params);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return buildEntity(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

    protected Connection getConnection() {
        ConnectionManager cm = new ConnectionManager();
        return cm.getConnection();
    }


    protected Integer insert(T entity, String sqlQuery) throws DAOException {
        List<String> params = getEntityParameters(entity);
        executeQuery(sqlQuery, params);
        return getLastInsertId();
    }

    private int getLastInsertId() throws DAOException {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT last_insert_id()");
            if (resultSet.next()) {
                return resultSet.getInt("last_insert_id()");
            }
            return 0;
        } catch (SQLException exception) {
            throw new DAOException(exception.getMessage(), exception);
        }
    }

    private PreparedStatement buildStatement(String sqlQuery, List<String> parameters) throws DAOException {
        try {
            Connection connection = getConnection();
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


}
