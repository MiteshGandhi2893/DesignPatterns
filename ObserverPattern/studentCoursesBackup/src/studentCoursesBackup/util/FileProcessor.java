
package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

import java.io.LineNumberReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileProcessor
{
    private BufferedReader Breader;
    public FileProcessor(BufferedReader reader)
    {
        Breader=reader;
    }
    
    
    /**
     * this function reads one line at a time from the file
     * @return one line at a time in String format
     * @throws IOException 
     */
	public String readLine()throws IOException
	{
                String Line="";
                Line=Breader.readLine();
                
                return Line;
        	
	}

}
