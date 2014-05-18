/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.fasad.command;

/**
 *
 * @author jonas
 */
public class FaultBarrierDecorator implements UseCaseTransaction{

    private final UseCaseTransaction cmd;
    
    public FaultBarrierDecorator(UseCaseTransaction cmd){
        this.cmd = cmd;
    }
    
    public void execute() {
        try{
            cmd.execute();
        }catch(Exception e){
            //
        }
    }
    
}
