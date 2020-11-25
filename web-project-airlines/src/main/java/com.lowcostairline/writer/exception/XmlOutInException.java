package com.lowcostairline.writer.exception;

public class XmlOutInException extends Exception {
    private static final long serialVersionUID = 1L;

    public XmlOutInException(){
        super();
    }

    public XmlOutInException(String message){
        super(message);
    }

    public XmlOutInException(Exception e){
        super(e);
    }

    public XmlOutInException(String message, Exception e){
        super(message, e);
    }
}
