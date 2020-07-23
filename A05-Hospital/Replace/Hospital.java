public class Hospital {
  public static void main(String[] args) {
  
    try {
      Patient patientOne = new Patient("Harvey Dent", 1, 100, 0);
      Patient patientTwo = new Patient("Barbara Gordan", 4, 50, 100);
      Patient patientThree = new Patient("Jimmy Neutron",2, 80, 30);
      Patient patientFour = new Patient("Judy Hopps",1,99,1000.98);
      Patient patientFive = new Patient("Hermione Granger",1,5,1000);
      ListP hospitalList = new ListP();
      
      hospitalList.addPatient(patientOne);
      hospitalList.addPatient(patientTwo);
      hospitalList.addPatient(patientThree);
      hospitalList.addPatient(patientFour);
      hospitalList.addPatient(patientFive);
      
//       System.out.println(hospitalList.printPatient());
//       
//        System.out.println(hospitalList.searchPatient("HaRvEy DeNt"));
//        
//        System.out.println(hospitalList.searchPatient("Jimmy Neutron"));
//        
//        System.out.println(hospitalList.searchPatient("Hermione Granger"));
       
       System.out.println(hospitalList.printDebt());
      
      
    }
    catch(PatientException e) {
      System.out.println(e.getMessage());
    }
  }
}