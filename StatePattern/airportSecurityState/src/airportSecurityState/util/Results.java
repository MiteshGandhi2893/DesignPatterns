/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airportSecurityState.util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author miteshgandhi
 */
public class Results implements FileDisplayInterface{

    private ArrayList<String> ResultData;
    private String Filename;
    private FileOutputStream outputFile;
    
    public Results()
    {
        ResultData=new ArrayList<String>();
        MyLogger.writeMessage("Inside Result Class", MyLogger.DebugLevel.CONSTRUCTOR);
    }
    public void setFilename(String filename)
    {
        
        Filename=filename;    
      
    }
        
    @Override
    public void writeToFile(String s) {
        
        try
        {
           
          MyLogger.writeMessage("Writing output to file", MyLogger.DebugLevel.FROM_RESULTS);
        outputFile=new FileOutputStream(Filename);
        String Content1="";//The sum of all the values in the array list is: "+Integer.parseInt(s);
        
        
        String Content="";
        
        for(String result:ResultData)
        {
            Content=Content+result+"\n";
        }
        Content1=Content1+Content;
        byte[] con=(Content1).getBytes();
        
         outputFile.write(con);

        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
            outputFile.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }


    
    
    public void storeNewResult(String s)
    {
        
            
        MyLogger.writeMessage("Inside Store Results function", MyLogger.DebugLevel.IN_RESULTS);
         ResultData.add(s);
        
    }
   
    
}
