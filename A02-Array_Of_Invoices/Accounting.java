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
class Accounting {
   public static void main(String[] args) {
      Scanner userInput = new Scanner(System.in);  //Intializes Scanner
      
      boolean exit = true; //condition when the programs exit
      Invoice arrayOfInvoices[] = new Invoice[5]; //Makes a array of 5 invoice objects
      int currentSelection = -1; //Keeps track on what option the user is on
      int openSlot = findEmptyIndex(arrayOfInvoices); //Holds index of null
      
      String userName; // value that holds user inputted user name
      int userNumber; // value that holds user inputted Number
      double userTotal; //value that holds user inputted Total
      int removeIndex; //value that holds what index the user wants to delete
      
      String homeScreen = "\nEnter a integer to for a option:\n" + //home screen information
                           "1. Add new Invoice to a array\n" + 
                           "2. Remove a Inoice\n" +
                           "3. Check existing invoices\n" + 
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
                  exit = false;
                  break;
                  
               case 1:
                  if(openSlot == 5) {
                     System.out.println("Sorry, but the array is already filled");
                     currentSelection = -1;
                     break;
                  }
                  
                  System.out.println("Enter a name with 4 or more characters:");
                  userName = userInput.nextLine();
               
                  System.out.println("Enter a invoice number between the ranges of 100 and 20000");
                  userNumber = userInput.nextInt();
               
                  System.out.println("Enter a total amount that is not a negative number");
                  userTotal = userInput.nextDouble();
               
                  setNewInvoice(userName,userNumber,userTotal,arrayOfInvoices,openSlot);
                  currentSelection = -1;
               
                  openSlot = findEmptyIndex(arrayOfInvoices);
                  break;
                  
               case 2:
                  System.out.println("Please enter a valid index to remove between ranges 0 & 4");
                  userNumber = userInput.nextInt();
                  if(removeInvoice(arrayOfInvoices,userNumber)) {
                     selectionSort(arrayOfInvoices);
                     openSlot = findEmptyIndex(arrayOfInvoices);
                  }
                  currentSelection = -1;
                  break;
                  
               case 3:
                  printAllInvoices(arrayOfInvoices);
                  currentSelection = -1;
                  break;
                  
               default:
                  System.out.println("Sorry, thats not a valid choice!");
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
   * @param name takes user Inputted Name
   * @param number takes user inputted invoice Number
   * @param total takes user inputted
   * @param invoiceArray uses specifed Invoice array
   * to place a new Invoice in
   * @param invoiceArrayIndex index to place new Invoice
   * in the array
   * @exception Duplicate invoice in the array
   * @return No return value
   */ 
   static void setNewInvoice(String name, int number, double total, Invoice[] invoiceArray, int arrayIndex) {
      if(checkDuplicate(number,invoiceArray)) {
         invoiceArray[arrayIndex] = new Invoice(number,total,name);
         selectionSort(invoiceArray);
         System.out.println("Successfully added the Invoice!");
      }
      else {
         System.out.println("Duplicate Invoice, Aborting!");
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
   static boolean removeInvoice(Invoice[] invoiceArray, int indexToRemove) {
      if(indexToRemove < 0 || indexToRemove > invoiceArray.length || invoiceArray[indexToRemove] == null) {
         System.out.println("Sorry, but the index entered is either out of range or null.");
         return false;
      }
      else {
         invoiceArray[indexToRemove] = null;
         System.out.printf("Success, removed the Invoice at index %d\n",indexToRemove);
      }
      return true;
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
      for(Invoice i : invoiceArray) {
         if(i == null) {
            System.out.println("---");
            System.out.println(i);
         }
         else {
            System.out.println("---");
            System.out.printf(i.toString());
         }
      }
   }
   
   /**
   * Swaps out firstIndex with secondIndex
   * in the array array
   * @param invoiceArray the array used in the swaping
   * @param firstIndex the index of the value that
   * will be swapped with the secondIndex
   * @param secondIndex the index of the value that
   * will be with the firstIndex 
   * @return no return type
   */
   static void swap(Invoice[] invoiceArray ,int firstIndex,int secondIndex) {
      Invoice temp = invoiceArray[firstIndex];
      invoiceArray[firstIndex] = invoiceArray[secondIndex];
      invoiceArray[secondIndex] = temp;
   }
   
   /**
   * finds the maximum value of invoiceNumber
   * in the array from startIndex to end and
   * returns the index of it
   * @param invoiceArray the array it will search through
   * @param startIndex the index where the search will
   * start from
   * @return integer type
   */
   static int findMax(Invoice[] invoiceArray,int startIndex) {
      int maxIndex = startIndex; /* Holds index of maximum index */
      double maxValue = invoiceArray[startIndex] == null ? 0 : invoiceArray[maxIndex].getInvoiceNumber(); /*value of max*/
      
      for(int i=startIndex+1; i < invoiceArray.length; i++) {
         if(invoiceArray[i] != null && invoiceArray[i].getInvoiceNumber() > maxValue) {
            maxIndex = i;
            maxValue = invoiceArray[maxIndex].getInvoiceNumber();
         }
      }
      return maxIndex;
   }
   
   /**
   * combines the methods findMax() &
   * swap to make the selection Sort algorithm.
   * Starts at the beginning of the array and searches
   * values with higher Invoice Numbers to be swapped with.
   * It will continue to do this until the last element
   * of the array
   * @param invoiceArray the array being sorted
   * @return no return type
   */
   static void selectionSort(Invoice[] invoiceArray) {
      for(int i=0; i < invoiceArray.length; i++) {
         int temp = findMax(invoiceArray,i); /* holds the maximum value to be swapped with */
         
         swap(invoiceArray,i,temp);
      }
   }
}