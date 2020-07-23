import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Driver class that gives the 
 * 3 options of adding, removing,
 * and checking the objects in a array
 * that holds 5 invoice objects. Additionally,
 * includes the barebone selection sort algorithm
 * to sort the array divided into 3 sections: 
 * swap(), findMax(), and selectionSort()
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 02: Array of Invoices
 * @date       19/09/09
 * @bugs       entering two values seperated by space
 *             for the Invoice number will give a value
 *             for both Invoice Number and Total
 */
 
/**
 * ALTERATIONS
 *
 * - Adds Invoices appropriately by hand and deleted
     the methods swap(), findMax() and selectionSort()
 * - Exceptions are thrown by the the Invoice Class
     and caught in the Main method
 * - The array size is determined by the constant SIZE
 * - The total of the Invoice is asked before the
 *   customer Name
 * - removeInvoice removes by Invoice rather than
 *   Index
 * - Prints Everything in array before exiting program
 * - Prints Everything in the array before removing an 
 *   Invoice
 * - Replaced quick for loop in printAllInvoices() to 
 *   stadard for loop as to print the index as well
 *
 * Message Changes
 * - Changed "Sorry, thats not a valid choice!" to 
 *   "Sorry, please enter the choices listed"
 * - "null" is replaced by a more User friendly message
 *   "No Invoice present at index"
 * - Changed "Enter a integer to for a option:" to
     "Enter a corresponding integer to the options listed"
 *
 * @author      McCrary, Kelii
 * @assignment  ICS 211 Assignment 02: Array of Invoice(Resubmission)
 * @date        19/10/08
 * @bugs        none
 */
 
