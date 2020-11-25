package com.lowcostairline.command.common;

import com.lowcostairline.beans.User;
import com.lowcostairline.command.Command;
import com.lowcostairline.command.Page;
import com.lowcostairline.service.UserServiceImpl;
import com.lowcostairline.service.exception.ServiceException;
import com.lowcostairline.utils.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        UserServiceImpl userService = new UserServiceImpl();
        HttpSession currentSession = request.getSession();
        String login = request.getParameter("login");
        String password = PasswordEncoder.encode(request.getParameter("password"));
        User user = userService.login(login, password);
        if (user == null) {
            return new Page(Page.LOGIN_PAGE_PATH, false, "error");
        }
        currentSession.setAttribute("user", user);
        return new Page(Page.MAIN_PAGE_PATH, true);

    }


}
