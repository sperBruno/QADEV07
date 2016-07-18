package com.fundacionjala.pivotal.exceptions;

/**
 * @author HenrrySalinas.
 *
 * The purpose of this class is throw a custom exception when a exception
 * related to read data from properties files is raised
 */
public class PropertiesInfoReadException extends Exception {
    public PropertiesInfoReadException(String message){
        super(message);
    }
}
