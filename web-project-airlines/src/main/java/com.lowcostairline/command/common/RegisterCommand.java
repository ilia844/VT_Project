package com.lowcostairline.command.common;


import com.lowcostairline.beans.User;
import com.lowcostairline.command.Command;
import com.lowcostairline.command.Page;
import com.lowcostairline.service.UserServiceImpl;
import com.lowcostairline.service.exception.ServiceException;
import com.lowcostairline.utils.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;

import static com.lowcostairline.command.Page.LOGIN_PAGE_PATH;

public class RegisterCommand implements Command {

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        UserServiceImpl userService = new UserServiceImpl();
        User user = buildUser(request);
        if (user == null) {
            return new Page(Page.MAIN_PAGE_PATH, false, "error");
        }

        boolean loginIsUnique = userService.isLoginAvailable(user.getLogin());
        if (!loginIsUnique) {
            return new Page(Page.MAIN_PAGE_PATH, false, "user already exist");
        }

        boolean emailIsUnique = userService.isEmailAvailable(user.getEmail());
        if (!emailIsUnique) {
            return new Page(Page.MAIN_PAGE_PATH, false, "email already registered");
        }

        userService.registerUser(user);
        return new Page(LOGIN_PAGE_PATH, true, "success");

    }

    private User buildUser(HttpServletRequest request) {
        User user = new User();
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String salary = request.getParameter("salary");
        String work = request.getParameter("work_experience");
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(PasswordEncoder.encode(password));
        user.setEmail(email);
        user.setSalary(salary);
        user.setWorkExperience(work);
        user.setStatus("offline");
        user.setJob("user");
        return user;
    }


}

