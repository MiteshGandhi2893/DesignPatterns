/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author miteshgandhi
 */
public class Calculation {
    
    AirportSecuritySystem airport;
    
    int countCustomer;
    int countitems;
    int countdays;
    int days;
    ArrayList<String> prohibitedItems=new ArrayList<String>();
      
    
    public Calculation(AirportSecuritySystem air)
    {
            MyLogger.writeMessage("Inside Helper class Calculation", MyLogger.DebugLevel.CONSTRUCTOR);
        airport=air;
        countCustomer=0;
        countitems=0;
        countdays=1;
        days=1;
        prohibitedItems.clear();
         prohibitedItems.add("Gun");
         prohibitedItems.add("NailCutter");
         prohibitedItems.add("Blade");
         prohibitedItems.add("Knife");
   
        
    }
    
    
    public int avgTrafficPerDay(int noOfCust,int totalDays)
    {
        int avg=(int)Math.floor(noOfCust/totalDays);
        return avg;
        
    }
    public int avgProhibitedItemsPerDay(int noOfItems,int totalDays)
    {
        int avg=(int)Math.floor(noOfItems/totalDays);
        return avg;
        
    }
    
    public void processData(String data)
    {
        HashMap<String,String> result=new HashMap<String,String>();
        countCustomer++;
        String[] customerDetails=data.split(";");
        for(String datas : customerDetails)
        {
            String[]temp=datas.split(":");
            result.put(temp[0], temp[1]);
        }
                
          if(Integer.parseInt(result.get("Day"))!=days)
               {
                   
                   countdays++;
                   days=countdays;
               }
               if(prohibitedItems.contains(result.get("Item")))
               {
                   countitems++;
               }
               airport.setCountCustomers(countCustomer);
               airport.setProhibitedItems(countitems);
               airport.setTotalDays(countdays);  
        
        
        
    }
  
    
    
}
