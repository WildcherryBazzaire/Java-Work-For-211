class InsertionSort {
  public static void main(String[] args) {
    Invoice array[] = new Invoice[5];
    
    try {
      array[0] = new Invoice(100,100,"Nemo");
      array[3] = new Invoice(200,300,"Dory");
      array[1] = new Invoice(300,400,"Bert");
      array[2] = new Invoice(400,500,"Dora");
      array[4] = new Invoice(500,600,"Slim");
    }
    catch(InvoiceException e) {
      System.out.println("Error, Unacceptable Invoice");
    }
    System.out.println("Array Before being sorted");
    printAllInvoices(array);
    
    insertionSort(array);
    
    System.out.println("\nThe Array now is\n");
    printAllInvoices(array);
    
    array[0] = null;
    checkNull(array[0]);
  }
  static void printAllInvoices(Invoice[] invoiceArray) {
      for(int i=0; i < invoiceArray.length; i++) {
         System.out.printf("index %d:\n",i);
         if(invoiceArray[i] == null) {
            System.out.println(invoiceArray[i]);
         }
         else {
            System.out.printf(invoiceArray[i].toString());
         }
         System.out.println("---");
      }
   }
   
   static void sort(Invoice[] array, int rightIndex, Invoice replaceInvoice) {
     int j;
     for(j=rightIndex; j >= 0 && array[j].getInvoiceNumber() > replaceInvoice.getInvoiceNumber(); j--) {
       array[j+1] = array[j];
     }
     array[j+1] = replaceInvoice;
   }
   
   static void insertionSort(Invoice[] array) {
     for(int i=1; i < array.length; i++) {
       sort(array, i-1, array[i]);
     }
   }
   
   static void checkNull(Invoice someValue) {
     if(someValue == null) {
       System.out.println("It is null") ;
     }
     else {
       System.out.println("It is not Null");
     }
   }
}