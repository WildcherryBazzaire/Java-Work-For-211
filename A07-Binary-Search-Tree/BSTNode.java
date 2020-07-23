/**
 * Node to be used for the
 * CDBST class
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 07: Binary Search Tree
 * @date       19/12/09
 * @bugs       none
 */
public class BSTNode implements BSTNodeI {
  private CD cd;
  private BSTNode leftNode;
  private BSTNode rightNode;
  
  public BSTNode(CD cd) {
    this.cd = cd;
  }
  
  /**
  * This method will set newNode as
  * the left child of the current node
  * @param BSTNode new Node to add into a BST
  */
  public void setLeftChild(BSTNode newNode) {
    this.leftNode = newNode;
  }
  
  /**
  * This method will set newNode as
  * the right child of the current node
  * @param BSTNode new Node to add into a BST
  */
  public void setRightChild(BSTNode newNode) {
    this.rightNode = newNode;
  }
  
  /**
  * This method will return the left child
  * of the current node
  * @param no paramteters
  * @return BSTNode left child
   */
  public BSTNode getLeftChild( ) {
    return this.leftNode;
  }
  
  /**
  * This method will return the right child
  * of the current node
  * @param no paramteters
  * @return BSTNode right child
   */   
  public BSTNode getRightChild( ) {
    return this.rightNode;
  }
  
  /**
  * This method return the information
  * inside the current node CD
  * @param none
  * @return CD object
   */
  public CD getCD() {
    return this.cd;
  }
  
  /**
  * This method return a printable version
  * of the CD inside the current node
  * @param none
  * @return String with the CD information
   */
  public String toString() {
    return this.getCD().toString();
  }
}