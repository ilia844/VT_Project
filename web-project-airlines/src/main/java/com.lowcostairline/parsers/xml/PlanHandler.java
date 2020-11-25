package com.lowcostairline.parsers.xml;

import com.lowcostairline.beans.aircraft.Aircraft;
import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.beans.crew.AircraftCrew;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class PlanHandler extends DefaultHandler {

    private List<LowCostAirlineTrip> lowCostAirlineTrips;
    private LowCostAirlineTrip lowCostAirlineTrip;
    private String currentElement;
    private boolean name;

    private AircraftCrew pilot;
    private AircraftCrew steward;
    private Aircraft aircraft;

    public PlanHandler() {
        lowCostAirlineTrips = new ArrayList<>();
    }

    public List<LowCostAirlineTrip> getLowCostAirlineTrips() {
        return lowCostAirlineTrips;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        currentElement = qName;

        if ("pilot".equals(localName)) {
            name = false;
            pilot = new AircraftCrew();
            pilot.setId(Integer.parseInt(attrs.getValue("id")));
        } else if ("steward".equals(localName)) {
            name = true;

            steward = new AircraftCrew();
            steward.setId(Integer.parseInt(attrs.getValue("id")));
        } else if ("aircraft".equals(localName)) {
            aircraft = new Aircraft();
            aircraft.setId(Integer.parseInt(attrs.getValue("id")));
        } else if ("lowCostAirlineTrips".equals(localName)) {
            lowCostAirlineTrip = new LowCostAirlineTrip();
            lowCostAirlineTrip.setId(Integer.parseInt(attrs.getValue("id")));
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length).trim();
        if (!value.isEmpty()) {
            if (currentElement.equals("name") && !name) {
                pilot.setName(value);

            } else if (currentElement.equals("lastName") && !name) {
                pilot.setLastName(value);

            } else if (currentElement.equals("workExperience") && !name) {
                pilot.setWorkExperience(Integer.parseInt(value));

            } else if (currentElement.equals("jobDescription") && !name) {
                pilot.setJobDescription(value);

            } else if (currentElement.equals("salary") && !name) {
                pilot.setSalary(Double.parseDouble(value));

            } else if (currentElement.equals("name") && name) {
                steward.setName(value);

            } else if (currentElement.equals("lastName") && name) {
                steward.setLastName(value);

            } else if (currentElement.equals("workExperience") && name) {
                steward.setWorkExperience(Integer.parseInt(value));

            } else if (currentElement.equals("jobDescription") && name) {
                steward.setJobDescription(value);

            } else if (currentElement.equals("salary") && name) {
                steward.setSalary(Double.valueOf(value));

            } else if (currentElement.equals("model")) {
                aircraft.setModel(value);
            } else if (currentElement.equals("seatAmount")) {
                aircraft.setSeatAmount(Integer.valueOf(value));
            } else if (currentElement.equals("tankCapacity")){
                aircraft.setTankCapacity(Integer.parseInt(value));
            } else if (currentElement.equals("category")) {
                lowCostAirlineTrip.setCategory(value);
            }
        }
    }



    @Override
    public void endElement(String uri, String localName, String qName) {

        if ("lowCostAirlineTrips".equals(localName)) {
            lowCostAirlineTrip.setAircraft(aircraft);
            lowCostAirlineTrip.setSteward(steward);
            lowCostAirlineTrip.setPilot(pilot);
            lowCostAirlineTrips.add(lowCostAirlineTrip);
        }
    }

}
