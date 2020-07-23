/**
 * The Class that is to be used in only the ListP
 * class as it contains reference to Patient objects
 * and other nodes inside the list.
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 05: Hospital
 * @date       19/11/04
 * @bugs       none
 */
public class NodeP {
   private Patient p; //Patient Held by the Node
   private NodeP next; //Next node reference
   
   public NodeP(Patient p) {
      setPatient(p);
   }
   
   /**
    * set the patient for the node
    *
    * @param p the patient to give
    * the node
    * 
    * @exception none
    */
   public void setPatient(Patient p) {
      this.p = p;
   }
   
   /**
    * Returns the class object p
    * when called
    *
    * @no params
    *
    * 
    * @exception none
    */
   public Patient getPatient() {
      return this.p;
   }
   
   /**
    * Returns the class reference
    * next when called
    *
    * @no params
    *
    * 
    * @exception none
    */
   public NodeP getNext() {
      return this.next;
   }
   
   /**
    * Changes the reference
    * next to a specified 
    * reference.
    *
    * @param next the address
    * of the next Node inside the
    * list
    * 
    * @exception none
    */
   public void setNext(NodeP next) {
      this.next = next;
   }
   
   /**
    * returns a meaningful string of the objects variable
    *
    * @return String of the all the objects variable values
    *
    * @exception none
    */
   public String toString() {
      return this.p.toString();
   }
}