
package fileVisitors.driver;

import fileVisitors.AVLTree.AVLNode;
import fileVisitors.AVLTree.AVLTreeBuilder;
import fileVisitors.store.Results;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.util.PalindromeCheck;
import fileVisitors.util.PrimeLengthCheck;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;
import fileVisitors.visitor.VisitorI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Driver {
  
    
    public static void main(String[] args)
    {
        try
         {
             
            if(args.length!=3)
            {
                System.err.println("Please enter 3 arguments");
                
            }
            else
            {
                if(Integer.parseInt(args[2])>=0&&Integer.parseInt(args[2])<=4)
                {
                    String input=args[0];
                    String output=args[1];
                    int debug_level=Integer.parseInt(args[2]);
                    MyLogger.setDebugValue(debug_level);
                    BufferedReader reader=new BufferedReader(new FileReader(input));
                    FileProcessor fp=new FileProcessor(reader);
                     AVLTreeBuilder tree=new AVLTreeBuilder();
                    PalindromeCheck pc=new PalindromeCheck();
                     PrimeLengthCheck plc=new PrimeLengthCheck();
                    VisitorI populateVisitor=new PopulateVisitor(fp);
             
                    VisitorI palimdromeVisitor=new PalindromeHighlight(pc);
                     VisitorI primeLengthVisitor=new PrimeLength(plc);
                     Results result=new Results();
                     VisitorI printVisitor=new PrintTree(result,output,debug_level);
             
               tree.accept(populateVisitor);
               tree.accept(palimdromeVisitor);
               tree.accept(primeLengthVisitor);
               tree.accept(printVisitor);
               
                    
                }
                else
                {
                    System.err.println("Please enter debug value between 0 and 4");
                }
            }
          
         }
          catch(FileNotFoundException ex)
         {
             ex.printStackTrace();
         }
    }
    
}


