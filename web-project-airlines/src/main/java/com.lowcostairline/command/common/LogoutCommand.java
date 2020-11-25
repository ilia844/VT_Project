package com.lowcostairline.command.common;


import com.lowcostairline.beans.User;
import com.lowcostairline.command.Command;
import com.lowcostairline.command.Page;
import com.lowcostairline.service.UserServiceImpl;
import com.lowcostairline.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.lowcostairline.command.Page.MAIN_PAGE_PATH;

public class LogoutCommand implements Command {

    public Page execute(HttpServletRequest request) throws ServiceException {
        UserServiceImpl userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        userService.logout(user);
        session.invalidate();
        return new Page(MAIN_PAGE_PATH, true,"logout");
    }
}
