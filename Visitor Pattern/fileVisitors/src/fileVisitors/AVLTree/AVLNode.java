/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileVisitors.AVLTree;

import fileVisitors.util.MyLogger;

/**
 *
 * @author miteshgandhi
 */
public class AVLNode {
    private int count_word;
    private String word;
    private AVLNode left;
    private AVLNode right;
    private int height;

    AVLNode(String Word,int count)
    {
        MyLogger.writeMessage("In AVLNode Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
        count_word=count;
        word=Word;
        left=null;
        right=null;
        height=0;
        
    }
    
    
    
    
    
    public int getCount_word() {
        return count_word;
    }

    public String getWord() {
        return word;
    }

    public AVLNode getLeft() {
        return left;
    }

    public AVLNode getRight() {
        return right;
    }

    public int getHeight() {
        return height;
    }

    public void setCount_word(int Count_word) {
        count_word = Count_word;
    }

    public void setWord(String Word) {
        word = Word;
    }

    public void setLeft(AVLNode Left) {
        left = Left;
    }

    public void setRight(AVLNode Right) {
        right = Right;
    }

    public void setHeight(int Height) {
        height = Height;
    }
    
    
    
    
    
}
