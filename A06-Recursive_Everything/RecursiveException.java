/**
 * The exception that will be thrown
 * with a given message.
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 06: Recursive Everythinh
 * @date       19/11/20
 * @bugs       none
 */
public class RecursiveException extends Exception {
  private String msg; //holds the message being given
  
  //constructor
  public RecursiveException(String msg){
    setMsg(msg);
  }
  
  //set method
  public void setMsg(String msg) {
    this.msg = msg;
  }
  
  //get method
  public String getMsg() {
    return this.msg;
  }
}