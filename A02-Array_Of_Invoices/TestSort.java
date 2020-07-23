class TestSort {
  public static void main(String[] args) {
    Invoice someArray[] = new Invoice[5];
    someArray[0] = new Invoice(200,200,"sN");
    
    System.out.println(someArray[0].toString());
  }
  
  static boolean checkDuplicate(int number, Invoice[] array) {
    for(Invoice i : array) {
      if(i != null && i.getInvoiceNumber() == number) {
        return false;
      }
    }
    return true;
  }
}