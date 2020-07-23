/**
 * Class that establishes the the Invoice class
 * with variables invoiceNumber,total, and customer
 * that are check when instanced to fit the
 * Specified Criteria
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 01: Invoice Class
 * @date       19/09/04
 * @bugs       none
 */

class Invoice {
   //variables 
   private int invoiceNumber; //holds the number of Invoice
   private double total; //Holds the total amount of Invoice
   private String customer; //Holds the customer amount on Invoice
   
   //constructor
   public Invoice(int invoiceNumber, double total, String customer) {
      CheckParameters(invoiceNumber,total,customer);
   }
   
   /**
    * Returns the class variable
    * invoiceNumber when called
    *
    * @no params
    *
    * 
    * @exception none
    */
   public int GetInvoiceNumber() {
      return this.invoiceNumber;
   }
   
   /**
    * Returns the class variable
    * total when called
    *
    * @no params
    *
    * 
    * @exception none
    */
   public double GetTotal() {
      return this.total;
   }
   
   /**
    * Returns the class variable
    * GetCustomer when called
    *
    * @no params
    *
    * 
    * @exception none
    */
   public String GetCustomer() {
      return this.customer;
   }
   
   
   /**
    * Changes the variable SetInvoice
    * to a user-specified value
    *
    * @param invoiceNumber value of what this.invoiceNumber
    *                      will be changed to
    * 
    * @exception InvoiceException
    */
   public void SetInvoiceNumber(int invoiceNumber) {
      CheckParameters(invoiceNumber, this.total, this.customer);
   }
   
   /**
    * Changes the variable SetInvoice
    * to a user-specified value
    *
    * @param total value of what this.total
    *              will be changed to
    * 
    * @exception InvoiceException
    */
   public void SetTotal(double total) {
      CheckParameters(this.invoiceNumber, total, this.customer);
   }
   
   /**
    * Changes the variable SetInvoice
    * to a user-specified value
    *
    * @param customer value of what this.customer
    *                 will be changed to
    * 
    * @exception InvoiceException
    */
   public void SetCustomer(String customer) {
      CheckParameters(this.invoiceNumber, this.total, customer);
   }
   
   /**
    * returns a meaningful string of the objects variable
    *
    * @return String of the all the objects variable values
    * @exception none
    */
   public String toString() {
      String message = "Invoice Number: " + this.invoiceNumber + ",\n" +
                      "Customer: " + this.customer + ",\n" +
                      "Total: $" + this.total + "\n";
      return message;
   }
   
   /**
    * Checks if all the values meet the criteria
    * otherwise, it throws InvoiceException
    * with a custom message correlating to the
    * error
    *
    * @param invoiceNumber constructor argument of invoiceNumber
    * @param total constructor argument of total
    * @param customer constructor argument of customer
    *
    * @exception InvoiceException
    */
   private void CheckParameters(int invoiceNumber, double total, String customer) {
      try {
         if(invoiceNumber >= 100 && invoiceNumber <= 20000) {
            this.invoiceNumber = invoiceNumber;
         }
         else {
            throw new InvoiceException("Invalid Invoice Number: " + invoiceNumber);
         }
         
         if(customer.length() >= 4) {
            this.customer = customer;
         }
         else {
            throw new InvoiceException("Invalid Customer name: " + customer);
         }
         if(total == Math.abs(total)) {
            this.total = total;
         }
         else {
            throw new InvoiceException("A Negative total is not valid: -$" + Math.abs(total));
         } 
      }
       
      catch(InvoiceException e) {
         System.out.println(e.GetMessage());
      }
   }
   
}