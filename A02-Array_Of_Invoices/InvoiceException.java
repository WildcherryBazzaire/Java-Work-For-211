class InvoiceException extends Exception {
   //Default variable empty string "message"
   String message = "";
  
   //When throwed, constructor use SetMessage 
   // to set message variable
   public InvoiceException(String message) {
      this.setException(message);
   }
   //makes this.message variable to a custom message
   public void setException(String message) {
      this.message = message;
   } 
   //returns the message that was made
   String getException() {
      return message;
   }
}