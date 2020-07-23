public class test {
  public static void main(String[] args) {
    printName("Alex",10);
  }
  public static void printName(String name, int times) {
    if(times == 0) {
      return;
    }
    System.out.println(name + "\n");
    times--;
    printName(name,times);
  }
}