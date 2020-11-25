package com.lowcostairline.service.factory;

import com.lowcostairline.service.AirLineService;
import com.lowcostairline.service.impl.AircraftServiceImpl;
import com.lowcostairline.service.impl.PilotServiceImpl;
import com.lowcostairline.service.impl.StewardServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final AirLineService aircraftService = new AircraftServiceImpl();
    private final AirLineService pilotService = new PilotServiceImpl();
    private final AirLineService stewardService = new StewardServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public AirLineService getAircraftService(){
        return aircraftService;
    }

    public AirLineService getPilotService(){
        return pilotService;
    }

    public AirLineService getStewardService(){
        return stewardService;
    }
}
