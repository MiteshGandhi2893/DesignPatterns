/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.driver;

import airportSecurityState.airportStates.AirportSecuritySystem;
import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStates.Calculation;
import airportSecurityState.airportStates.LowRisk;
import airportSecurityState.airportStates.ModerateRisk;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.Results;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author miteshgandhi
 */
public class Driver {
    
    
    
   
    public static void main(String[] args)
    {

        int debuglevel=0;
        String outputFile="";
        String inputFile="";
         if(args.length!=3)
         {
             System.err.println("Please enter propr three arguments");
             System.exit(1);
         }
         else
         {
              inputFile=args[0];
             outputFile=args[1];
            if(Integer.parseInt(args[2])>=0&&Integer.parseInt(args[2])<=4)
            {
                debuglevel=Integer.parseInt(args[2]);
            }
            else
            {
                System.err.print("Please enter the debug level value between 0 and 4  including 0 and 4");
                System.exit(1);
            }
         }
         MyLogger.setDebugValue(debuglevel);
         Results result=new Results();
         AirportSecuritySystem as=new AirportSecuritySystem(result);
         Calculation cal=new Calculation(as);
   
       try
       {
           BufferedReader reader=new BufferedReader(new FileReader(inputFile));
           FileProcessor fp=new FileProcessor(reader);
           as.result.setFilename(outputFile);

            String line="";
           
           while((line=fp.readLine())!=null)
           {
              
              cal.processData(line);
              
           //System.out.println(as.getCountCustomers()+"      "+as.getProhibitedItems()+"      "+as.getTotalDays());
              
               AirportStateI state =as.getCurrentState();
               if(state instanceof LowRisk)
               {
                   state=state.tightenOrLoosenSecurity(cal);
               }
               else if(state instanceof ModerateRisk)
               {
                   state=state.tightenOrLoosenSecurity(cal);
                   
               }
               else
               {
                   state=state.tightenOrLoosenSecurity(cal);
               }
               
           
               
           }
           
          as.result.writeToFile("");
       }
       catch(FileNotFoundException ex)
       {
           ex.printStackTrace();
       } catch (IOException ex) {
          
        }
        
      
    }
   
}
