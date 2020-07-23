/**
 * The class that intiates the GUI
 * for the patient list.
 *
 * @author     McCrary, Kelii
 * @assignment ICS 211 Assignment 05: Hospital GUI
 * @date       19/11/11
 * @bugs       none
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class GUIFrame extends JFrame {
  
  //Buttons to be added: Main Screen
   private JButton addButton = new JButton(" Add ");
   private JButton removeButton = new JButton(" Remove ");
   private JButton showAllButton = new JButton(" Show Entire List ");
   private JButton searchButton = new JButton(" Search by Name ");
   private JButton searchButtonAmount = new JButton(" Search by Amount ");
   private JButton zeroCoverage = new JButton(" Search for People with 0% Coverage ");
  
  //The Labels for the input Section
   private JLabel nameLabel = new JLabel("Name: ");
   private JLabel triageLabel = new JLabel("Triage: ");
   private JLabel coverageLabel = new JLabel("Coverage: ");
   private JLabel costLabel = new JLabel("Cost: ");
   
   private TextField nameField = new TextField(9);
   private TextField triageField = new TextField(9);
   private TextField coverageField = new TextField(9);
   private TextField costField = new TextField(9);
   private TextField searchName = new TextField(20);
   private TextField searchMoney = new TextField(20);
  
  //TextPane to display the list
   JTextPane listText = new JTextPane();
   JScrollPane scrollableList = new JScrollPane(listText);
  
  //Window Dimensions
   private final int X = 800;
   private final int Y = 600;
 
  //The list containing the patients
   private ListP hospitalList = new ListP();
   
 //Borders to seperate the panels
   private TitledBorder title;  
   private TitledBorder list;
   private TitledBorder dataField;
   
   public GUIFrame() {
      this.setSize(X, Y);
      this.setTitle("Hospital List");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      this.setResizable(false);
   }
  
  /**
    * Intializes the GUI and adds
    * the panels, buttons, textFields, and
    * textPanels to their repected panels.
    * These panels are held by the master panel
    * named rootGrid. 
    * 
    *
    * @param none
    *
    * @exception none
    */
   public void intializeGUI() {
   //Setups the borders
      title = BorderFactory.createTitledBorder(" Options ");
      list = BorderFactory.createTitledBorder(" Patient List ");
      dataField = BorderFactory.createTitledBorder(" Data Field ");
     
    //add listeners to the buttons
      ActionListener listen = new eventListener();
      addButton.addActionListener(listen);
      removeButton.addActionListener(listen);
      showAllButton.addActionListener(listen);
      zeroCoverage.addActionListener(listen);
      searchButton.addActionListener(listen);
      searchButtonAmount.addActionListener(listen);
    
    
    //Layout for the GUI
      JPanel rootGrid = new JPanel(); //First Grid on the canvas
      
      JPanel leftGrid = new JPanel(); //Grid that seperates the left columsn
      JPanel listOptions = new JPanel(); //Either add or remove
      JPanel inputContainer = new JPanel(); //the values to add or remove
    
      JPanel rightGrid = new JPanel(); //Grid that seprates the right column
      JTabbedPane filterContainer = new JTabbedPane(); //Container that holds the filter option
    
    //Layout for the filter tabs
      JPanel showAll = new JPanel(); //Container holding the display all button
      JPanel searchNameContainer = new JPanel(); //Container holding the name search fields
      JPanel searchAmount = new JPanel(); //Container holding the amount search fields
      JPanel findZero = new JPanel(); //Container to hold the findZero coverage button
      JPanel displayData = new JPanel(); //the list of patients; scrollable
    
    //Intializing their layouts
      rootGrid.setLayout(new GridLayout(1,2));
    
    //Left Colmn
      leftGrid.setLayout(new GridLayout(2,1));
      listOptions.setLayout(new GridBagLayout());
      inputContainer.setLayout(new GridLayout(10,4));
    
    //Right Column
      rightGrid.setLayout(new GridLayout(2,1));
      displayData.setLayout(new BorderLayout());
    
    //Tabs
      searchNameContainer.setLayout(new GridBagLayout());
      searchAmount.setLayout(new GridBagLayout());
      findZero.setLayout(new GridBagLayout());
      showAll.setLayout(new GridBagLayout());
       
    //Setting alignment for buttons
      addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      searchButtonAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      zeroCoverage.setAlignmentX(Component.CENTER_ALIGNMENT);
      showAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      
    //Adding border to panels
      listOptions.setBorder(title);
      displayData.setBorder(list);
      inputContainer.setBorder(dataField);
    
    //Add the Buttons to the Panels
    
      //Adding to inputContainer
      inputContainer.add(nameLabel);
      inputContainer.add(nameField);
    
      inputContainer.add(triageLabel);
      inputContainer.add(triageField);
    
      inputContainer.add(coverageLabel);
      inputContainer.add(coverageField);
    
      inputContainer.add(costLabel);
      inputContainer.add(costField);
    
      //Adding to listOptions
      listOptions.add(addButton, new GridBagConstraints());
      listOptions.add(removeButton, new GridBagConstraints());
    
      //Adding to the Panels
      showAll.add(showAllButton);
    
      searchNameContainer.add(searchName, new GridBagConstraints());
      searchNameContainer.add(searchButton, new GridBagConstraints());
    
      searchAmount.add(searchMoney, new GridBagConstraints());
      searchAmount.add(searchButtonAmount, new GridBagConstraints());
     
      findZero.add(zeroCoverage);
      
      //Adding Panels to the listOptions
      filterContainer.addTab("Name",null,searchNameContainer,"Sorts by Name");
      filterContainer.addTab("Amount",null, searchAmount, "Sorts by the Given Amount");
      filterContainer.addTab("0% Coverage",null,findZero,"Filters the people with 0% coverage");
      filterContainer.addTab("All",null, showAll, "Eradicates all filters added");
    
      //Adding the List to the displayData
      listText.setEditable(false);
      displayData.add(scrollableList);
    
    //Adding the panels together
      rootGrid.add(leftGrid);
      rootGrid.add(rightGrid);
    
      leftGrid.add(listOptions);
      leftGrid.add(inputContainer);
    
      rightGrid.add(filterContainer);
      rightGrid.add(displayData);
    
      this.add(rootGrid);
   }
  
  /**
    * Private class that adds
    * the listener to the buttons
    * and gives them their respectful
    * function
    * 
    *
    * @param none
    *
    * @exception none
    */
   private class eventListener implements ActionListener{
     
     /**
      * the method that checks
      * the source of all the actions
      * and executes a appropriate line
      * of code
      * 
      *
      * @param event the button in action
      *
      * @exception PatientException
      */
      
      public void actionPerformed(ActionEvent event) {
         //variables that will be checked with holding I/O
         Patient p;
         String name = "";
         int triage = 0;
         int percentage = 0;
         double total = 0.00;
       
         try {
            //checks source addButton
            if(event.getSource() == addButton) {
            
               name = nameField.getText().trim();
               triage =  Integer.parseInt(triageField.getText());
               percentage =  Integer.parseInt(coverageField.getText());
               total = Double.parseDouble(costField.getText());
             
               p = new Patient(name,triage,percentage,total);
            
               hospitalList.addPatient(p);
            
               JOptionPane.showMessageDialog(new JFrame(), 
                                          "Succesfully added a patient", 
                                          "Sucess!", 
                                          JOptionPane.INFORMATION_MESSAGE);
               
               //Resets the fields
               nameField.setText("");
               triageField.setText("");
               coverageField.setText("");
               costField.setText("");
               listText.setText(hospitalList.printPatients());
            }
         
            //Removes from the list
            if(event.getSource() == removeButton) {
               name = nameField.getText().trim();
               hospitalList.removePatient(name);
               listText.setText(hospitalList.printPatients());
               JOptionPane.showMessageDialog(new JFrame(), 
                                          "Succefully removed patient: " + name, 
                                          "Sucess!", 
                                          JOptionPane.INFORMATION_MESSAGE);
                          
               //Reset the fields                
               nameField.setText("");
               triageField.setText("");
               coverageField.setText("");
               costField.setText("");
            }
            //checks source addButton
            if(event.getSource() == showAllButton) {
               listText.setText(hospitalList.printPatients());
            }
            //checks source addButton
            if(event.getSource() == zeroCoverage) {
               listText.setText(hospitalList.printInsurance());
            }
            //checks source addButton
            if(event.getSource() == searchButton) {
               name = searchName.getText().trim();
               listText.setText(hospitalList.found(name));
            }
            //checks source addButton
            if(event.getSource() == searchButtonAmount) {
               total = Double.parseDouble(searchMoney.getText());
               listText.setText(hospitalList.printDebt(total));
            }
         
         }
         
         //Catches the patient exception 
         catch(PatientException e) {
            JOptionPane.showMessageDialog(new JFrame(),
                                        e.getMessage(),
                                        "Patient Error!",
                                        JOptionPane.ERROR_MESSAGE); 
         }
         
         //Catches the NumberFormat Exception
         catch(NumberFormatException i) {
            JOptionPane.showMessageDialog(new JFrame(),
                                        "A invalid value has been detected",
                                        "NumberFormatException",
                                        JOptionPane.ERROR_MESSAGE); 
         }
         
      }
      
   }
   
}