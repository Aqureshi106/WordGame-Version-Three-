package project3;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 * This class implements the ActionListener interface to handle file menu actions.
 */
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   /**
    * Constructs a FileMenuHandler with the specified JFrame.
    *
    * @param jf the JFrame to be associated with this handler
    */
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   /**
    * Invoked when an action occurs in a file menu.
    *
    * @param event the action event associated with the menu action
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand(); // A string called "menuName" which is assigned to the getActionCommand event.
      if (menuName.equals("Open")) { // If the user selects "Open", they will be required to select a file, a text file to be precise.
    	  JFileChooser fd = new JFileChooser(); // A JFileChooser titled "fd" which will allow the user to choose the file.

    fd.setFileSelectionMode(JFileChooser.FILES_ONLY); // fd will allow the user to choose the file and files only using JFileChooser.
    fd.showOpenDialog(null);
	File f = fd.getSelectedFile(); // A file object called "f" which is assigned to the chosen file.
	String absolute = new String(); // A string titled "absolute" which will store the name absolute path of the chosen file.
	absolute = f.getAbsolutePath(); // "absolute" is assigned to absolutePath of "f".
	Main.open(absolute); // The main class is called with the "open" method which will pass in "absolute" to use the file for the game.
      }
      else if (menuName.equals("Quit")) // If the user chooses "Quit", the program will terminate.
          System.exit(0);
   }
}
