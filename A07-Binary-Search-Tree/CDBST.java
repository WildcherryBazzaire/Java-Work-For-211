/**
 * Implements the Implement class
 * and the logic for the Binary
 * Search Tree. For the find node
 * I wanted to implement the Depth
 * First Search that I learned goes
 * from a visit to UH Manoa. It will go to
 * the deepest level of the tree on the contrary 
 * Breadth First Seach that would be implmented
 * using a queue.
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 07: Binary Search Tree
 * @date       19/12/09
 * @bugs       none
 */
import java.util.Stack; 

public class CDBST implements CDBSTI {
   
   private BSTNode root; //The start/root of the BST
   private short count;  //# of nodes in the tree
  
   /**
    * Inserts node into binary search tree.
    * @param CD cd
    * @exception Any exception.
    * @return boolean.
    *
    */
   public boolean addNode(CD cd) {
      BSTNode newNode = new BSTNode(cd);
    
      if(this.root == null) {
         root = newNode;
         ++count;
      }
      
      else {
         BSTNode cursor = root;
         while(cursor != null) {
            
            if(cursor.getCD().compareTo(newNode.getCD()) == 1) {
               
               if(cursor.getLeftChild() != null) {
                  cursor = cursor.getLeftChild();
               }
               
               else {
                  cursor.setLeftChild(newNode);
                  ++count;
                  break;
               }
            }
         
            if(cursor.getCD().compareTo(newNode.getCD()) == -1) {
               
               if(cursor.getRightChild() != null) {
                  cursor = cursor.getRightChild();
               }
               
               else {
                  cursor.setRightChild(newNode);
                  ++count;
                  break;
               }
            } 
            
            if (cursor.getCD().compareTo(newNode.getCD()) == 0) {
              return false;
            }
         }
      }
      return true;
   }
  
   /**
    *Looks for a node within the binary search tree.
    * It accoplishes this by using the Depth First
    * Search Method to find the desired node.
    * @param CD cd
    * @exception Any exception.
    * @return boolean.
    *
    */
   public boolean findNode(CD cd) {
      Stack<BSTNode> st = new Stack<BSTNode>();
      st.push(this.root);
      BSTNode cursor = this.root;
      
      while(!st.empty()) {
        cursor = st.pop();
        
        if(cursor != null) {
          
          if(cursor.getCD().compareTo(cd) != 0) {
            st.push(cursor.getRightChild());
            st.push(cursor.getLeftChild());
          }
          
          else {
            return true;
          }
        }
      }    
      return false;
   }
  
  /**
   * Prints binary search tree in inorder
   * traversal using recursion.
   * @param BSTNode root.
   * @exception Any exception.
   * @return No return value.
   */
   public void printBSTree(BSTNode root) {
      if(root == null) {
         return;
      }
    
      printBSTree(root.getLeftChild());
      System.out.println(root.toString() + "\n");
      printBSTree(root.getRightChild());
   }
  
   /**
    * Overloads method of the same name to
    * access private variable root.
    * @param None.
    * @exception Any exception.
    * @return No return value.
    */
   public void printBSTree( ) {
      printBSTree(this.root); //calls the 1st overload
   }
   
   /**
    * The get method that
    * returns the number of
    * nodes in the tree.
    * @param None.
    * @exception Any exception.
    * @return No return value.
    */
   public int size( ) {
     return this.count;
   }
}