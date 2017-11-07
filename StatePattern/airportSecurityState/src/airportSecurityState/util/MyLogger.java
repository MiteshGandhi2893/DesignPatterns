/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.util;

/**
 *
 * @author miteshgandhi
 */
public class MyLogger {
    
    public static enum DebugLevel {RELEASE, FROM_RESULTS, IN_RESULTS, IN_RUN, CONSTRUCTOR};
        private static DebugLevel debugLevel;
    
    
        public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	      
          case 3:debugLevel=DebugLevel.IN_RUN;break;
          case 2:debugLevel=DebugLevel.IN_RESULTS;break;
          case 1:debugLevel=DebugLevel.FROM_RESULTS;break;

	  case 0: debugLevel = DebugLevel.RELEASE; break;
	}
    }
      public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }
      
      public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

        
        
        
}
    