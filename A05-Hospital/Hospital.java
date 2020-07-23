/**
 * The driver that instantiates
 * the GUI and the logic behide it.
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 05: Hospital Driver
 * @date       19/11/11
 * @bugs       none
 */
public class Hospital {
   public static void main(String[] args) {
      GUIFrame hospital = new GUIFrame();
      hospital.intializeGUI();
      hospital.setVisible(true);
   }
}