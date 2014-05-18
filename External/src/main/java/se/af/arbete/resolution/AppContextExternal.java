/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.af.arbete.resolution;

import org.springframework.context.annotation.*;
import se.af.arbete.app.services.ExceptionHandler;
import se.af.arbete.app.services.ForetagsRegister;
import se.af.arbete.app.services.LogService;
import se.af.arbete.app.services.RepositoryArbete;
import se.af.arbete.infrastructur.ExceptionHandlerNOOP;
import se.af.arbete.infrastructur.LogServiceSTDOUT;
import se.af.arbete.infrastructur.RepositoryArbeteInMemory;
import se.af.arbete.integration.ForetagsAdapterInMemory;

@Configuration
//@ComponentScan
public class AppContextExternal {

    @Bean
    public LogService stdoutLogService(){
        return new LogServiceSTDOUT();
    }
    
    @Bean
    public ExceptionHandler noopExceptionHandler(){
        return new ExceptionHandlerNOOP();
    }
        
    @Bean
    public RepositoryArbete inmemoryRepository(){
        return new RepositoryArbeteInMemory();
    }
            
    @Bean
    public ForetagsRegister inmemoryForetagsRegister(){
        return new ForetagsAdapterInMemory();
    }
    
    
}
