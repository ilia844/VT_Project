package com.lowcostairline.controller;

import com.lowcostairline.command.Command;
import com.lowcostairline.command.Page;
import com.lowcostairline.command.factory.CommandFactory;
import com.lowcostairline.exception.ParserException;
import com.lowcostairline.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.lowcostairline.command.Command.MESSAGE_ATTRIBUTE;

public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            process(request, response);
        } catch (ServiceException | ParserException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            process(request, response);
        } catch (ServiceException | ParserException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException,
            ServiceException, ParserException {
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommand(req);
        Page page = command.execute(req);
        boolean isRedirect = page.isRedirect();
        if (isRedirect) {
            redirect(page, req, resp);
        } else {
            forward(page, req, resp);
        }


    }

    private void redirect(Page page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = page.getPageUrl();
        response.sendRedirect(request.getContextPath() + url);
    }

    private void forward(Page page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = page.getPageUrl();
        String messageKey = page.getMessageKey();
        if (!"error".equals(messageKey)) {
            request.setAttribute(MESSAGE_ATTRIBUTE, messageKey);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
        requestDispatcher.forward(request, response);
    }
}
