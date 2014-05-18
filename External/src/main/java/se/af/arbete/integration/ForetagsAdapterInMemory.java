/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.integration;

import se.af.arbete.app.services.ForetagsRegister;

/**
 *
 * @author jonas
 */
public class ForetagsAdapterInMemory implements ForetagsRegister{
    
    public Boolean verifieraAttForetagFinnsRegistrerat(String orgNr) {
        return true;
    }
    
}
