package com.lowcostairline.command;


import com.lowcostairline.command.common.*;

import java.util.HashMap;
import java.util.Map;

public enum CommandType {
    GET_STEWARDS(new GetStewardsCommand()),
    GET_AIRCRAFTS(new GetAircraftsCommand()),
    GET_PILOTS(new GetPilotsCommand()),
    COMMON_LOGIN(new LoginCommand()),
    COMMON_LOGOUT(new LogoutCommand()),
    COMMON_REGISTER(new RegisterCommand());
    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCurrentCommand() {
        return command;
    }

    private static final Map<String, CommandType> lookup = new HashMap<>();

    static {
        for (CommandType env : CommandType.values()) {
            lookup.put(env.toString(), env);
        }
    }

    public static CommandType getCommand(String type) {
        return lookup.get(type);
    }
}
