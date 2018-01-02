/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordTree.AVLTree;

import wordTree.util.MyLogger;

/**
 *
 * @author miteshgandhi
 */
public class AVLTreeBuilder {
    
    
    public AVLNode root;
    public AVLNode node_found;
    private int count_Words;
    private int count_characters;
    private int count_unique_words;
    
  public  AVLTreeBuilder()
    {
        MyLogger.writeMessage("In AVLTreeBuilder Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
        root=null;
    }
    private int maxHeight(int h1,int h2)
    {
        int maxHeight=0;
        if(h1>h2)
            maxHeight=h1;
        else
            maxHeight=h2;
        
        return maxHeight;
    }
    
    public void printTree(AVLNode root)
    {
        if(root!=null)
        {
            printTree(root.getLeft());
            System.out.println(root.getWord()+"     "+root.getCount_word());
            printTree(root.getRight());
        }
    }
    
    public synchronized void insertWord(String word)
    {
        
     AVLNode node=new AVLNode(word,1);
     
     
     //System.out.println(word);
     if(root==null)
     {
         root=node;
         return;
     }
     AVLNode current=root;
     AVLNode parent=null;
     if(SearchWord(root,word))
     {
           //System.out.println( word);

        node_found.setCount_word(node_found.getCount_word()+1);
         
     }
     else
     {
     while(true)
     {
         parent=current;
         //System.out.println(word+"   "+current.getWord());
         if(word.compareTo(current.getWord())<0)
         {
             current=current.getLeft();
             if(current==null)
             {
                 parent.setLeft(node);
                 if((getHeight(node.getLeft())-getHeight(node.getRight()))==2)
                 {
                     System.out.println(node.getLeft()+"  "+word);
                     if(word.compareTo(node.getLeft().getWord())==-1)
                     {
                         node=rotateRightLeft(node);
                     }
                     else
                     {
                         node=rotateLeftLeft(node);
                     }
                 }
                  return;
                 
             }
            
         }
         else if(word.compareTo(current.getWord())>0)
         {
             current=current.getRight();
             if(current==null)
             {
                 parent.setRight(node);
                  if((getHeight(node.getRight())-getHeight(node.getLeft()))==2)
                 {
                     if(word.compareTo(node.getLeft().getWord())==1)
                     {
                         node=rotateLeftRight(node);
                     }
                     else
                     {
                         node=rotateRightRight(node);
                     }
                 }
                  return;
             }
           
         }
        
         
     }
     
     }        node.setHeight(maxHeight(getHeight(node.getLeft()),getHeight(node.getRight()))+1);

     
     
    }
    
    
    
    private  AVLNode rotateLeftRight(AVLNode leftright)
    {
          AVLNode newNode=leftright.getRight();
        leftright.setRight(newNode.getLeft());
        leftright.setLeft(leftright);
        
        leftright.setHeight(maxHeight(getHeight(leftright.getLeft()),getHeight(leftright.getRight()))+1);
         newNode.setHeight(maxHeight(getHeight(newNode.getLeft()),getHeight(newNode.getLeft()))+1);
         
         return newNode;
        
    }
     private AVLNode rotateRightLeft(AVLNode rightleft)
    {
       AVLNode newNode=rightleft.getLeft();
        rightleft.setLeft(newNode.getRight());
        newNode.setRight(rightleft);
        
        rightleft.setHeight(maxHeight(getHeight(rightleft.getLeft()),getHeight(rightleft.getLeft()))+1);
         newNode.setHeight(maxHeight(getHeight(newNode.getLeft()),getHeight(newNode.getLeft()))+1);
         
         return newNode;
    }
      private AVLNode rotateLeftLeft(AVLNode leftleft)
    {
        leftleft.setRight(rotateRightLeft(leftleft.getRight()));
         return rotateLeftRight(leftleft);
    }
     private AVLNode rotateRightRight(AVLNode rightright)
    {
        rightright.setRight(rotateLeftRight(rightright.getRight()));
         return rotateRightLeft( rightright );
    }
     
     public boolean SearchWord(AVLNode root,String word)
   {
       boolean flag=false;
       while((root!=null)&&flag==false)
       {
           String Word=root.getWord();
//System.out.println("root  "+word);
           if(word.compareTo(Word)<0)
           {
               root=root.getLeft();
               
           }
           else if(word.compareTo(Word)>0)
           {
               root=root.getRight();
           }
           else
           {
               flag=true;
               node_found=root;
               break;
           }
                
       }
       return flag;
   }
     
     
   public void deleteWord(String word,AVLNode root)
   {
       if(SearchWord(root,word))
       {
           if(node_found.getCount_word()!=0)
           {
               node_found.setCount_word(node_found.getCount_word()-1);
           }
       }
       
       
       
       
       
       
   }
     
   
     private int getHeight(AVLNode node)
     {
         int t=0;
         if(node==null)
             t=-1;
         else
             node.getHeight();
         return t;
     }
     public void countWords(AVLNode root)
     {
        
          if(root!=null)
        {
            countWords(root.getLeft());
           setCount_Words(getCount_Words()+root.getCount_word());
            countWords(root.getRight());
        }
    
        
              

     }
       public void countCharacters(AVLNode root)
     {
        
          if(root!=null)
        {
            countCharacters(root.getLeft());
           setCount_characters(getCount_characters()+(root.getWord().length()*root.getCount_word()));
            countCharacters(root.getRight());
        }
    
        
              

     }
       public void countUniqueWords(AVLNode root)
     {
        
          if(root!=null)
        {
	
            countUniqueWords(root.getLeft());
	    if(!(root.getCount_word()==0))
           setCount_unique_words(getCount_unique_words()+1);
            countUniqueWords(root.getRight());
        }
    
        
              

     }

    public void setCount_Words(int count_Words) {
        this.count_Words = count_Words;
    }

    public void setCount_characters(int count_characters) {
        this.count_characters = count_characters;
    }

    public void setCount_unique_words(int count_unique_words) {
        this.count_unique_words = count_unique_words;
    }

    public int getCount_Words() {
        return count_Words;
    }

    public int getCount_characters() {
        return count_characters;
    }

    public int getCount_unique_words() {
        return count_unique_words;
    }
     
}
