package com.lowcostairline.command;

import com.lowcostairline.exception.ParserException;
import com.lowcostairline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String MESSAGE_ATTRIBUTE = "message";
    Page execute(HttpServletRequest request) throws ServiceException, ParserException;
}
