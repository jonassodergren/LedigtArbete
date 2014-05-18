/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.factory;

import java.util.List;
import javax.ejb.Stateless;
import org.openide.util.Lookup;
import se.af.arbete.app.contracts.RegistreratArbete;
import se.af.arbete.app.fasad.ArbeteFasad;
import se.af.arbete.app.fasad.ArbeteFasadImpl;
import se.af.arbete.app.services.ExceptionHandler;
import se.af.arbete.app.services.ForetagsRegister;
import se.af.arbete.app.services.LogService;
import se.af.arbete.app.services.RepositoryArbete;

/**
 *
 * @author jonas
 */
@Stateless
public class ArbeteFasadProxy implements ArbeteFasad{
   
    private final ArbeteFasad arbeteFasad;
    
    public ArbeteFasadProxy(){
        arbeteFasad = createArbeteFasad();
    }
    
    private ArbeteFasad createArbeteFasad(){
        LogService logService = Lookup.getDefault().lookup(LogService.class);
        ExceptionHandler exceptionHandler = Lookup.getDefault().lookup(ExceptionHandler.class);
        ForetagsRegister foretagsRegister = Lookup.getDefault().lookup(ForetagsRegister.class);
        RepositoryArbete repositoryArbete = Lookup.getDefault().lookup(RepositoryArbete.class);
        return new ArbeteFasadImpl(logService,exceptionHandler,foretagsRegister,repositoryArbete);
    }

    public void registreraArbete(String arbetsgivare, String beskrivning, String typ) {
        arbeteFasad.registreraArbete(arbetsgivare, beskrivning, typ);
    }

    public List<RegistreratArbete> sammanfattningMinaRegistreradeArbeten(String orgnummer) {
        return arbeteFasad.sammanfattningMinaRegistreradeArbeten(orgnummer);
    }

    public String getDetailedArbete(String id) {
        return arbeteFasad.getDetailedArbete(id);
    }
    
}
