package com.lowcostairline.command.factory;

import com.lowcostairline.command.Command;
import com.lowcostairline.command.CommandType;
import com.lowcostairline.command.common.HomePageCommand;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static com.lowcostairline.command.Command.MESSAGE_ATTRIBUTE;

public class CommandFactory {
    private static final Logger logger = Logger.getLogger(CommandFactory.class);

    public Command getCommand(HttpServletRequest req) {
        Command currCommand = new HomePageCommand();
        String command = req.getParameter("command");
        try {
            String commandTypeValue = command.toUpperCase();
            CommandType currentType = CommandType.getCommand(commandTypeValue);
            currCommand = currentType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            logger.error(String.format("Command - %s, cause exception.", command) + e);
            req.setAttribute(MESSAGE_ATTRIBUTE, "error");
        }
        return currCommand;
    }
}
