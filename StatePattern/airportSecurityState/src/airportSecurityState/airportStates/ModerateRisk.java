/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

/**
 *
 * @author miteshgandhi
 */
public class ModerateRisk implements AirportStateI {

       AirportSecuritySystem airpotSystem;
        String lowOperation="1 3 5 7 9";
        String highOperation="2 3 5 8 9";
        String moderateOperation="2 4 6 8 10";
      
    
    public ModerateRisk(AirportSecuritySystem newAirportSystem ) {
        airpotSystem=newAirportSystem;
        MyLogger.writeMessage("Inside the Moderate Risk class",MyLogger.DebugLevel.CONSTRUCTOR);

        
    }
        
    @Override
    public AirportStateI tightenOrLoosenSecurity(Calculation cal) {
        
    AirportStateI state=airpotSystem.getCurrentState();
    int atpd=cal.avgTrafficPerDay(airpotSystem.getCountCustomers(),airpotSystem.getTotalDays());
    int apipd=cal.avgTrafficPerDay(airpotSystem.getProhibitedItems(), airpotSystem.getTotalDays());

     
     if(state instanceof ModerateRisk)
     {
         if((atpd>=8)||(apipd>=2))
         {
              MyLogger.writeMessage(highOperation, MyLogger.DebugLevel.IN_RUN);
              airpotSystem.result.storeNewResult(highOperation);
             state=airpotSystem.getStateHighRisk();
         }
        
         else  if((atpd>=4&&atpd<8)||(apipd>=1&&apipd<2))
         {
             MyLogger.writeMessage(moderateOperation, MyLogger.DebugLevel.IN_RUN);
                 airpotSystem.result.storeNewResult(moderateOperation);

             state=airpotSystem.getStateModerateRisk();
         }
         else
         {
              MyLogger.writeMessage(lowOperation, MyLogger.DebugLevel.IN_RUN);
              airpotSystem.result.storeNewResult(lowOperation);

           state=airpotSystem.getStateLowRisk();
         }
     }
     
    return state;
    
        
    }
}
