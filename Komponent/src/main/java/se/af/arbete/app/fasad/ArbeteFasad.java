/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.fasad;

import se.af.arbete.app.contracts.RegistreratArbete;
import java.util.List;

/**
 *
 * @author jonas
 */
public interface ArbeteFasad {
   
    public void registreraArbete(String arbetsgivare, String beskrivning, String typ);
    
    public List<RegistreratArbete> sammanfattningMinaRegistreradeArbeten(String orgnummer);
    
     public String getDetailedArbete(String id);
    
}
