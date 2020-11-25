package com.lowcostairline.writer;


import com.fasterxml.jackson.xml.XmlMapper;
import com.lowcostairline.beans.aircraft.Aircrafts;
import com.lowcostairline.beans.lowCostAirlines.LowCostAirlines;
import com.lowcostairline.writer.exception.XmlOutInException;

import java.io.File;
import java.io.IOException;

public class XmlWriter {
    public void Write(LowCostAirlines lowCostAirlines, String fileName) throws XmlOutInException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), lowCostAirlines);
        } catch (IOException e) {
            throw new XmlOutInException("can't write to file = [" + fileName + "]", e);
        }
    }

    public void WriteAircraft(Aircrafts aircrafts, String fileName) throws XmlOutInException{
        try{
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), aircrafts);
        } catch (IOException e){
            throw new XmlOutInException("Can't write to file = [" + fileName + "]", e);
        }
    }
}
