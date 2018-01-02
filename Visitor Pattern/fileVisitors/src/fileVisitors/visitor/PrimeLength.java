/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileVisitors.visitor;

import fileVisitors.AVLTree.AVLNode;
import fileVisitors.AVLTree.AVLTreeBuilder;
import fileVisitors.util.PrimeLengthCheck;

/**
 *
 * @author miteshgandhi
 */
public class PrimeLength implements VisitorI{

   PrimeLengthCheck plc;
 
   public PrimeLength(PrimeLengthCheck plIn)
   {
       plc=plIn;
   }

    @Override
    public void visit(AVLTreeBuilder tree) {
        
        
         plc.checkPrimeLength(tree.root); 
    }
     
    
    
    
    
    
    
}
