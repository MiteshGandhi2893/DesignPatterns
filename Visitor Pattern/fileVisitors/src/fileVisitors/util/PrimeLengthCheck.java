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
public class PrimeLengthCheck {
    
     public void checkPrimeLength(AVLNode root)
    {
        if(root!=null)
        {
        checkPrimeLength(root.getLeft());
        if(isPrime(root.getWord().trim().length()))
        {
            root.setWord(root.getWord().trim()+"-PRIME");
        }
        checkPrimeLength(root.getRight());
        } 
    }
     
    public boolean isPrime(int n)
    {
        if(n==2)
        {
            return true;
        }
        if(n%2==0||n==1)
        {
            
            return false;
        }
        for(int i=3;i<n;i++)
        {
              
            if(n%i==0)
            {

                return false;
            }
        }
        return true;
    }
    
    
}
