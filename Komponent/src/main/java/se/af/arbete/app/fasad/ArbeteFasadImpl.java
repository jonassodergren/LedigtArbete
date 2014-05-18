/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.fasad;

import se.af.arbete.app.contracts.RegistreratArbete;
import java.util.LinkedList;
import java.util.List;
import org.openide.util.Lookup;
import se.af.arbete.app.Arbete;
import se.af.arbete.app.fasad.command.UseCaseTransaction;
import se.af.arbete.app.fasad.command.FaultBarrierDecorator;
import se.af.arbete.app.fasad.command.RegistreraArbeteTransaction;
import se.af.arbete.app.fasad.command.TransactionalDecorator;
import se.af.arbete.app.services.ExceptionHandler;
import se.af.arbete.app.services.ForetagsRegister;
import se.af.arbete.app.services.LogService;
import se.af.arbete.app.services.RepositoryArbete;
import se.af.arbete.app.usecase.GetDetailsArbete;
import se.af.arbete.app.usecase.ListaMinaRegistreradeArbeten;
import se.af.arbete.app.usecase.RegistreraArbete;

/**
 *
 * @author jonas
 */
public class ArbeteFasadImpl implements ArbeteFasad{
  
    private final LogService logService;
    private final ExceptionHandler exceptionHandler;
    private final ForetagsRegister foretagsRegister;
    private final RepositoryArbete repositoryArbete;
    
    public ArbeteFasadImpl(LogService logService,ExceptionHandler exceptionHandler, ForetagsRegister foretagsRegister, RepositoryArbete repositoryArbete){
        this.logService = logService;
        this.exceptionHandler = exceptionHandler;
        this.foretagsRegister = foretagsRegister;
        this.repositoryArbete = repositoryArbete;
    }
    
    public void registreraArbete(String arbetsgivare, String beskrivning, String typ){
        
        logService.log("Start useCase registrera arbete");
        
        UseCaseTransaction cmd = new FaultBarrierDecorator( 
                                       new TransactionalDecorator( 
                                            new RegistreraArbeteTransaction(new RegistreraArbete(foretagsRegister, repositoryArbete),arbetsgivare, beskrivning, typ)));
        cmd.execute();
        
        logService.log("Arbetet är registrerat");
        
    }

    public List<RegistreratArbete> sammanfattningMinaRegistreradeArbeten(String orgnummer) {
        logService.log("Start useCase få sammanfattning över mina arbeten");
        
        ListaMinaRegistreradeArbeten useCase = new ListaMinaRegistreradeArbeten(repositoryArbete);
        List<Arbete> arbeten = useCase.ListaMinaRegistreradeArbeten(orgnummer);
       
        // Gör mappning till DTO-tänktet (datastrukturer!), nu går vi över en barriär från domänen till den stora stygga världen
        
        List<RegistreratArbete> arbetenDTO = new LinkedList<RegistreratArbete>();
        for(Arbete arbete:arbeten){
            arbetenDTO.add( new RegistreratArbete(arbete.getID(),arbete.getBeskrivning()));
        }
        
        logService.log("End useCase få sammanfattning över mina arbeten");
        
        return arbetenDTO;
    }
    
    public String getDetailedArbete(String id){
        logService.log("Start useCase få detaljer om ett arbete");
        
        GetDetailsArbete useCase = new GetDetailsArbete(repositoryArbete);
        Arbete arbete = useCase.getDetailedArbete(id); 
     
        // Inte världens snyggaste DTO...
        String result = "Orgnummer:"+arbete.getOrgNummer()+", Beskrivning:"+arbete.getBeskrivning();
     
        logService.log("End useCase få detaljer om ett arbete");
        
        return result;
    }
    
}
