/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentCoursesBackup.myTree;
import studentCoursesBackup.myTree.Node;
import java.util.Observer;

/**
 *
 * @author miteshgandhi
 */
public interface SubjectI {
    
      /**
   * Registers the observer to the subject
   * @param o is the Observer to be registered
   */
    
    public void registerObserver(ObserverI o);
    
      /**
     * unregisters the observer from the observer list
     * @param o is the observer to be unregistered
     */
    
    public void removeObserver(ObserverI o);
    
    /**
 * notifies changes to all the registered observer
 * @param course which has been removed from the subject
 * @param Bnumber key to keep track of the courses
 */
    public void notifyAll(String course,int Bnumber);
    
    
    
}
