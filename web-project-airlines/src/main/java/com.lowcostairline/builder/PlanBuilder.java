package com.lowcostairline.builder;

import com.lowcostairline.beans.aircraft.Aircraft;
import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.beans.crew.AircraftCrew;
import com.lowcostairline.exception.ParserException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanBuilder {
    private List<LowCostAirlineTrip> lowCostAirlineTrips;
    private LowCostAirlineTrip lowCostAirlineTrip;


    public List<LowCostAirlineTrip> getLowCostAirlineTrips() {
        return lowCostAirlineTrips;
    }

    public void build(String path) throws ParserException {
        try {
            lowCostAirlineTrips = new ArrayList<>();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(path);
            doc.normalizeDocument();
            Element root = doc.getDocumentElement();
            NodeList nodeList = root.getElementsByTagName("lowCostAirlineTrips");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                lowCostAirlineTrips.add(buildPlan(element));
            }
        }  catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ParserException(e.getMessage() , e);
        }
    }

    private LowCostAirlineTrip buildPlan(Element e) {

        lowCostAirlineTrip = new LowCostAirlineTrip();
        AircraftCrew pilot = new AircraftCrew();
        AircraftCrew steward = new AircraftCrew();
        Aircraft aircraft = new Aircraft();

        String category = getElementTextContent(e, "category", 0);
        lowCostAirlineTrip.setCategory(category);

        String name = getElementTextContent(e, "name", 0);
        pilot.setJobDescription(name);
        String lastName = getElementTextContent(e, "lastName", 0);
        pilot.setLastName(lastName);
        String workExperience = getElementTextContent(e, "workExperience", 0);
        pilot.setWorkExperience(Integer.parseInt(workExperience));
        String jobDescription = getElementTextContent(e, "jobDescription", 0);
        pilot.setJobDescription(jobDescription);
        String salary = getElementTextContent(e, "salary", 0);
        pilot.setSalary(Double.parseDouble(salary));

        lowCostAirlineTrip.setPilot(pilot);

        name = getElementTextContent(e, "name", 0);
        steward.setName(name);
        lastName = getElementTextContent(e, "lastName", 0);
        steward.setLastName(lastName);
        workExperience = getElementTextContent(e, "workExperience", 0);
        steward.setWorkExperience(Integer.parseInt(workExperience));
        jobDescription = getElementTextContent(e, "jobDescription", 0);
        steward.setJobDescription(jobDescription);
        salary = getElementTextContent(e, "salary", 0);
        pilot.setSalary(Double.parseDouble(salary));

        lowCostAirlineTrip.setSteward(steward);

        String model = getElementTextContent(e, "model", 0);
        aircraft.setModel(model);
        String seatAmount = getElementTextContent(e, "seatAmount", 0);
        aircraft.setSeatAmount(Integer.parseInt(seatAmount));
        String tankCapacity = getElementTextContent(e, "tankCapacity", 0);
        aircraft.setTankCapacity(Integer.parseInt(tankCapacity));

        lowCostAirlineTrip.setAircraft(aircraft);
        lowCostAirlineTrips.add(lowCostAirlineTrip);
        return lowCostAirlineTrip;
    }

    private String getElementTextContent(Element element, String elementName, int index) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(index);
        return node.getTextContent();

    }
}