class Accounting {
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);  //Intializes Scanner
      
      boolean exit = true; //condition when the programs exit
      final int SIZE = 5; //length of array
      Invoice arrayOfInvoices[] = new Invoice[SIZE]; //Makes a array of 5 invoice objects
      int currentSelection = -1; //Keeps track on what option the user is on
      
      String userName; // value that holds user inputted user name
      int userNumber; // value that holds user inputted Number
      double userTotal; //value that holds user inputted Total
      int removeIndex; //value that holds what index the user wants to delete
      
      String homeScreen = "\nEnter a corresponding integer to the options listed\n" + //home screen information
                           "1. Add new Invoice to a array\n" + 
                           "2. Remove a Inoice\n" +
                           "3. Print Invoices\n" + 
                           "0. Exit Program\n";
      
      while(exit) {
         try {
            userInput = new Scanner(System.in); 
            switch(currentSelection) {
               case -1:
                  System.out.printf(homeScreen);
                  currentSelection = userInput.nextInt();
                  break;
                  
               case 0:
                  System.out.println("Exiting the program with all Invoices listed");
                  printAllInvoices(arrayOfInvoices);
                  exit = false;
                  break;
                  
               case 1:
                  if(findEmptyIndex(arrayOfInvoices) == SIZE) {
                     System.out.println("Sorry, but the array is already filled");
                     currentSelection = -1;
                     break;
                  }
                  try {
                  
                     System.out.println("Enter a invoice number between the ranges of 100 and 20000");
                     userNumber = userInput.nextInt();
                    
                     if(checkDuplicate(userNumber,arrayOfInvoices)) {      
                        System.out.println("Enter a total amount that is not a negative number");
                        userTotal = userInput.nextDouble();
                        System.out.println("Enter a name with 4 or more characters:");
                        userName = userInput.next(); 
                        arrayOfInvoices[findEmptyIndex(arrayOfInvoices)] = new Invoice(userNumber,userTotal,userName);
                        inspectArray(arrayOfInvoices);
                        System.out.println("Success");
                     
                     }
                     else {
                        System.out.println("Error, Invoice entered is a duplicate, aborting...");
                     }
                   
                  
                     currentSelection = -1;
                  
                  }
                  catch(InvoiceException e) {
                     System.out.println(e.getException());
                     currentSelection = -1;
                  }
                  break;
                  
               case 2:
                  if(findEmptyIndex(arrayOfInvoices) != 0) {
                     printAllInvoices(arrayOfInvoices);
                     System.out.println("Please enter a valid Invoice Number to Remove");
                     userNumber = userInput.nextInt();
                     if(removeInvoice(arrayOfInvoices,userNumber)) {
                        inspectArray(arrayOfInvoices);
                     }
                  }
                  else {
                     System.out.println("Nothing to Remove!");
                  }
                  currentSelection = -1;
                  break;
                  
               case 3:
                  printAllInvoices(arrayOfInvoices);
                  currentSelection = -1;
                  break;
                  
               default:
                  System.out.println("Sorry, please enter the choices listed");
                  currentSelection = -1;
                  break;
            }
         }
         catch(InputMismatchException e) {
            System.out.println("\nError! Invalid InputMismatch detected! Returning back to home screen!");
            currentSelection = -1;
         }
      }
   }
   
   
   /**
   * Takes user input for Invoice constructor
   * and checks for duplicate Invoice numbers
   * with the checkDuplicate() method
   * @param invoiceArray removes index from specified
   * invoice array
   * @param indexToRemove which index to remove
   * value from
   * @exception value at specified index is null or
   * out of range
   * @return boolean
   */   
   static boolean removeInvoice(Invoice[] invoiceArray, int numberToRemove) {
      for(int i=0; i < invoiceArray.length; i++) {
         if(invoiceArray[i] != null && invoiceArray[i].getInvoiceNumber() == numberToRemove) {
            invoiceArray[i] = null;
            System.out.printf("Success, removed the Invoice at index %d\n",i);
            return true;
         }
      }
      System.out.println("Sorry, but a Invoice with that number is nowhere to be found in the array");
      return false;
   }
   
   /**
   * checks number given and Invoice Numbers
   * in the array for duplicates
   * @param number the Invoice Number being checked
   * @param invoiceArray the Invoice array to check with
   * nuber
   * @exception none
   * @return boolean
   */
   static boolean checkDuplicate(int number, Invoice[] invoiceArray) {
      for(Invoice i : invoiceArray) {
         if(i != null && i.getInvoiceNumber() == number) {
            return false;
         }
      }
      return true;
   }
   
   /**
   * Finds if any value of null is in the array
   * and returns the index of that value
   * @param invoiceArray the array being checked
   * for null values
   * @exception none
   * @return type integer
   */
   static int findEmptyIndex(Invoice[] invoiceArray) {
      for(int i=0; i < invoiceArray.length; i++) {
         if(invoiceArray[i] == null) {
            return i;
         }
      }
      return invoiceArray.length;
   }
   
   /**
   * Prints the toString methods
   * of all the Invoice objects in the
   * array
   * @params array the array that holds
   * the invoice objects
   * @return type none
   */
   static void printAllInvoices(Invoice[] invoiceArray) {
      for(int i=0; i < invoiceArray.length; i++) {
         System.out.println("---");
         System.out.printf("index %d:\n",i); 
         if(invoiceArray[i] == null) {
            System.out.println("No Invoice present at index");
         }
         else {
            System.out.println(invoiceArray[i]);
         }
      }
   }
   
   /* NEW CODE BELOW (19/10/08) */
   
   /**
   * Prints the toString methods
   * of all the Invoice objects in the
   * array
   * @params array the array to modify
   * @params rightIndex index inner loop
   * starts
   * @params replaceInvoice Invoice that is held
   * for sorting in the correct position
   * @return type none
   */
   static void shiftElements(Invoice[] array, int rightIndex, Invoice replaceInvoice) {
      int j; //hold index for replaceInvoice after loop
      
      //array[j+1] = array[j];
      for(j=rightIndex; j >= 0 && checkNull(array[j]) < checkNull(replaceInvoice); j--) {
         array[j+1] = array[j];
      }
      array[j+1] = replaceInvoice;
   }
   
   /**
   * Initial for loop
   * that runs to ensure all elements
   * in the array are sorted
   * @params array the array that
   * will be sorted
   * @return type none
   */
   static void inspectArray(Invoice[] array) {1
   
      for(int i=1; i < array.length; i++) {
         shiftElements(array, i-1, array[i]);
      }
   }
   
   /**
   * Checks if the value is null
   * and will either return a zero
   * if null or return its Invoice
   * value
   * @params value Invoice being checked
   * @return type double
   */
   static double checkNull(Invoice value) {
      if(value == null) {
         return 0;
      }
      return value.getInvoiceNumber();
   }
}