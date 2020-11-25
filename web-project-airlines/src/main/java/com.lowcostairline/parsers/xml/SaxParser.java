package com.lowcostairline.parsers.xml;

import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.exception.ParserException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements XmlParser {
    private PlanHandler planHandler;

    public SaxParser(PlanHandler planHandler) {
        this.planHandler = planHandler;
    }

    @Override
    public List<LowCostAirlineTrip> parse(String path) throws ParserException {

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(planHandler);
            reader.parse(path);
            return planHandler.getLowCostAirlineTrips();
        } catch (SAXException | IOException e) {
            throw new ParserException(e.getMessage() , e);
        }

    }
}
