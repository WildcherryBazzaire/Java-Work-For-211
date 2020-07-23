/**
 * The class that is the main manager of the Node List,
 * With instance variables of front, back, and count.
 * It is the main class that manages the nodes inside
 * of it, making it a list.
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 05: Hospital
 * @date       19/11/04
 * @bugs       none
 */
 
/**
 * ALTERATIONS
 * 
 * - a found method that finds a patient and returns the toString
     of that patient
 *
 * - a private method checkEmpty() that checks if the 
 *  list is empty and throws a patientException if it is
 *  to stop the user doing any operation other than add.
 *  it is implemented in every method except the Construtor,
 *  addPatient, and toString.
 */
 
import java.text.DecimalFormat;
public class ListP {
   private NodeP front;
   private NodeP back;
   private int count;
  
   private DecimalFormat totalFormat = new DecimalFormat("$###,##0.00");
   
   /**
   * Adds a new node to the
   * list
   *
   * @param p takes a new Patient to add
   * the the node list
   *
   * @exception none
   */
   public void addPatient(Patient p) {
      NodeP toAdd = new NodeP(p);
    
      if(this.count == 0) {
         this.front = toAdd;
         this.back = toAdd;
         this.count++;
         return;
      }
    
      this.back.setNext(toAdd);
      this.back = this.back.getNext();
      this.count++;
   }
  
   /**
    * removes a patient from the list
    * with the name of the patient
    * correlating to the user inputted
    * name
    *
    * @param name the name of the patient
    * the user wants to remove
    *
    * @exception PatientException
    */
   public void removePatient(String name) throws PatientException {
      checkEmpty();
      
      name = name.trim();
      NodeP cursor = this.front;
      
      if(count == 1) {
         if(cursor.getPatient().getName().equalsIgnoreCase(name)) {
            this.front = this.front.getNext();
            this.count--;
            return;
         }
         throw new PatientException("No patient found with the name: " + name);
      }
      
      for(int i=0; i < count-1; i++) {
         if(cursor.getNext().getPatient().getName().equalsIgnoreCase(name)) {
            cursor.setNext(cursor.getNext().getNext());
            this.count--;
            return;
         }
         cursor = cursor.getNext();
      }
      throw new PatientException("No patient found with the name: " + name);
   }
  
   /**
    * Returns a true or false.
    * if the patient is in the list
    * it will print it and then return
    * true. If not, will return a message
    * and false
    *
    * @params name the user inputted 
    * name that is being looked for in
    * the list of patients
    * 
    * @exception PatientException
    */
   public boolean searchPatient(String name) throws PatientException {
   
      checkEmpty();
   
      name = name.trim();
      NodeP cursor = this.front;
      
      for(int i=0; i < count; i++) {
         if( cursor.getPatient().getName().equalsIgnoreCase(name) ) {
            System.out.println(cursor.toString());
            return true;
         }
         cursor = cursor.getNext();
      }
      System.out.println("Cannot Find patient inside the list");
      return false;
   }
  
   /**
    * Returns a String 
    * of all the patients in
    * the Node list
    *
    * @no params
    * 
    * @exception PatientException
    */
   public String printPatients() {
      String msg = "People in the current Waiting List:\n";
      NodeP cursor = this.front;
      
      if(this.count == 0) {
         msg += "\n Nobody Currently in the List";
         return msg; 
      }
    
    //Could do without cursor too
      for(int i=0; i < count; i++) {
         msg += cursor.toString();
         cursor = cursor.getNext();
      }
      return msg;
   }
  
   /**
    * Returns a string 
    * with all the patients
    * that have 0% coverage in
    * the list
    *
    * @params name takes a string
    * and searches through the list
    *
    * @exception PatientException
    */
   public String printInsurance() throws PatientException {
      String msg = "People with 0% insurance:\n";
      
      checkEmpty();
      
      NodeP cursor = this.front;
      for(int i=0; i < count; i++) {
         if(cursor.getPatient().getCoverage() == 0) {
            msg += cursor.toString();
            cursor = cursor.getNext();
         }
      }
      return msg;
   }
  
   /**
    * Returns a String with all
    * the patients that owe more
    * than a given amount
    *
    * @param givenAmount user-inputted
    * amount that will act as the criteria
    * for which patients owe more from.
    *
    * @exception patientException
   */
   public String printDebt(double givenAmount) throws PatientException {
      checkEmpty();
      
      String msg = "People that owe more than " + totalFormat.format(givenAmount) + " :\n";
      
      NodeP cursor = this.front;
      for(int i=0; i < this.count; i++) {
         if(cursor.getPatient().getTotal() > givenAmount) {
            msg += cursor.toString();
         }
         cursor = cursor.getNext();
      }
      return msg;
   }
   
   /**
    * uses searchPatient
    * to check if the patient is present
    * and then returns the string of the patient
    * being looked for. Will throw an exception
    * if the array is empty or 
    *
    * @param none
    *
    * @exception PatientException
    */
   public String found(String name) throws PatientException {
      checkEmpty();
   
      if(this.searchPatient(name)) {
         name = name.trim();
         NodeP cursor = this.front;
         for(int i=0; i < count; i++) {
            if( cursor.getPatient().getName().equalsIgnoreCase(name) ) {
               System.out.println(cursor.toString());
               return cursor.toString();
            }
            cursor = cursor.getNext();
         }
      }
      throw new PatientException("No patient found with the name: " + name);
   }
   
   /**
    * Checks if the list is empty
    * and throws a Exception to be caught
    * if the count is zero
    *
    * @param none
    *
    * @exception PatientException
    */
   private void checkEmpty() throws PatientException {
      if(this.count == 0) {
         throw new PatientException("No patients are currently in the list");
      }
   }
}