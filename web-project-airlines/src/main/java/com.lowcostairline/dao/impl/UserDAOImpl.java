package com.lowcostairline.dao.impl;

import com.lowcostairline.beans.User;
import com.lowcostairline.dao.AbstractDAO;
import com.lowcostairline.dao.exception.DAOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserDAOImpl extends AbstractDAO<User> {

    public User login(String login, String password) throws DAOException {
        String sqlQuery = "SELECT * FROM user WHERE login=? AND password=?";
        List<String> params = Arrays.asList(login, password);
        return getEntity(sqlQuery, params);
    }

    public void updateStatus(User user) throws DAOException {
        String sqlQuery = "UPDATE user SET status=? WHERE id=?";
        String status = user.getStatus();
        String id = String.valueOf(user.getId());
        List<String> params = Arrays.asList(status, id);
        executeQuery(sqlQuery, params);
    }

    public boolean containsLogin(String login) throws DAOException {
        String sqlQuery = "SELECT * FROM user WHERE login=?";
        List<String> params = Collections.singletonList(login);
        return getEntity(sqlQuery, params) == null;
    }

    public boolean containsEmail(String email) throws DAOException {
        String sqlQuery = "SELECT * FROM user WHERE email=?";
        List<String> params = Collections.singletonList(email);
        return getEntity(sqlQuery, params) == null;
    }

    public boolean containsPhone(String phone) throws DAOException {
        String sqlQuery = "SELECT * FROM user WHERE phone=?";
        List<String> params = Collections.singletonList(phone);
        return getEntity(sqlQuery, params) == null;
    }

    public void insertUser(User user) throws DAOException {
        String fields = "insert into user (name , lastname ,work_experience, job_description, salary, login, password, status,email) values(?,?,?,?,?,?,?,?,?)";
        insert(user, fields);
    }

    public void deleteUserById(int id) throws DAOException {
        String sqlQuery = "update user set status = 'deleted' where id = ?";
        List<String> params = Collections.singletonList(String.valueOf(id));
        executeQuery(sqlQuery, params);
    }

    @Override
    protected List<String> getEntityParameters(User entity) {

        String firstName = entity.getFirstName();
        String lastName = entity.getLastName();
        String login = entity.getLogin();
        String password = entity.getPassword();
        String email = entity.getEmail();
        String salary = entity.getSalary();
        String status = entity.getStatus();
        String work = entity.getWorkExperience();
        String job = entity.getJob();
        return Arrays.asList( firstName, lastName, work, job, salary, login, password, status,email);
    }

    @Override
    protected User buildEntity(ResultSet result) throws DAOException {
        try {
            User user = new User();
            int id = result.getInt("id");
            user.setId(id);
            String firstName = result.getString("name");
            user.setFirstName(firstName);
            String lastName = result.getString("lastname");
            user.setLastName(lastName);
            String login = result.getString("login");
            user.setLogin(login);
            String password = result.getString("password");
            user.setPassword(password);
            String email = result.getString("email");
            user.setEmail(email);
            String salary = result.getString("salary");
            user.setSalary(salary);
            String work = result.getString("work_experience");
            user.setWorkExperience(work);
            String job = result.getString("job_description");
            user.setJob(job);
            String status = result.getString("status");
            user.setStatus(status);

            return user;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        }
    }

}
