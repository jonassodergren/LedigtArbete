/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.usecase;

import se.af.arbete.app.Arbete;
import se.af.arbete.app.services.ForetagsRegister;
import se.af.arbete.app.services.RepositoryArbete;

/**
 *
 * @author jonas
 */
public class RegistreraArbete {

    private final ForetagsRegister foretagsRegistret;
    private final RepositoryArbete arbeteRepository;
    
    public RegistreraArbete(ForetagsRegister register, RepositoryArbete arbeteRepository){
        this.foretagsRegistret = register;
        this.arbeteRepository = arbeteRepository;
    }
    
    public void registreraArbete(String arbetsgivare, String beskrivning, String yrkeskod){
        
        // check if arbetsgivare exists
        // check if yrkeskod finns
        // check if arbete
        if( !foretagsRegistret.verifieraAttForetagFinnsRegistrerat(arbetsgivare) )
            throw new RuntimeException();
        
        arbeteRepository.create(new Arbete(arbetsgivare,beskrivning));
    }
    
}
