/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileVisitors.visitor;

import fileVisitors.AVLTree.AVLNode;
import fileVisitors.AVLTree.AVLTreeBuilder;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author miteshgandhi
 */
public class PopulateVisitor implements VisitorI {

    
    
      private FileProcessor fp;
   private AVLTreeBuilder tree;
    public PopulateVisitor(FileProcessor fpIn)
    {
                    MyLogger.writeMessage("In PopulateVisitor Constructor", MyLogger.DebugLevel.CONSTRUCTOR);

        fp=fpIn;
        
    }
    
    
   

    @Override
    public void visit(AVLTreeBuilder tree) {
        
        
         try
        {
      
            String line="";
           while((line=fp.readLine())!=null)
           {

               String[] inArray=line.split(" ");
               for(String word :inArray)
               {
                   if(!word.trim().equals(""))
			    MyLogger.writeMessage("Populating "+word+" in tree ", MyLogger.DebugLevel.IN_RUN);
                   tree.insertWord(word);
               }
           }
            
            
        }
        catch(FileNotFoundException ex)
        {
           ex.printStackTrace();
        }
        catch(IOException ex)
        {
           ex.printStackTrace();
        }
        
        
    }
    
}
