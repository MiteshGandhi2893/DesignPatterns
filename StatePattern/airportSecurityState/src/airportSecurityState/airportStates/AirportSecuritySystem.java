
package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;


public class AirportSecuritySystem {
  
    private AirportStateI low_risk;
  private  AirportStateI moderate_risk;
    private AirportStateI high_risk;
    private AirportStateI current_state;
    private int avgTrafficPerDay;
    private int avgPorihibitedItem;
    private String Filename;
    private int count_customers,count_prohibited_items,totaldays;
  public Results result;
    
    
    public AirportSecuritySystem(Results r)
    {
        low_risk=new LowRisk(this);
        moderate_risk=new ModerateRisk(this);
        high_risk=new HighRisk(this);
        count_customers=0;
        current_state=low_risk;
        totaldays=0;
        result=r;
        MyLogger.writeMessage("Inside the AirportSecuritySystem context class",MyLogger.DebugLevel.CONSTRUCTOR);

        
    }
    public int getTotalDays()
    {
        return totaldays;
    }
    public void setTotalDays(int count)
    {
        totaldays=count;
    }
    
    public int getCountCustomers()
    {
        return count_customers;
    }
    public void setCountCustomers(int count)
    {
        count_customers=count;
    }
          public int getProhibitedItems()
    {
        return count_prohibited_items;
    }
    public void setProhibitedItems(int count)
    {
        count_prohibited_items=count;
    }  
            
    
    
            
    public void setAiportState(AirportStateI newState)
    {
        current_state=newState;
    }
    public AirportStateI getStateLowRisk()
    {
        return low_risk;
    }
     public AirportStateI getStateModerateRisk()
    {
        return moderate_risk;
    }
      public AirportStateI getStateHighRisk()
    {
        return high_risk;
    }
      public AirportStateI getCurrentState()
    {
        return current_state;
    }
     public void setCurrentState(AirportStateI state)
     {
         current_state=state;
     }
    
    
    
    
    
}
