package com.lowcostairline.parsers.xml;

import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import jdk.nashorn.internal.runtime.ParserException;

import java.util.List;

public interface XmlParser {
    List<LowCostAirlineTrip> parse(String path) throws ParserException, com.lowcostairline.exception.ParserException;

}
