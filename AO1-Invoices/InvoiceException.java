class InvoiceException extends Exception {
   //Default variable empty string "message"
   String message = "";
   
   //When throwed, constructor use SetMessage 
   // to set message variable
   public InvoiceException(String message) {
      SetMessage(message);
   }
   
   //makes this.message variable to a custom message
   public void SetMessage(String message) {
      this.message = message;
   }
   
   //returns the message that was made
   String GetMessage() {
      return message;
   }
}