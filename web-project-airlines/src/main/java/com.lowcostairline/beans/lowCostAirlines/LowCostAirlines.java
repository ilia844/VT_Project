package com.lowcostairline.beans.lowCostAirlines;


import com.lowcostairline.beans.aircraft.Aircraft;
import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.beans.crew.AircraftCrew;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LowCostAirlines{

    private List<LowCostAirlineTrip> lowCostAirlineTrips = new ArrayList<>();

    public LowCostAirlines(){
        LowCostAirlineTrip lowCostAirlineTripBlueSky;
        LowCostAirlineTrip lowCostAirlineTripAmerican;
        AircraftCrew pilot = new AircraftCrew();
        pilot.setName("Mark");
        pilot.setLastName("Lutz");
        pilot.setSalary(100);
        pilot.setJobDescription("Pilot");
        pilot.setWorkExperience(200);

        AircraftCrew steward = new AircraftCrew();
        steward.setName("Andrew");
        steward.setLastName("Gale");
        steward.setWorkExperience(200);
        steward.setJobDescription("Steward");
        steward.setSalary(100);

        Aircraft aircraft =  new Aircraft();
        aircraft.setModel("Airbus");
        aircraft.setSeatAmount(200);
        aircraft.setTankCapacity(5050);

        lowCostAirlineTripBlueSky = new LowCostAirlineTrip();
        lowCostAirlineTripBlueSky.setAircraft(aircraft);
        lowCostAirlineTripBlueSky.setPilot(pilot);
        lowCostAirlineTripBlueSky.setSteward(steward);
        lowCostAirlineTripBlueSky.setCategory("Middle");
        pilot = new AircraftCrew();
        pilot.setName("Jack");
        pilot.setLastName("Lop");
        pilot.setSalary(100);
        pilot.setJobDescription("Pilot");
        pilot.setWorkExperience(200);

        steward = new AircraftCrew();
        steward.setName("Mike");
        steward.setLastName("Bee");
        steward.setWorkExperience(200);
        steward.setJobDescription("Steward");
        steward.setSalary(100);

        aircraft =  new Aircraft();
        aircraft.setModel("Airbus");
        aircraft.setSeatAmount(200);
        aircraft.setTankCapacity(5050);

        lowCostAirlineTripAmerican = new LowCostAirlineTrip();
        lowCostAirlineTripAmerican.setPilot(pilot);
        lowCostAirlineTripAmerican.setAircraft(aircraft);
        lowCostAirlineTripAmerican.setSteward(steward);
        lowCostAirlineTripAmerican.setCategory("Middle");

        lowCostAirlineTrips.add(lowCostAirlineTripAmerican);
        lowCostAirlineTrips.add(lowCostAirlineTripBlueSky);
    }

    public List<LowCostAirlineTrip> getLowCostAirlineTrips(){
        return lowCostAirlineTrips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LowCostAirlines that = (LowCostAirlines) o;
        return Objects.equals(lowCostAirlineTrips, that.lowCostAirlineTrips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowCostAirlineTrips);
    }


}
