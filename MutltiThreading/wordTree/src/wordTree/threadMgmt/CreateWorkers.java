/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordTree.threadMgmt;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import wordTree.AVLTree.AVLTreeBuilder;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

/**
 *
 * @author miteshgandhi
 */

public class CreateWorkers {
    FileProcessor fp;
    AVLTreeBuilder tree;
    
    public CreateWorkers(FileProcessor fp, AVLTreeBuilder tree) {
        MyLogger.writeMessage("In CreateWorkers Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
        this.fp=fp;
        this.tree=tree;
    }
    
    public void startPopulateWorker(int num_of_threads)
    {
        PopulateThread pth=new PopulateThread(fp,tree);
        Thread[] threads=new Thread[num_of_threads];
       for(int i=0;i<threads.length;i++)
       {
           threads[i]=new Thread(new PopulateThread(fp,tree) );
           threads[i].setName("Thread"+i);
       }

for(Thread thread :threads)
{
    thread.start();
}
        
         try
         {
             for(Thread thread : threads)
              {
                   thread.join();
                }
       
         }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
        
        
    }
    
     public void startDeleteWorkers(int num_of_threads,String []words)
     {
         Thread[] threads=new Thread[num_of_threads];
         
       for(int i=0;i<threads.length;i++)
       {
           threads[i]=new Thread(new DeleteThread(fp,tree,words[i]) );
           threads[i].setName("Thread"+i);
       }
         
       
       for(Thread thread:threads)
       {
           thread.start();
       }
        for(Thread thread:threads)
       {
             try {
                 thread.join();
             } catch (InterruptedException ex) {
                 Logger.getLogger(CreateWorkers.class.getName()).log(Level.SEVERE, null, ex);
             }
       }
       
       
       
     }
   
    
    
    
    
}
