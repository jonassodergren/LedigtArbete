/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.usecase;

import java.util.List;
import se.af.arbete.app.Arbete;
import se.af.arbete.app.services.RepositoryArbete;

/**
 *
 * @author jonas
 */
public class ListaMinaRegistreradeArbeten {
 
private final RepositoryArbete arbeteRepository;

public ListaMinaRegistreradeArbeten(RepositoryArbete arbeteRepository){
    this.arbeteRepository = arbeteRepository;
}

public List<Arbete> ListaMinaRegistreradeArbeten(String arbetsgivare){
    
    List<Arbete> arbeten = arbeteRepository.find(arbetsgivare);
    
    return arbeten;
}


}
