/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.util;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author miteshgandhi
 */
public class Results implements FileDisplayInterface,StdoutDisplayInterface{

    private ArrayList<String> ResultData;
    private String Filename;
    private FileOutputStream outputFile;
    
    public Results()
    {
        ResultData=new ArrayList<String>();
    }
    public void setFilename(String filename)
    {
        
        Filename=filename;    
      
    }
        
    @Override
    public void writeToFile(String s) {
        
        try
        {
           
            
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

    @Override
    public void writeToStdout(String s) {
        for(int i=0;i<ResultData.size();i++)
        {
            System.out.println(ResultData.get(i));
        }
       
    }
    
    
    public void storeNewResult(String s)
    {
         ResultData.add(s);
    }
   
    
}
