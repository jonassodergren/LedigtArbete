/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.delivery.cli;

import org.openide.util.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.af.arbete.app.fasad.ArbeteFasad;

/**
 *
 * @author jonas
 */
public class Assembler {
 
    public static CommandController assembleWithLookup(){
        ArbeteFasad fasad = Lookup.getDefault().lookup(ArbeteFasad.class);
        return new CommandController(fasad);
    }
    
    public static CommandController assembleWithSpring(){
      ApplicationContext ctx = new AnnotationConfigApplicationContext("se.af");
      ArbeteFasad arbeteFasad = ctx.getBean(ArbeteFasad.class);
      return new CommandController(arbeteFasad);
    }
    
}
