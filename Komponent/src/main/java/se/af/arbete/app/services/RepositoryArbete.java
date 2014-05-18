/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.services;

import java.util.List;
import se.af.arbete.app.Arbete;

/**
 *
 * @author jonas
 */
public interface RepositoryArbete {
    
    public Arbete getArbete(String id);
    
    public void save(Arbete arbete);
    
    public void create(Arbete arbete);
    
    public List<Arbete> find(String orgnummer);
    
}
