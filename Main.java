package project3;

/**
 * The Main class contains the main method for executing the program and an open method for loading data from a file.
 */
public class Main {
    private static GUI currentGUI;
    /**
     * The main method extracts data, initializes GUI, processes data, and lays out the GUI components.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) { // The goal of the "main" method is to execute the first game.
        String[] dataSource = Project3.main(); // A string array called "dataSource" which is assigned as the result of the "main" method in the "Project3" class.
        char[] letters = dataSource[0].toCharArray(); // A char array called "letters" which is assigned to the string of dataSource at index 0 which is converted into a char array.
        currentGUI = new GUI("GUI", 900, 300, letters); // The instance object "currentGUI" is assigned to a constructor being "GUI".
        GUI interFace = null; // GUI object titled "interface" which will be passed into LayGUI method.
        WordList words = new WordList(); // A WordList objects called "words" which will be used to store the answers into the list.
        for (int i = 0; i < dataSource.length - 1; i++) { // A for loop which will be used to append each string element into the list.
            WordList.append(dataSource[i + 1]);
        }
        GUI.LayGUI(interFace, words, dataSource); // Calling the "LayGUI" method and passing in "interFace", "words" and "dataSource" which will simulate the game.
    }
    /**
     * Opens a file, extracts data, initializes GUI, processes data, and lays out the GUI components.
     * 
     * @param fileName The name of the file to open.
     */
    public static void open(String fileName) { // The goal of the "open" method is for the user to access their own file to play the game again.
    	currentGUI.dispose(); // the "currentGUI" will close the previous tab to open the new tab for the game which will use the data of the user's file.
        WordList subjects = new WordList(); // A WordList objects called "words" which will be used to store the answers into the list.
        String[] dataSource = Project3.getFile(fileName); // A string array called "dataSource" which is assigned as the result of the "getFile" method in the "Project3" class.
        char[] letters = dataSource[0].toCharArray(); // A char array called "letters" which is assigned to the string of dataSource at index 0 which is converted into a char array.
        currentGUI = new GUI("GUI", 900, 300, letters); // The instance object "currentGUI" is assigned to a constructor being "GUI".
        GUI interFace = null; // GUI object titled "interface" which will be passed into LayGUI method.
        for (int i = 0; i < dataSource.length - 1; i++) { // A for loop which will be used to append each string element into the list.
            subjects.append(dataSource[i + 1]);
        }
        GUI.LayGUI(interFace, subjects, dataSource);
    }
}
