/**
 * Class that setups up and create the Patient Object
 * With instance variables of name, triage, coverage,
 * and total
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 05: Hospital
 * @date       19/10/26
 * @bugs       none
 */
import java.text.DecimalFormat;
public class Patient {
  private String name; //holds patient name
  private int triage;  //holds urgency level
  private int coverage;  //holds patient coverage
  private double total;  //total of the treatment
  
  //format of the total
  private DecimalFormat totalFormat = new DecimalFormat("###,##0.00");
  
  //constructor
  public Patient(String name, int triage, int coverage, double total) throws PatientException {
    setName(name);
    setTriage(triage);
    setCoverage(coverage);
    setTotal(total);
  }
  
  /**
    * Changes the variable name
    * to a user-specified value.
    * Will throw exception if name 
    * is less than 5 characters.
    *
    * @param total value of what this.name
    *              will be changed to
    * 
    * @exception PatientException
    */
  public void setName(String name) throws PatientException {
    if(name.trim().length() < 5) {
      throw new PatientException("Patient Name must be 5 characters long!");
    }
    
    this.name = name;
  }
  
  /**
    * Changes the variable triage
    * to a user-specified value.
    * Will throw exception if triage 
    * is less than 1 or greater than
    * 5.
    *
    * @param total value of what this.triage
    *              will be changed to
    * 
    * @exception PatientException
    */
  public void setTriage(int triage) throws PatientException {
    if(triage < 1 || triage > 5) {
      throw new PatientException("Triage must be a number between 1 and 5!");
    }
    
    this.triage = triage;
  }
  
  /**
    * Changes the variable
    * coverage to a user-specified 
    * value. Will throw exception
    * if coverage is less than 0 or
    * greater than 100.
    *
    * @param total value of what this.coverage
    *              will be changed to
    * 
    * @exception PatientException
    */
  public void setCoverage(int coverage)throws PatientException {
    if(coverage < 0 || coverage > 100) {
      throw new PatientException("Coverage Must be between 0 and 100!");
    }
    
    this.coverage = coverage;
  }
  
  /**
    * Changes the variable total
    * to a user-specified value.
    * Will throw exception if total 
    * is a negative number.
    *
    * @param total value of what this.total
    *              will be changed to
    * 
    * @exception PatientException
    */
  public void setTotal(double total) throws PatientException {
    if(Math.abs(total) != total) {
      throw new PatientException("Total must be a non-negative number");
    }
    
    this.total = total;
  }
  
  /**
    * Returns the class variable
    * name when called
    *
    * @no params
    *
    * 
    * @exception none
    */
  public String getName() {
    return this.name;
  }
  
  /**
    * Returns the class variable
    * triage when called
    *
    * @no params
    *
    * 
    * @exception none
    */
  public int getTriage() {
    return this.triage;
  }
  
  /**
    * Returns the class variable
    * coverage when called
    *
    * @no params
    *
    * 
    * @exception none
    */
  public int getCoverage() {
    return this.coverage;
  }
  
  public double getTotal() {
    return this.total;
  }
  
  /**
    * returns a meaningful string of the objects variable
    *
    * @return String of the all the objects variable values
    * @exception none
    */
  public String toString() {
    String msg;
    
    msg = "Patient Name: " + getName() + "\n" + 
          "Triage Level: " + getTriage() + "\n" +
          "Coverage Percent: " + getCoverage() + "%\n" +
          "Total: $" + totalFormat.format(getTotal()) + "\n----------------\n";
    
    return msg; 
  }
}