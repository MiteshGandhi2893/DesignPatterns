package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import studentCoursesBackup.myTree.Node;
public class BinarySearchTree {
    
  public Node org_root,clone_root1,clone_root2;
  private FileProcessor fp;
 private Node node_found;
  
 /**
  * deletes the course from the course list of given Bnumber
  * @param Bnumber a key to search in the tree
  * @param course  to be removed from the course list
  *  
  */ 
public void delete(int Bnumber,String course)
{
    
    
   
    if(findStudent(org_root,Bnumber))
    {
        if(node_found.getCourse().contains(course))
        {
        node_found.getCourse().remove(course);
        node_found.notifyAll(course, Bnumber);
        }
        
        
    }
       
}
  /**
   * to insert a new node with bnumber and course in the tree and clone 
   * @param Bnumber key of the node
   * @param course course to be inserted to respective Bnumber 
   */
  
  
   public void insert(int Bnumber,String course)
   {
      
       try
       {
                     
           Node newStudent=new Node(Bnumber,course);
           Node cloneStudent1=(Node)newStudent.clone();
           Node cloneStudent2=(Node)newStudent.clone();   
           
           newStudent.registerObserver(cloneStudent1);
           newStudent.registerObserver(cloneStudent2);
           if(org_root ==null)
           {
               org_root =newStudent;
               clone_root1=(Node)org_root.clone();
               clone_root2=(Node)org_root.clone();
               org_root.registerObserver(clone_root1);
               org_root.registerObserver(clone_root2);
           
               return;
           }
        Node currentNode=org_root;
        Node clone1=clone_root1;
        Node clone2=clone_root2;
        Node parentNode,parentClone1,parentClone2=null;
        if(findStudent(org_root,Bnumber))
        {
            node_found.setCourses(course);
          node_found.getObserver().get(0).setCourses(course);
          node_found.getObserver().get(1).setCourses(course);
         }
        else
        {
        while(true)
        {
            parentNode=currentNode;
            parentClone1=clone1;
            parentClone2=clone2;
            
            if(Bnumber<currentNode.getBnumber())
            {
                currentNode=currentNode.getLeftChild();
               clone1=clone1.getLeftChild();
               clone2=clone2.getLeftChild();
               
                if(currentNode==null)
                {
                    parentNode.setLeftChild(newStudent);
                    parentClone1.setLeftChild(cloneStudent1);
                    parentClone2.setLeftChild(cloneStudent1);
                    return;
                }
            }
            else if(Bnumber>currentNode.getBnumber())
            {
                 currentNode=currentNode.getRightChild();
               clone1=clone1.getRightChild();
               clone2=clone2.getRightChild();
               
                if(currentNode==null)
                {
                    parentNode.setRightChild(newStudent);
                    parentClone1.setRightChild(cloneStudent1);
                    parentClone2.setRightChild(cloneStudent1);
                    return;
                }
                
            }
            
        }
        
        
        }
        
        
      }
      
       catch(Exception E)
       {
           E.printStackTrace();
       }
       
       
       
       
       
       
       
   }
   /**
    * Search for the respective Bnumber in the tree
    * @param root this is the start node of the tree to traverse it to the respective searching node
    * @param Bnumber to be searched in tbe tree
    * @return 
    */
   public boolean findStudent(Node root,int Bnumber)
   {
       boolean flag=false;
       while((root!=null)&&flag==false)
       {
           int root_bnumber=root.getBnumber();
           if(Bnumber<root_bnumber)
           {
               root=root.getLeftChild();
               
           }
           else if(Bnumber>root_bnumber)
           {
               root=root.getRightChild();
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
    /**
     * this function uses inorder traversal to store the result in resultset
     * @param root root of the tree
     * @param r Reference of the class Results
     */
   
    public void display(Node root,Results r){
		if(root!=null){
			display(root.getLeftChild(),r);
                        
                       r.storeNewResult(root.getBnumber()+" : "+root.getCourses());
		
			display(root.getRightChild(),r);
		}
	}
    
    
    
}
