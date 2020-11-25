package com.lowcostairline.service;

import com.lowcostairline.service.exception.ServiceException;

public interface AirLineService<T> {
    void add(T aircraft) throws ServiceException;
    void edit(T aircraft, String[] params) throws ServiceException, Exception;
    void remove(T aircraft) throws ServiceException;
}

