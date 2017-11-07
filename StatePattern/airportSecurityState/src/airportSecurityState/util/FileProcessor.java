/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airportSecurityState.util;
import java.io.BufferedReader;
import java.io.IOException;

public class FileProcessor
{
    private BufferedReader Breader;
    public FileProcessor(BufferedReader reader)
    {
        Breader=reader;
        
        
        
        
        
    }
	public String readLine()throws IOException
	{
                String Line="";
                Line=Breader.readLine();
                
                return Line;
        	
	}

}