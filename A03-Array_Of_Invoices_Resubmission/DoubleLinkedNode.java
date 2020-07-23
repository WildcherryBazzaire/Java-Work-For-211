public class DoubleLinkedNode {
  private Person person;
  private DoubleLinkedNode leftNode;
  private DoubleLinkedNode rightNode;
  
  public DoubleLinkedNode(Person person) {
    this.person = person;
  }
  
  public void setNextLeft(DoubleLinkedNode newPerson) {
    this.leftNode = newPerson;
  }
  
  public void setNextRight(DoubleLinkedNode newPerson) {
    this.rightNode = newPerson;
  }
  
  public DoubleLinkedNode getNextLeft() {
    return this.leftNode;
  }
  
  public DoubleLinkedNode getNextRight() {
    return this.rightNode;
  }
  
  public void toString() {
    return person.toString();
  }
}