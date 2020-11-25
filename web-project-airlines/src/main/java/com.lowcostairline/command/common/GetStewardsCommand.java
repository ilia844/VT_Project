package com.lowcostairline.command.common;

import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.beans.crew.AircraftCrew;
import com.lowcostairline.command.Command;
import com.lowcostairline.command.Page;
import com.lowcostairline.exception.ParserException;
import com.lowcostairline.parsers.xml.PlanHandler;
import com.lowcostairline.parsers.xml.SaxParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

import static com.lowcostairline.command.Page.GET_STEWARDS_PAGE_PATH;

public class GetStewardsCommand implements Command {

    @Override
    public Page execute(HttpServletRequest request) throws ParserException {
        HttpSession session = request.getSession();
        SaxParser saxParser = new SaxParser(new PlanHandler());
        String xmlPath = "C:/Users/marta/Downloads/Marta_Java/lab3/lab3/lowcost.xml";
        List<LowCostAirlineTrip> list1 =saxParser.parse(xmlPath);
        List<AircraftCrew> list = Arrays.asList(list1.get(0).getSteward(),list1.get(1).getSteward());
        session.setAttribute("list", list);

        return new Page(GET_STEWARDS_PAGE_PATH, true);
    }
}
