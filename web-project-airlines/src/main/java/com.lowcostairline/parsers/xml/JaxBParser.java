package com.lowcostairline.parsers.xml;

import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.beans.lowCostAirlines.LowCostAirlines;
import com.lowcostairline.exception.ParserException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class JaxBParser implements XmlParser{

    public List<LowCostAirlineTrip> parse(String xmlPath) throws ParserException {
        JAXBContext jaxbContext;
        FileReader reader ;

        try {
            reader = new FileReader(xmlPath);
            JAXBContext jaxbContext2 = JAXBContext.newInstance(LowCostAirlines.class);
            Unmarshaller jaxbUnmarshaller2 = jaxbContext2.createUnmarshaller();
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader someSource = factory.createXMLEventReader(reader);
            JAXBElement<LowCostAirlines> userElement = jaxbUnmarshaller2.unmarshal(someSource, LowCostAirlines.class);
            LowCostAirlines responseObject = userElement.getValue();
            return responseObject.getLowCostAirlineTrips();
        } catch (JAXBException | FileNotFoundException | XMLStreamException e) {
            throw new ParserException(e.getMessage(),e);
        }

    }
}
