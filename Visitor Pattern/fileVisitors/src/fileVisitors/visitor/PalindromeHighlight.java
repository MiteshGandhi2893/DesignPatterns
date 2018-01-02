/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileVisitors.visitor;

import fileVisitors.AVLTree.AVLNode;
import fileVisitors.AVLTree.AVLTreeBuilder;
import fileVisitors.util.PalindromeCheck;

/**
 *
 * @author miteshgandhi
 */
public class PalindromeHighlight implements VisitorI {

  
  PalindromeCheck pc;
  
  public PalindromeHighlight(PalindromeCheck pcIn)
  {
      pc=pcIn;
      
  }
    

    @Override
    public void visit(AVLTreeBuilder tree) {
        
        
        pc.checkPalimdrome(tree.root);
        
        
        
        
    }
    
}
