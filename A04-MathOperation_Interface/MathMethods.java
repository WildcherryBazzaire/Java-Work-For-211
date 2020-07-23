/**
 * Class that implements MathOperations
 * Interface with functionality to the methods
 * used. The driver class will make an instance
 * of MathMethods.java, with methods take in either
 * a integer or a double.
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 04: MathOperations interface
 * @date       19/10/13
 * @bugs       none
 *
 */
public class MathMethods implements MathOperations {

  /**
  * This method will receive two double numbers as a parameters
  * it will add them.
  * @param double d1, first number to add
  * @param double d2, second number to add
  * @return double, the addition of d1 + d2
  */
  
  public double add(double dNum1, double dNum2) {
    return dNum1 + dNum2;
  }
  
  /**
  * This method will receive a double number as a parameter
  * it will calculate its absolute value 
  * @param double d1Num
  * @return double an absolute value
  */
  
  public double absoluteValue(double dNum) {
    return Math.abs(dNum);
  }
  
  /**
  * This method will receive an int number as a parameter
  * it will determine if the number is even 
  * @param int iNum
  * @return boolean true if the number is even, false otherwise
  */
  
  public boolean isEven(int iNum) {
    if(iNum % 2 == 0) {
      return true;
    }
    return false;
  }
  
}