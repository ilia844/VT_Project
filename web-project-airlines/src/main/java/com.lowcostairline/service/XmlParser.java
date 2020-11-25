package com.lowcostairline.service;

import com.fasterxml.jackson.xml.XmlMapper;
import com.lowcostairline.beans.lowCostAirlines.LowCostAirlines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlParser {

    private final String XML_SOURCE = "lowcost.xml";

    public XmlParser(){

    }

    public LowCostAirlines loadModel(){
        try{
            XmlMapper xmlMapper = new XmlMapper();
            String xmlText = new String(Files.readAllBytes(Paths.get(XML_SOURCE)));
            return xmlMapper.readValue(xmlText, LowCostAirlines.class);
        }
        catch (IOException ex){
            return null;
        }
    }
}
