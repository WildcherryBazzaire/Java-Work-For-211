public class NodeP {
  private Patient p;
  private NodeP next;
  
  public NodeP(Patient p) {
    this.p = p;
  }
  
  public void setPatient(Patient p) {
    this.p = p;
  }
  
  public Patient getPatient() {
    return this.p;
  }
  
  public NodeP getNext() {
    return this.next;
  }
  
  public void setNext(NodeP next) {
    this.next = next;
  }
  
  public String toString() {
    return this.p.toString();
  }
  
  public String toString(double debt) {
    return this.p.toString(debt);
  }
}