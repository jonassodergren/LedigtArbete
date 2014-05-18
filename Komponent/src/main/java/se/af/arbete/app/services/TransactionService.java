/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.services;

/**
 *
 * @author jonas
 */
public interface TransactionService {
    
    public void startTransaction();
    
    public void comitTransaction();
    
    public void rollback(); 
    
}
