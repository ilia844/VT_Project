package com.lowcostairline.service.impl;

import com.lowcostairline.beans.aircraft.Aircraft;
import com.lowcostairline.dao.exception.DAOException;
import com.lowcostairline.dao.factory.DaoFactory;
import com.lowcostairline.dao.impl.AircraftDao;
import com.lowcostairline.service.AirLineService;
import com.lowcostairline.service.exception.ServiceException;

public class AircraftServiceImpl implements AirLineService<Aircraft> {
    @Override
    public void add(Aircraft aircraft) throws ServiceException {
        // TODO: Check params
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            AircraftDao aircraftDao = daoFactory.getAircraftDao();
            aircraftDao.save(aircraft);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void edit(Aircraft aircraft, String[] params) throws ServiceException {
        if (params == null)
            throw new ServiceException("You should pass params");
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            AircraftDao aircraftDao = daoFactory.getAircraftDao();
            aircraftDao.update(aircraft, params);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void remove(Aircraft aircraft) throws ServiceException{
        // TODO: Check params
        try {
            DaoFactory daoFactory = DaoFactory.getInstance();
            AircraftDao aircraftDao = daoFactory.getAircraftDao();
            aircraftDao.delete(aircraft);
        }
        catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
