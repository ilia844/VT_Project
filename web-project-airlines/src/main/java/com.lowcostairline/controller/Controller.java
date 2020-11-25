package com.lowcostairline.controller;

import com.lowcostairline.beans.aircraft.Aircrafts;
import com.lowcostairline.beans.lowCostAirlines.LowCostAirlines;
import com.lowcostairline.writer.XmlWriter;
import com.lowcostairline.writer.exception.XmlOutInException;

public class Controller {

    public void writeToFile(){
        LowCostAirlines lowCostAirlines = new LowCostAirlines();

        XmlWriter xmlWriter = new XmlWriter();
        try {
            xmlWriter.Write(lowCostAirlines, "lowcost.xml");
        }catch (XmlOutInException e){
            System.out.println("Cannot write to the file.");
        }
    }

    public void WriteAircraftToFile(){
        Aircrafts aircraft = new Aircrafts();

        XmlWriter xmlWriter = new XmlWriter();
        try{
            xmlWriter.WriteAircraft(aircraft, "aircraft.xml");
        } catch (XmlOutInException e){
            System.out.println("Error while writing to file.");
        }
    }

    public void execute(){
        //Command displayHelp = new DisplayHelp(
    }
}
