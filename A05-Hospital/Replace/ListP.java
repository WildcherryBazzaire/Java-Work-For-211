public class ListP {
   private NodeP front;
   private NodeP back;
   private int count;
  
  
  /**
    * Adds a new node to the
    * list
    *
    * @param p takes a new Patient to add
    *
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
    * Returns the class variable
    * triage when called
    *
    * @param name takes a string
    * and searches through the list
    * the patient too remove
    *
    * 
    * @exception none
    */
   public void removePatient(String name) {
      name = name.trim();
      NodeP cursor = this.front;
      if(count > 0) {
      //checks if the first node is the one to remove
         if(cursor.getPatient().getName().equalsIgnoreCase(name)) {
            this.front = this.front.getNext();
            this.count--;
            return;
         } //If condition end bracket
      
      //counter-1 so it doesnt reach the end of the list(due to it checking the next node)
         for(int i=0; i < count; i++) {
         
            if(cursor.getNext().getPatient().getName().equalsIgnoreCase(name)) {
               cursor.setNext(cursor.getNext().getNext());
               this.count--;
               return;
            } //If condition end bracket
         
            cursor = cursor.getNext();
         
         } //End For loop bracket
         System.out.println("Couldnt Find the Name: " + name + " in the Patients list");
      }
      System.out.println("There is nothing inside the Patient List");
   }
  
   /**
    * Returns the class variable
    * triage when called
    *
    * @params name takes a string
    * and searches through the list
    * 
    *
    * 
    * @exception none
    */
   public boolean searchPatient(String name) {
      name = name.trim();
      NodeP cursor = this.front;
      for(int i=0; i < count; i++) {
         if( cursor.getPatient().getName().equalsIgnoreCase(name) ) {
            return true;
         }
         cursor = cursor.getNext();
      }
      return false;
   }
  
   /**
    * Returns a String 
    * of all the patients in
    * the Node list
    *
    * @no params
    * 
    * @exception none
    */
   public String printPatient() {
      String msg = "";
      NodeP cursor = this.front;
    
    //Could do without cursor too
      for(int i=0; i < count; i++) {
         msg += cursor.toString();
         cursor = cursor.getNext();
      }
      return msg;
   }
  
   /**
    * Prints all the 
    *
    * @params name takes a string
    * and searches through the list
    * 
    *
    * 
    * @exception none
    */
   public String printInsurance() {
      String msg = "";
      NodeP cursor = this.front;
      for(int i=0; i < count; i++) {
        if(cursor.getPatient().getCoverage() == 0) {
           msg += cursor.toString();
           cursor = cursor.getNext();
        }
      }
      return msg;
   }
  
   public String printDebt() {
      String msg = "";
      NodeP cursor = this.front;
      for(int i=0; i < this.count; i++) {
        double debt = cursor.getPatient().getTotal() - ( cursor.getPatient().getTotal() * cursor.getPatient().getCoverage()  * 0.01 );
        if(debt != 0 ) {
          msg += cursor.toString(debt);
        }
        cursor = cursor.getNext();
      }
      return msg;
   }
}