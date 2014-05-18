/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.fasad.command;

import se.af.arbete.app.usecase.RegistreraArbete;

/**
 *
 * @author jonas
 */
public class RegistreraArbeteTransaction implements UseCaseTransaction{

    private final RegistreraArbete registreraArbete;
    private final String arbetsgivare;
    private final String beskrivning;
    private final String typ;
    
    public RegistreraArbeteTransaction(RegistreraArbete useCase,String arbetsgivare, String beskrivning, String typ){
        this.registreraArbete = useCase;
        this.arbetsgivare = arbetsgivare;
        this.beskrivning = beskrivning;
        this.typ = typ;
    }
    
    public void execute() {
        registreraArbete.registreraArbete(arbetsgivare, beskrivning, typ);
    }
    
}
