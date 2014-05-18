/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.infrastructur;

import java.util.*;
import se.af.arbete.app.Arbete;
import se.af.arbete.app.services.RepositoryArbete;

/**
 *
 * @author jonas
 */
public class RepositoryArbeteInMemory implements RepositoryArbete{

    private final Map<String,Arbete> dataStore = new HashMap<String, Arbete>();
    
    public void save(Arbete arbete) {
        
    }

    public void create(Arbete arbete) {
        // Inte ratt ställe att skapa ID, borde troligtvis göras i domänen, se det som ett hack....
        arbete.setID(UUID.randomUUID().toString());
        //
        dataStore.put(arbete.getID(), arbete);
    }

    public Arbete getArbete(String id) {
        Arbete arbete = dataStore.get(id);
        return arbete;
    }

    public List<Arbete> find(String orgnummer) {
        List<Arbete> arbeten = new LinkedList<Arbete>();
        
        for(Arbete arbete:dataStore.values()){
            if(arbete.getOrgNummer().equalsIgnoreCase(orgnummer)){
                arbeten.add(arbete);
            }
        }
        return arbeten;
    }
    
}
