/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.delivery.cli;

import asg.cliche.Command;
import asg.cliche.Param;
import java.util.LinkedList;
import java.util.List;
import se.af.arbete.app.contracts.RegistreratArbete;
import se.af.arbete.app.fasad.ArbeteFasad;

/**
 *
 * @author jonas
 */
public class CommandController {
   
    private final ArbeteFasad arbeteFasad;
    
    public CommandController(ArbeteFasad arbeteFasad){
        this.arbeteFasad = arbeteFasad;
    }
    
    @Command(name="registrera-arbete",abbrev="ra", description="Registrera ett nytt arbete")
    public String registreraArbete(@Param(name="orgNummer", description="Företagets organisationsnummer")String orgNummer,@Param(name="beskrivning", description="Beskrivning av profilen")String beskrivning,@Param(name="SSYK", description="Yrkesklassificering") String SSYK) {
       arbeteFasad.registreraArbete(orgNummer,beskrivning,SSYK);
       return "Arbete registrerat";
    }    
    
    @Command(name="get-details-arbete",abbrev="gda", description="Hämta detaljerad information om ett arbete")
    public String getDetailsArbete(@Param(name="id", description="Arbetets id-nummer")String id) {
       return arbeteFasad.getDetailedArbete(id);
    }
    
    @Command(name="sammanfattning-registrerade-arbeten",abbrev="sra", description="Sammanfattning över mitt företags registrerade arbeten")
    public List<String> sammanfattningMinaPlatser(@Param(name="orgNummer", description="Arbetsgivarens organisationsnummer")String orgNummer){
        List<RegistreratArbete> arbeten = arbeteFasad.sammanfattningMinaRegistreradeArbeten(orgNummer);
        List<String> result = new LinkedList<String>();
        for(RegistreratArbete arbete:arbeten){
           result.add("ID: " +arbete.getId() + ", Beskrivning: "+arbete.getBeskrivning());
       } 
        return result;
    }
       
}
