/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.myTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Observer;
import java.util.Set;

public class Node implements SubjectI,ObserverI,Cloneable{
    

    private Node leftChild;
    private Node rightChild;
    int bNumber;
    Set<String>courses;
    private  ArrayList<Node>ObserverList;
    
/**
 * get list of Observer registered
 * @return the observer List
 */
 
 public ArrayList<Node> getObserver()
 {
     return ObserverList;
 }
 /**
  * Constructor to create a new node with values
  * @param Bnumber key of the node
  * @param course  course associated with Bnumber
  */
    public Node(int Bnumber,String course)
    {
         courses=new HashSet<String>();
         ObserverList=new ArrayList<Node>();
         courses.add(course);
         bNumber=Bnumber;
        leftChild=null;
        rightChild=null;
        
        
    }
    /**
     * to get the left child of the node
     * @return the left child of the node
     */
    public Node getLeftChild()
    {
        return leftChild;
    }
    /**
     * sets the left child of the node to new node
     * @param left is the new node to be assigned to the left child
     */
    public void setLeftChild(Node left)
    {
        leftChild=left;
    }
    /**
     * sets the right child of the node to new node
     * @param right is the new node to be assigned to the right child
     */
    public void setRightChild(Node right)
    {
        rightChild=right;
    }
    /**
     * gets the right child of the node
     * @return the right child
     */
    public Node getRightChild()
    {
        return rightChild;
    }
    
    /**
     * gets the set of courses assigned to a specific Bnumber
     * @return the set of courses
     */
    
    
    
    public Set<String> getCourse()
    {
        return courses;
    }
    
 /**
  * gets the courses in the formated string 
  * @return String of courses
  */
    public String  getCourses()
    {
        String data="";
       for(String s:courses)
       {
           data=data+" "+s;
       }
     return data;
    }
    
    /**
     * Adds the courses to the specific Bnumber
     * @param course course registered by the Student
     */
    
    public void setCourses(String course)
    {
       courses.add(course);
     
    }
    
    /**
     * Gives the Bnumber the key of the node
     * @return Bnumber
     */
    public int getBnumber()
    {
        return bNumber;
    }
    /**
     * sets the bnumber for 
     * @param bno to set it to private member 
     */
    
    
    public void setBnumber(int bno)
    {
        bNumber=bno;
    }
            
    /**
     * clones the object on which is applied
     * @return super's clone functionality
     * @throws CloneNotSupportedException 
     */
    @Override
    public Object clone() throws
                   CloneNotSupportedException
    {
        return super.clone();
    }

    
    
    
  /**
   * Registers the observer to the subject
   * @param o is the Observer to be registered
   */
    
    @Override
    public void registerObserver(ObserverI o) {
        
        if(o!=null)
        {
            Node observer=(Node)o;
            ObserverList.add(observer);
        }
        
        
        
    }
    
    /**
     * unregisters the observer from the observer list
     * @param o is the observer to be unregistered
     */

    @Override
    public void removeObserver(ObserverI o) {
        
        if(o!=null)
        {
            Node observer=(Node)o;
            ObserverList.remove(observer);
        }
        
        
        
        
        
        
        
    }
/**
 * notifies changes to all the registered observer
 * @param course which has been removed from the subject
 * @param Bnumber key to keep track of the courses
 */
    @Override
    public void notifyAll(String course,int  Bnumber) {
        
        for(Node observer:ObserverList)
        {
            update(observer, course);
        }
        
        
        
        
        
        
        
    }

    /**
     * updates the changes to the courses send by the subject through notify all method
     * @param updateNode The Node to be updated with the course
     * @param Course The course to be updated or removed from the course List
     */
    
    @Override
    public void update(Node updateNode, String Course) {
        
       updateNode.getCourse().remove(Course);
        
        
    }
    
    
    
}
