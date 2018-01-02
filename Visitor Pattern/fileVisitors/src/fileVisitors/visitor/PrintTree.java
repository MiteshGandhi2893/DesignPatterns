/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileVisitors.visitor;

import fileVisitors.AVLTree.AVLNode;
import fileVisitors.AVLTree.AVLTreeBuilder;
import fileVisitors.store.Results;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author miteshgandhi
 */
public class PrintTree implements VisitorI {
private List<String> words;
Results result;
String filename;
int debug_value;

public PrintTree(Results resultIn,String FilenameIn,int debugvaluein)
{
    result=resultIn;
    filename=FilenameIn;
    words=new ArrayList<String>();
    debug_value=debugvaluein;
}
 
    private void printingTree(AVLNode root)
    {
        
        if(root!=null)
        {
            printingTree(root.getLeft());
            words.add(root.getWord());
            printingTree(root.getRight());
        } 
    }

    @Override
    public void visit(AVLTreeBuilder tree) {
        
               printingTree(tree.root);
               result.setFilename(filename);
               Collections.sort(words);
               for(String word:words)
               {
                   result.storeNewResult(word);
                   
               }
               result.writeSchedulesToFile("");
	       if(debug_value==1)
               result.writeToScreen("");

        
        
    }
    
}
