package com.lowcostairline.command.common;

import com.lowcostairline.command.Command;
import com.lowcostairline.command.Page;

import javax.servlet.http.HttpServletRequest;

public class HomePageCommand implements Command {
    public Page execute(HttpServletRequest request) {
        return new Page("C:\\Users\\marta\\Downloads\\Marta_Java\\lab3\\lab3\\src\\main\\webapp\\index.jsp", false);
    }
}
