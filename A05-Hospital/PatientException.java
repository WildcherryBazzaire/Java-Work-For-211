public class PatientException extends Exception {
  //Instantiated Error msg
  private String msg;
  
  //When throwed, constructor use SetMessage 
  // to set message variable
  public PatientException(String msg) {
    setMessage(msg);
  }
  
  //makes this.msg variable to a custom message
  public void setMessage(String msg) {
    this.msg = msg;
  } 
  
  //returns the message that was made
  public String getMessage() {
    return this.msg;
  }
}