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
public class GetDetailsArbete {
    
private final RepositoryArbete arbeteRepository;

public GetDetailsArbete(RepositoryArbete arbeteRepository){
    this.arbeteRepository = arbeteRepository;
}

public Arbete getDetailedArbete(String ID){
    
    Arbete arbete = arbeteRepository.getArbete(ID);
    
    return arbete;
}
    
}
