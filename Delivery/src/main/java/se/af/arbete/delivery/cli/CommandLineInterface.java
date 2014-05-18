package se.af.arbete.delivery.cli;

import asg.cliche.ShellFactory;

/**
 * Hello world!
 *
 */
public class CommandLineInterface 
{
    
    public static void main( String[] args ) throws Exception
    {
        run();
    }

    public static void run() throws Exception{
        CommandController controller = Assembler.assembleWithSpring();
        ShellFactory.createConsoleShell("Komponent LedigtArbete", "", controller)
            .commandLoop();
    }
    
}
