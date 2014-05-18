/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.contracts;

/**
 *
 * @author jonas
 */
public class RegistreratArbete {
    private String id;
    private String beskrivning;

    public String getBeskrivning() {
        return beskrivning;
    }

    public String getId() {
        return id;
    }
    
    public RegistreratArbete(String id,String beskrivning){
        this.id = id;
        this.beskrivning = beskrivning;
    }
    
    
}
