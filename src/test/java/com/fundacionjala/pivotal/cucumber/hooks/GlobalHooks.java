package com.fundacionjala.pivotal.cucumber.hooks;

import com.fundacionjala.pivotal.exception.PropertiesInfoReadException;

import cucumber.api.java.Before;

import static com.fundacionjala.pivotal.framework.util.PropertiesInfo.getInstance;

/**
 * Created by HENRRY on 18/07/2016.
 */
public class GlobalHooks {
    private  boolean BEFORE_FLAG=false;
    @Before
    public void beforeAll(){
        if(!BEFORE_FLAG){
            if(!"".equalsIgnoreCase(getInstance().getEmail()) || !"".equalsIgnoreCase(getInstance().getApiToken()) || !"".equalsIgnoreCase(getInstance().getPassword())){
                try {
                    throw new PropertiesInfoReadException("Error reading the properties file");
                } catch (PropertiesInfoReadException e) {
                    e.printStackTrace();
                }
            }
            BEFORE_FLAG=true;
        }
    }
}
