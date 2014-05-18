/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app;

/**
 *
 * @author jonas
 */
public class Arbete {
    
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    private String orgNummer;
    private String beskrivning;
    
    public Arbete(String orgNummer,String beskrivning){        
        this.orgNummer = orgNummer;
        this.beskrivning = beskrivning;
    }
    
    public String getOrgNummer(){
        return orgNummer;
    }
    
    public String getBeskrivning(){
        return beskrivning;
    }
}
