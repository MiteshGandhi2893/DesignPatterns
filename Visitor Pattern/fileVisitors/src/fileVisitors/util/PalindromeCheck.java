/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileVisitors.util;

import fileVisitors.AVLTree.AVLNode;

/**
 *
 * @author miteshgandhi
 */
public class PalindromeCheck {
    
    
    public void checkPalimdrome(AVLNode root)
    {
          if(root!=null)
        {
            checkPalimdrome(root.getLeft());
            if(isPal(root.getWord().trim()))
             {
                 root.setWord(root.getWord().toUpperCase());
              }
             checkPalimdrome(root.getRight());
        }
    }
    public boolean isPal(String n)
    {
        
        if(n.length()>3)
        {
            String m = new StringBuffer(n).reverse().toString();
                if(m.equalsIgnoreCase(n)){
                    return true;
                }else{
                    return false;
                }
        }

        return false;
    }
    
}
