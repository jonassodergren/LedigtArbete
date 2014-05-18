/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.fasad.command;

import se.af.arbete.app.services.TransactionService;

/**
 *
 * @author jonas
 */
public class TransactionalDecorator implements UseCaseTransaction{

    private final UseCaseTransaction cmd;
    private final TransactionService txService = null;
    
    public TransactionalDecorator(UseCaseTransaction cmd){
        this.cmd = cmd;
    }
    
    public void execute() {
        try{
            //txService.startTransaction();
            cmd.execute();
            //txService.comitTransaction();
        }catch(Exception e){
            //txService.rollback();
            throw new RuntimeException(e);
        }
    }
    
}
