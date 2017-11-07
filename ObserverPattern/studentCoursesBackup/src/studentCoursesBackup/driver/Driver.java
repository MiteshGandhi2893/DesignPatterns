
package studentCoursesBackup.driver;
import java.io.BufferedReader;
import java.io.FileReader;
import studentCoursesBackup.util.BinarySearchTree;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;

public class Driver {
    
  
    public static void main(String[] args)
    {
        
        
 try
 {
     if(args.length!=5)
     {
         throw new RuntimeException("Expected 5 arguments");
     }
     else
     {
      
     
     
     String input=args[0];
     String delete=args[1];
     String output1=args[2];
     String output2=args[3];
     String output3=args[4];
     
     
        BufferedReader br=new BufferedReader(new FileReader(input));
          BinarySearchTree bs=new BinarySearchTree();
        FileProcessor fp=new FileProcessor(br);
       String line="";
       while((line=fp.readLine())!=null)
       {
           String[] array=line.split(":");
           int Bnumber=Integer.parseInt(array[0]);
           String course=array[1].toString();
           if(course.length()==1&&course.matches("[A-K?]"))
           {
               bs.insert(Bnumber, course);
               
           }
           
        
       }
       
         BufferedReader br1=new BufferedReader(new FileReader(delete));
        FileProcessor fp1=new FileProcessor(br1);
       String line1="";
       while((line1=fp1.readLine())!=null)
       {
           String[] array=line1.split(":");
           int Bnumber=Integer.parseInt(array[0]);
           String course=array[1].toString();
           if(course.length()==1&&course.matches("[A-K?]"))
           {
               
               
               
            bs.delete(Bnumber, course);
               
           }
           
           
           
           
       }
        
      
   Results r1=new Results();    
     r1.setFilename(output1);
        bs.display(bs.org_root,r1);
        r1.writeToFile("");
          Results r2=new Results(); 
        r2.setFilename(output2);
        bs.display(bs.clone_root1,r2);
        r2.writeToFile("");
          Results r3=new Results(); 
         r3.setFilename(output3);
        bs.display(bs.clone_root2,r3);
        r3.writeToFile("");

     }  
        
    }
    catch(Exception Ex)
    {
        Ex.printStackTrace();
    }
    }
    
    }    

