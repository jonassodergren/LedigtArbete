/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.app.resolution;

import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.af.arbete.app.fasad.ArbeteFasad;
import se.af.arbete.app.fasad.ArbeteFasadImpl;
import se.af.arbete.app.services.ExceptionHandler;
import se.af.arbete.app.services.ForetagsRegister;
import se.af.arbete.app.services.LogService;
import se.af.arbete.app.services.RepositoryArbete;

/**
 *
 * @author jonas
 */
@Configuration
@ComponentScan
public class AppContextKomponent {
       
    private LogService logService;
    private ExceptionHandler exceptionHandler;
    private ForetagsRegister foretagsRegister;
    private RepositoryArbete repositoryArbete;
    
    @Autowired
    public void setLogService(LogService logService){
    this.logService = logService;
    }
    @Autowired
    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }
    @Autowired
    public void setForetagsRegister(ForetagsRegister foretagsRegister) {
        this.foretagsRegister = foretagsRegister;
    }
    @Autowired
    public void setRepositoryArbete(RepositoryArbete repositoryArbete) {
        this.repositoryArbete = repositoryArbete;
    }    
    
    @Bean
    public ArbeteFasad getArbeteFasad(){ 
        return new ArbeteFasadImpl(logService,exceptionHandler,foretagsRegister,repositoryArbete);
    }
    
    
}
