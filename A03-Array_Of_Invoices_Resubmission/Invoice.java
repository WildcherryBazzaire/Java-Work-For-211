/**
 * Class that establishes the the Invoice class
 * with variables invoiceNumber,total, and customer
 * that are check when instanced to fit the
 * Specified Criteria
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 02: Array of Invoices
 * @date       19/09/09
 * @bugs       none
 */
 
/**
 * ALTERATIONS
 *
 * - Change the DecimalFormat to format accordindly
 * - Throws Invoice exception to be caught in Main method
 *   rather than caught in class
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 02: Array of Invoices(Resubmission)
 * @date       19/10/08
 * @bugs       none
 */
 
import java.text.DecimalFormat;
class Invoice {
   private int invoiceNumber; //holds the number of Invoice
   private double total; //Holds the total amount of Invoice
   private String customer; //Holds the customer amount on Invoice
   
   private DecimalFormat totalFormat = new DecimalFormat("###,##0.00");
   
   //constructor
   public Invoice(int invoiceNumber, double total, String customer) throws InvoiceException {
      setInvoiceNumber(invoiceNumber);
      setTotal(total);
      setCustomer(customer);
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
   public int getInvoiceNumber() {
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
   public double getTotal() {
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
   public String getCustomer() {
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
   public void setInvoiceNumber(int invoiceNumber) throws InvoiceException {
         if(invoiceNumber >= 100 && invoiceNumber <= 20000) {
            this.invoiceNumber = invoiceNumber;
         }
         else {
            throw new InvoiceException("Invalid Invoice Number: " + invoiceNumber);
         }
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
   public void setTotal(double total) throws InvoiceException {
         if(total == Math.abs(total)) {
            this.total = total;
         }
         else {
            throw new InvoiceException("A Negative total is not valid: -$" + Math.abs(total));
         }
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
   public void setCustomer(String customer) throws InvoiceException {
      customer = customer.trim();
      if(customer.length() >= 4) {
         this.customer = customer;
      }
      else {
         throw new InvoiceException("Invalid Customer name: " + customer);
      }
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
                      "Total: $" + totalFormat.format(this.total) + "\n";
      return message;
   }
}