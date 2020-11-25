package com.lowcostairline.parsers;

import com.lowcostairline.beans.aircraft.Aircraft;
import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.beans.crew.AircraftCrew;
import com.lowcostairline.tags.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SaxParser extends DefaultHandler {
    private final static String xmlFile = "lowcost.xml";

    private static ArrayList<Aircraft> aircraftList = new ArrayList<>();
    private Aircraft aircraft;

    private static ArrayList<AircraftCrew> pilotList = new ArrayList<>();
    private AircraftCrew pilot;

    private static ArrayList<AircraftCrew> stewardList = new ArrayList<>();
    private AircraftCrew steward;

    private static ArrayList<LowCostAirlineTrip> lowCostAirlineTripList = new ArrayList<>();
    private LowCostAirlineTrip lowCostAirlineTrip;

    private StringBuilder text;
    private EntityTag entityTag = EntityTag.NONE;

    private static SaxParser instance = null;
    public static SaxParser getInstance() {
        if (instance == null) {
            instance = new SaxParser();
            try {
                XMLReader xmlReader = XMLReaderFactory.createXMLReader();
                xmlReader.setContentHandler(instance);

                xmlReader.parse(new InputSource(Objects.requireNonNull(instance.getClass().getClassLoader().
                        getResource(xmlFile)).toString()));
            } catch (SAXException | IOException | NullPointerException e) {
                System.out.println("Error occupied.");
                //logger.error(e.getMessage());
            }
        }
        return instance;
    }

    public ArrayList<Aircraft> getAircraftList(){
        return aircraftList;
    }

    public ArrayList<AircraftCrew> getPilotList(){
        return pilotList;
    }

    public ArrayList<AircraftCrew> getStewardList(){
        return stewardList;
    }

    public ArrayList<LowCostAirlineTrip> getLowCostAirlineTripList(){
        return lowCostAirlineTripList;
    }

    @Override
    public void startDocument() {
        System.out.println("Start parse XML...");
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        EntityTag rootTag = EntityTag.NONE;
        try {
            rootTag = EntityTag.valueOf(qName.toUpperCase());
            entityTag = rootTag;
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            //logger.error(e.getMessage());
        }
        switch (rootTag){
            case PILOT:
                pilot = new AircraftCrew();
                pilot.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case STEWARD:
                steward = new AircraftCrew();
                steward.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            case AIRCRAFT:
                aircraft = new Aircraft();
                aircraft.setId(Integer.parseInt(attributes.getValue("id")));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Тут будет логика реакции на конец элемента
        String qNameUpperCase = qName.toUpperCase();
        switch (entityTag) {
            case AIRCRAFT:{
                AircraftTag aircraftTag = AircraftTag.NONE;
                try{
                    aircraftTag = AircraftTag.valueOf(qNameUpperCase);
                }catch (IllegalArgumentException e){
                    System.out.println(e.toString());
                }
                switch (aircraftTag){
                    case MODEL:
                        aircraft.setModel(text.toString());
                        break;
                    case SEATAMOUNT:
                        aircraft.setSeatAmount(Integer.parseInt(text.toString()));
                        break;
                    case TANKCAPACITY:
                        aircraft.setTankCapacity(Integer.parseInt(text.toString()));
                        break;
                        default:
                            aircraftList.add(aircraft);
                            aircraft = null;
                            entityTag = EntityTag.NONE;
                            break;
                }
            }
            break;

            case STEWARD: {
                StewardTag stewardTag = StewardTag.NONE;
                try {
                    stewardTag = StewardTag.valueOf(qNameUpperCase);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.toString());
                }
                switch (stewardTag) {
                    case NAME:
                        steward.setName(text.toString());
                        break;
                    case SALARY:
                        steward.setSalary(Float.parseFloat(text.toString()));
                        break;
                    case WORKEXPERIENCE:
                        steward.setWorkExperience(Integer.parseInt(text.toString()));
                        break;
                    case LASTNAME:
                        steward.setLastName(text.toString());
                        break;
                    case JOBDESCRIBTION:
                        steward.setJobDescription(text.toString());
                        break;
                    default:
                        stewardList.add(steward);
                        steward = null;
                        entityTag = EntityTag.NONE;
                }

            }
            break;

            case PILOT:{
                PilotTag pilotTag = PilotTag.NONE;
                try{
                    pilotTag = PilotTag.valueOf(qNameUpperCase);
                }catch (IllegalArgumentException e){
                    System.out.println(e.toString());
                }
                switch(pilotTag){
                    case NAME:
                        pilot.setName(text.toString());
                        break;
                    case LASTNAME:
                        pilot.setLastName(text.toString());
                        break;
                    case JOBDESCRIBTION:
                        pilot.setJobDescription(text.toString());
                        break;
                    case SALARY:
                        pilot.setSalary(Double.parseDouble(text.toString()));
                        break;
                    case WORKEXPERIENCE:
                        pilot.setWorkExperience(Integer.parseInt(text.toString()));
                        break;
                        default:
                            pilotList.add(pilot);
                            pilot = null;
                            entityTag = EntityTag.NONE;
                }
            }
            break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        // Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).
    }
}
