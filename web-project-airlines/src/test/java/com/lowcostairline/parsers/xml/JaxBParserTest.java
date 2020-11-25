package com.lowcostairline.parsers.xml;

import com.lowcostairline.beans.aircraft.Aircraft;
import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.beans.crew.AircraftCrew;
import com.lowcostairline.exception.ParserException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JaxBParserTest {

    @Test
    public void parse() throws ParserException {
        LowCostAirlineTrip lowCostAirlineTripBlueSky;
        LowCostAirlineTrip lowCostAirlineTripAmerican;
        //given
        String xmlPath = "C:/Users/marta/Downloads/Marta_Java/lab3/lab3/lowcost.xml";

        //when
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
        lowCostAirlineTripBlueSky.setId(16);
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
        lowCostAirlineTripAmerican.setId(12);

        List<LowCostAirlineTrip> expected = new ArrayList<>(Arrays.asList(lowCostAirlineTripBlueSky,lowCostAirlineTripAmerican));

        //then
        JaxBParser jaxBParser = new JaxBParser();
        ArrayList<LowCostAirlineTrip> actuallyPlans = (ArrayList<LowCostAirlineTrip>) jaxBParser.parse(xmlPath);

        Assert.assertEquals(expected.get(0), actuallyPlans.get(0));
    }
}