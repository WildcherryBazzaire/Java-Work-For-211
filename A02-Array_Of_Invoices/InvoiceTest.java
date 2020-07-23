/**
 * Makes instances of the class Exception
 * and test if the arguments are valilid  
 * to the specificied Criteria
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 01
 * @date       19-09-04
 * @bugs       N/A
 */
public class InvoiceTest {
   public static void main(String[] args) {
    
      //Only class instance that will not throw a exception
      Invoice personalInvoice = new Invoice(9997,99.99,"Susan Lockhorn");
        
      //Will Throw a Exception due to the customer name being less than 4
      Invoice personalInvoiceTwo = new Invoice(9997,99.99,"Su");
      
      //Will Throw a Exception due to a negative total
      Invoice personalInvoiceThree = new Invoice(9997,-99.99,"Susan Lockhorn");
      
      //Will Throw a Exception due the Number not meeting the criteria
      Invoice personalInvoiceFour = new Invoice(21000,99.99,"Susan Lockhorn");
      
      //Prints the return value of the ToString Method of personalInvoice
      System.out.println("\n" + personalInvoice.toString());
      
      //Throw a exception due to setting the name less than or equal to 4 characters
      personalInvoice.SetTotal(-2000.00);
      
      //See's if the Total has change by calling the toString again
      System.out.println("\n" + personalInvoice.toString());
      
      //Calls the SetTotal again and changes the value to
      // an acceptable one
      personalInvoice.SetTotal(2000.00);
      
      //Checking the total again by calling the toString yet again
      System.out.println("\n" + personalInvoice.toString());
   }
}