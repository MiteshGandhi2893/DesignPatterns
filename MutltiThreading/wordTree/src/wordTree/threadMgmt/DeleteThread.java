/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordTree.threadMgmt;

import wordTree.AVLTree.AVLTreeBuilder;
import wordTree.util.FileProcessor;

/**
 *
 * @author miteshgandhi
 */
public class DeleteThread implements Runnable {
  private FileProcessor fp;
   private AVLTreeBuilder tree;
   private String word;
    public DeleteThread(FileProcessor fpIn,AVLTreeBuilder treeIn,String wordIn)
    {
        fp=fpIn;
        tree=treeIn;
        word=wordIn;
    }
    @Override
    public  void run() {
        
        try
        {
            tree.deleteWord(word, tree.root);
          
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }  
}
