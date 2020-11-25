package com.lowcostairline.beans.aircraft;

import java.util.ArrayList;

public class Aircrafts {
    private ArrayList<Aircraft> aircrafts;

    public  Aircrafts(){
        aircrafts = new ArrayList<>();
        Aircraft aircraft = new Aircraft();
        aircraft.setModel("Airbus");
        aircraft.setSeatAmount(5);
        aircraft.setTankCapacity(10);
        aircrafts.add(aircraft);

        aircraft = new Aircraft();
        aircraft.setTankCapacity(7);
        aircraft.setModel("Global");
        aircraft.setSeatAmount(10);
        aircrafts.add(aircraft);
    }

    public ArrayList<Aircraft> getAircrafts(){
        return aircrafts;
    }

}
