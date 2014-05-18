/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.infrastructur;

import se.af.arbete.app.services.ExceptionHandler;

/**
 *
 * @author jonas
 */
public class ExceptionHandlerNOOP implements ExceptionHandler{

    public void handle(Exception e) {
        // NOOP
    }
    
}
