// Lab6Skeleton.java
//


//TODO: Add proper import java.*s in this block////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
///////////////////////////////////////////////////////////////


public class Lab6 extends JFrame implements ActionListener {
    private JTextArea text;
    private JScrollPane scroller;
    private JButton cut, copy, paste, open, close;
    // Following is the constructor
    public Lab6() {
        // Task 1: Follow instructions for Stage1
        super("CSCI 241 Lab6");
	setSize(500, 300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        // Task 2: Follow instructions for Stage2 to call initialize()
	initialize();
    }
    
    //Initialize the GUI: Follow instructions for Stage 2
    private void initialize() {
        // Task 3: add a panel for the toolbar
        JPanel toolbar = new JPanel();
	add(toolbar, BorderLayout.NORTH);
        // Task 4: add buttons to the toolbar
        // Example: addButton(toolbar, cutButton, "Cut");
        //TODO: Add button for "Cut"
        //TODO: Add button for "Copy"
	addButton(toolbar, cut, "Cut");
	addButton(toolbar, copy, "Copy");
	addButton(toolbar, paste, "Paste");
        // Task 7: add a text area within a scrolling pane by following instructions for Stage 4
	text = new JTextArea();
	scroller = new JScrollPane(text);
	add(scroller, BorderLayout.CENTER);
        // Task 9: Follow instructions for Stage 6
        //TODO: Add button for "Open"  
	addButton(toolbar, open, "Open");
        // Task 12: Follow instructions for Stage 7
        //TODO: Add button for "Save" 
	addButton(toolbar, open, "Save");

    }

    // Add a button to a panel: Follow instructions for Stage 3
    private void addButton(JPanel panel, JButton button, String label) {
        //Task 5: Follow instructions for Stage 3
	button = new JButton(label);
	button.addActionListener(this);
	panel.add(button);
    }
    
    // Event-handler for button-press: Follow instructions for Stage 3
    public void actionPerformed(ActionEvent e) {
        // Task 6: Follow instructions for Stage 3
	System.out.println(e.getActionCommand() + " pressed.");
        // Task 8: Follow instructions for Stage 5
        if (e.getActionCommand() == "Cut") 
            text.cut();
        else if (e.getActionCommand() == "Copy") //--> Follow instructions for Stage 5
            text.copy();
        else if (e.getActionCommand() == "Paste")//--> Follow instructions for Stage 5
            text.paste();
        // Task 10 : Add actionPerformend for "Open"
        else if (e.getActionCommand() == "Open") // ---> Follow instructions for Stage 6
            readFile();
        // Task 13 : Add actionPerformed for "Save"
        // else if (e.getActionCommand() == "Save") // ---> Follow instructions for Stage 7
        //     writeFile();

    }
    
    // Read a file in Stage 6
    private void readFile() {
        //Task 11 --> Follow instructions for Stage 6
	JFileChooser chooser = new JFileChooser();
	int option = chooser.showOpenDialog(this);
	if (option == JFileChooser.APPROVE_OPTION) {
		try {
			String filename = chooser.getName(chooser.getSelectedFile());
			text.setText(new String(Files.readAllBytes(Paths.get(filename))));
		}
		catch (IOException e) {
			System.out.println("cannont read the file: " + e);
		}
	}
    }
    // Write to a file in Stage 7
    private void writeFile() {
        //Task 14 --> Follow instructions for Stage 7
    }
    public static void main(String[] args) {
        Lab6 frame = new Lab6();
    }

}
