package com.lowcostairline.command.common;

import com.lowcostairline.beans.airline.lowCostAirline.LowCostAirlineTrip;
import com.lowcostairline.beans.crew.AircraftCrew;
import com.lowcostairline.command.Command;
import com.lowcostairline.command.Page;
import com.lowcostairline.exception.ParserException;
import com.lowcostairline.parsers.xml.JaxBParser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.lowcostairline.command.Page.GET_PILOTS_PAGE_PATH;

public class GetPilotsCommand implements Command {

    @Override
    public Page execute(HttpServletRequest request) throws ParserException {
        String xmlPath = "C:/Users/marta/Downloads/Marta_Java/lab3/lab3/lowcost.xml";

        HttpSession session = request.getSession();
        JaxBParser jaxBParser = new JaxBParser();
        ArrayList<LowCostAirlineTrip> list1 = (ArrayList<LowCostAirlineTrip>) jaxBParser.parse(xmlPath);
        List<AircraftCrew> list = Arrays.asList(list1.get(0).getPilot(),list1.get(1).getPilot());
        session.setAttribute("list", list);

        return new Page(GET_PILOTS_PAGE_PATH, true);
    }
}
