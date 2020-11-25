package com.lowcostairline.parsers.xml;


import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.builder.PlanBuilder;
import com.lowcostairline.exception.ParserException;

import java.util.List;

public class DomParser implements XmlParser {

    @Override
    public List<LowCostAirlineTrip> parse(String path) throws ParserException {
        PlanBuilder planBuilder = new PlanBuilder();
        planBuilder.build(path);
        return planBuilder.getLowCostAirlineTrips();
    }
}
