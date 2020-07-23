/**
 * Operations that use
 * recursion to calculate the 
 * answers to a given input.
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 06: Recursive Everything
 * @date       19/11/20
 * @bugs       none
 */
 
import java.util.Scanner;
import java.util.InputMismatchException;

public class RecursiveFunctions {
  //method that is used when a exception is thrown
   private String rangeMethod = "The number is given is not within the range!";
  
   private boolean condition = true; //the condition to resume or stop the menu
   private int navNumber = 0; //the button 
 
  //String for the Menu
   private String menuMessage = "Please enter a number for a corresponding operation \n\n" +
                            "1. Power\n" +
                            "2. Factorial\n" + 
                            "3. Summation\n" +
                            "4. Exit\n";
   
   private Scanner userInput = new Scanner(System.in); //Scanner to get input
  
  /**
    * takes in two numbers
    * and calculates the power
    * using recursion.
    *
    * @params x the base number being raised
    * @params y how many times to rase the base number
    * 
    * @exception PatientException
    */
   public long power( int x , int y ) throws RecursiveException {
      checkCondition(x);
      checkCondition(y);
    
      if(y == 0) {
         return 1;
      }
      if( y == 1 ) {
         return x;
      }
      y--;
      return x * power(x,y);
   }
  
  /**
    * takes in one number and
    * returns the factorial value.
    *
    * @params x the number that will be
    * used in the factorial function.
    * 
    * @exception PatientException
    */
   public long factorial(int x) throws RecursiveException {
      checkCondition(x);
      
      if(x <= 1) {
         return x;
      }
      return x * factorial(x-1);
   }
  
  /**
    * Takes in a number and returns
    * the sum of all the numbers
    * before it
    * 
    * @params x the Max number that in the summation
    * 
    * @exception PatientException
    */
   public int sumAll(int x) throws RecursiveException {
      checkCondition(x);
    
      if( x == 1 ) {
         return x;
      }
      if( x == 0 ) {
         return x;
      }
      return x + sumAll( x-1 );
   }
   
   /**
    * Private method that checks the number
    * if it is less than 0 or greater than 12.
    *
    * @params number the number being checked
    * 
    * @exception PatientException
    */
   private void checkCondition(int number) throws RecursiveException {
      if( number < 0 || number > 12 ) {
         throw new RecursiveException(rangeMethod);
      }
      return;
   }
   
   /**
    * Method that is the main menu
    * for the user input and console.
    *
    * @params codition the boolean that
    * keeps the function repeating until
    * it is false
    * 
    * @exception none
    */
   public void recursiveMenu() {
      userInput = new Scanner(System.in); //clears the scanner
         
      if(this.condition == false) {
         return;
      }    
      try {
         int firstNumber; //holds the number the user gives
         int secondNumber; //hold the second number for the power operation
            
         switch(navNumber) {
            case 0:
               System.out.printf(menuMessage);
               navNumber = userInput.nextInt();
               break;
                   
            case 1:
               System.out.println("Please enter 2 numbers seperated by a space or a tab and our between 0 & 12");
               firstNumber = userInput.nextInt();
               secondNumber = userInput.nextInt();
               System.out.printf("The Result is: %d\n\n",this.power(firstNumber,secondNumber));
               this.navNumber = 0;
               break;
               
            case 2:
               System.out.println("Please enter a number between 0 & 12");
               firstNumber = userInput.nextInt();
               System.out.printf("The Result is: %d\n\n", this.factorial(firstNumber));
               this.navNumber = 0;
               break;
               
            case 3:
               System.out.println("Please enter a number between 0 & 12");
               firstNumber = userInput.nextInt();
               System.out.printf("The Result is: %d\n\n", this.sumAll(firstNumber));
               this.navNumber = 0;
               break;
               
            case 4:
               System.out.println("You exited the program!");
               this.condition = false;
               break;
               
            default:
               System.out.println("Please enter a corresponding number!");
               this.navNumber = 0;
         }
      }
      catch(RecursiveException e) {
         System.out.println(e.getMsg());
         this.navNumber = 0;
      }
      catch(InputMismatchException e) {
         System.out.println("Error, Input given not a number");
         this.navNumber = 0;
      }
      catch(StackOverflowError e) {
         System.out.println("Error, The inputted number is too large for calculation!");
         this.navNumber = 0;
      }
      this.recursiveMenu();
   }
}