import java.util.Scanner;
class UserInput {
  private int arrayLength = 0;
  private int currentFreeIndex = 0;
  private boolean done = true;
  
  private Invoice[] userArray;
  
  public Scanner userInput = new Scanner(System.in);
  
  private String homeMessage = "Enter a integer to for a option:\n" + 
                           "1. Add new Invoice to a array\n" + 
                           "2. Check existing invoices\n" + 
                           "3. Remove a Inoice\n" +
                           "4. Edit a Invoice\n";
  
  private int selection = 0;
  
  public UserInput(int arrayLength) {
    this.arrayLength = arrayLength;
    this.userArray = new Invoice[this.arrayLength];
  }
  
  public void InputLoop() {
    while(this.done) {
      switch(this.selection) {
        case 0:
          System.out.println(homeMessage);
          changeOption(userInput.nextInt());
        break;
          
        case 1:
          try {
            if(this.CheckArray() == false) { 
              throw new InvoiceException("Error, the Array is full, going back to home");
            }
            else {
              this.NewInvoice();
            }
          }
          catch(InvoiceException e) {
           System.out.println(this.CheckArray());
           System.out.println(e.GetMessage());
           this.selection = 0;
          }
        break;
        
        case 2:
          this.CheckValues();
          this.selection = 0;
          
        case 3:
          this.RemoveInvoice();
          this.SelectionSort();
        
        break;
      }
    }
  }
  
  private void changeOption(int choice) {
    this.selection = choice;
  }
  
  public void NewInvoice() {
    int number;
    double cost;
    String customer;
    
    userInput.nextLine();
    
    System.out.println("Give a customer Name 4 characters or more\n");
    customer = userInput.nextLine();
    
    System.out.println("Give a customer number within range of 100 or 20000\n");
    number = userInput.nextInt();
    
    System.out.println("Give a cost that is not negative\n");
    cost = userInput.nextDouble();
    
    this.userArray[0] = new Invoice(number,cost,customer);
    
    System.out.println("Success!");
    System.out.println(userArray[0].toString());
    this.selection = 0;
  }
  
  public void CheckValues() {
    for(Invoice i : userArray) {
      if(i == null) {
        System.out.println("Null");
      }
      else {
        System.out.println(i.toString());
      }
    }
  }
  
  public void RemoveInvoice() {
    int erase;
    System.out.println("Enter a index you would want to remove from the aray");
    erase = userInput.nextInt();
    
    this.userArray[erase] = null;
    this.SelectionSort();
  }
  
  private boolean CheckArray() {
    for(Invoice i : this.userArray) {
      if(i == null) {
        return true;
      }
    }
    return false;
  }
  
  private void swap(int firstIndex,int secondIndex) {
    Invoice temp = this.userArray[firstIndex];
    this.userArray[firstIndex] = this.userArray[secondIndex];
    this.userArray[secondIndex] = this.userArray[firstIndex];
  } 
  
  private int FindNull(int startIndex) {
    int temp = 0;
    for(int i=startIndex+1; i < this.userArray.length-1; i++) {
      if(this.userArray[i] == null) {
        temp = i;
        break;
      }
    }
    return temp;
  }
  
  public void SelectionSort() {
    for(int i=0; i < this.userArray.length; i++) {
      int temp = this.FindNull(i);
      this.swap(i,temp);
    }
  }
}