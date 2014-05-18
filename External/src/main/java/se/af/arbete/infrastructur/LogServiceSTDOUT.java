/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.infrastructur;

import se.af.arbete.app.services.LogService;

/**
 *
 * @author jonas
 */
public class LogServiceSTDOUT implements LogService{

    public void log(String message) {
        System.out.println(message);
    }
    
}
