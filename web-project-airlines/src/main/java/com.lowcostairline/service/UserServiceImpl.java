package com.lowcostairline.service;

import com.lowcostairline.beans.User;
import com.lowcostairline.dao.exception.DAOException;
import com.lowcostairline.dao.impl.UserDAOImpl;
import com.lowcostairline.service.exception.ServiceException;

public class UserServiceImpl {

    private final UserDAOImpl userDAO = new UserDAOImpl();

    public User login(String login, String password) throws ServiceException {
        try {
            User user = userDAO.login(login, password);
            if (user == null) {
                return null;
            }
            user.setStatus("online");
            userDAO.updateStatus(user);
            return user;
        } catch (DAOException e) {
            throw new ServiceException("Exception during user login operation login = [" + login + "]", e);
        }
    }

    public void logout(User user) throws ServiceException {
        try {
            user.setStatus("offline");
            userDAO.updateStatus(user);

        } catch (DAOException e) {
            throw new ServiceException("Exception during logout operation login =[" + user + "]", e);
        }
    }

    public boolean isLoginAvailable(String login) throws ServiceException {
        try {
            return userDAO.containsLogin(login);
        } catch (DAOException e) {
            throw new ServiceException("Exception during check user login for unique operation login =[" + login + "]", e);
        }
    }

    public boolean isEmailAvailable(String email) throws ServiceException {
        try {
            return userDAO.containsEmail(email);
        } catch (DAOException e) {
            throw new ServiceException("Exception during check user email for unique operation email =[" + email + "]", e);
        }
    }


    public void registerUser(User user) throws ServiceException {
        try {
            userDAO.insertUser(user);
        } catch (DAOException e) {
            throw new ServiceException("Exception during user register operation user = [" + user.toString() + "]", e);
        }
    }


}
