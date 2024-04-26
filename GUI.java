package project3;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

/**
 * GUI class represents the graphical user interface for the word puzzle game.
 */
public class GUI extends JFrame {
    protected static JTextArea list = new JTextArea(); // A protected static JTextArea object titled "list" which will display the correctly guessed words of the user on the GUI.
    protected static JTextArea score = new JTextArea(); // A protected static JTextArea object titled "score" which will display the score of the user on the GUI.
    protected static JLabel lettersLabel = new JLabel(); // A protected static JLabel object titled "lettersLabel" which will display the letters that the user is given to find the words.
    protected static int points; // A protected static integer titled "points" which will represent the score of the user.
    protected static int counter = 0; // A protected static integer titled "counter" which represents the amount of times of which the user found the correct input.
    /**
     * Constructs a GUI with the specified title, height, width, and subject line.
     *
     * @param title       the title of the GUI
     * @param height      the height of the GUI
     * @param width       the width of the GUI
     * @param subjectLine the array of characters representing the subject line
     */
    public GUI(String title, int height, int width, char[] subjectLine) { // The goal of this method is to define the GUI which has four parameters, being a string called "title", an integer called "height", another integer called "width" and a char array called "subjectLine".
        setExtendedState(JFrame.NORMAL); // This will set the frame to not a maximized nor a minimized frame, but a rather normal state.
        setTitle("PuzzleGUI"); // This defines the title of the GUI 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // The close application which if the user clicks the "close" button, the program terminates.
        setLocation(330, 0); // The location for the GUI where it will be displayed on the screen.
        createFileMenu(); // The menubar which will be displayed on the GUI.
        setLayout(new GridBagLayout()); // The layout of the GUI will be a GridBagLayout as it will be efficient to make the rows and columns this way.
        setSize(860, 400); // The size of the GUI.

        StringBuilder builder = new StringBuilder(); // A StringBuilder called "builder" which will be used to space the letters from "letters" for easier view.
        for (char letter: subjectLine) { // A for each loop which will use a char variable "letter" and iterate through "letters".
            builder.append(letter).append("   "); // As "builder" garners the characters and turns them to strings, it will append a space in order to separate them in terms of the GUI view.
        }
        lettersLabel = new JLabel("  Letters:  " + builder);

        GridBagConstraints constraintOne = new GridBagConstraints(); // a GridBagConstraints titled "constraintOne" which is a class that helps to organize the grid layout.
        constraintOne.gridx = 1; // The column.
        constraintOne.gridy = 0; // The row.
        constraintOne.weightx = 1.0; // The space within the layout
        constraintOne.fill = GridBagConstraints.HORIZONTAL; // The space created will be horizontal.
        add(lettersLabel, constraintOne); // "lettersLabel" is added to the GUI in constraintOne.

        GridBagConstraints constraintTwo = new GridBagConstraints(); // a GridBagConstraints titled "constraintOne" which is a class that helps to organize the grid layout.
        constraintTwo.gridx = 2; // The column.
        constraintTwo.gridy = 0; // The row.
        constraintTwo.weightx = 2.0; // The space within the layout
        constraintTwo.fill = GridBagConstraints.HORIZONTAL; // The space created will be horizontal.
        add(list, constraintTwo); // "list" is added to the GUI in constraintTwo.

        GridBagConstraints constraintThree = new GridBagConstraints(); // a GridBagConstraints titled "constraintOne" which is a class that helps to organize the grid layout.
        constraintThree.gridx = 2; // The column.
        constraintThree.gridy = 1; // The row.
        constraintThree.weightx = 3.0; // The space within the layout
        constraintThree.fill = GridBagConstraints.HORIZONTAL; // The space created will be horizontal.
        add(score, constraintThree); // "score" is added to the GUI in constraintThree.
        score.setText("Score: " + points + "\n"); // "score" begins with points being displayed as 0.

        list.setEditable(false); // The list cannot be edited in the GUI by the user, therefore read-only.
        score.setEditable(false); // The score cannot be edited in the GUI by the user, therefore read-only.
        setVisible(true); // The GUI will be displayed.
    }

    /**
     * Layout the components of the GUI for the word puzzle game.
     *
     * @param puzzleGUI the GUI object for the puzzle game
     * @param words     the WordList object containing the words for the game
     * @param data      the array of strings for data input
     */
    public static void LayGUI(GUI puzzleGUI, WordList words, String[] data) { // This is a void method called "LayGUI" which will have three parameters, an object called "puzzleGUI", an object called "words" and a string array called "data" which the goal is to form the functions of the GUI.
        points = 0; // "points" will be assigned 0 as that is the score the user will begin with.
        String[] dataSource = data; // A string array titled "dataSource" which is assigned the data parameter.
        UnsortedWordList unsortedWordList = new UnsortedWordList(); // An UnsortedWordList object called "unsortedWordList" which will store the correctly guessed words.
        SortedWordList sortedWordList = new SortedWordList(); // A SortedWordList object called "sortedWordList" which will contain the words and listed in alphabetical order.
        char[] letters = dataSource[0].toCharArray(); // a char array called "letters" which is assigned the dataSource string at index 0 which will be turned into a char array.
        int limit = words.getLength(); // An integer variable called "limit" which will be used for the while loop for which if they user reaches it, it indicates they found all the words to end the game.
        while (counter < limit) { // A while loop which will terminate until counter is equal to "limit".
            String input = JOptionPane.showInputDialog(puzzleGUI, "Please type a word composed solely of the provided letters but must contain the first letter."); // A string variable titled "input" which will be assigned to what the user types in the input dialog of the JOptionPane.
            if (WordList.contains(input) == false && Project3.lessThanFive(input) == true && Project3.checkLetters(input, letters) == false) { // If "contains" and "checkLetters" are false but "lessThanFive" is true, the message dialog will reveal the input was less than five letters.
                JOptionPane.showMessageDialog(puzzleGUI, "Your guess is less than five letters long.");
            } else if (words.contains(input) == false && Project3.lessThanFive(input) == true && Project3.checkLetters(input, letters) == true) { // If "contains" is false but "lessThanFive" and "checkLetters" are true, though the letters were used, the message dialog will reveal the input was less than five letters.
                JOptionPane.showMessageDialog(puzzleGUI, "Your guess is less than five letters long.");
            } else if (words.contains(input) == false && Project3.lessThanFive(input) == false && Project3.checkLetters(input, letters) == false) { // If "contains", "lessThanFive", and "checkLetters" are all false, the message dialog will reveal the input contained a letter(s) which were not apart of "letters".
                JOptionPane.showMessageDialog(puzzleGUI, "Your guess uses a letter(s) that is not apart of the seven letters given.");
            } else if (words.contains(input) == false && Project3.lessThanFive(input) == false && Project3.checkLetters(input, letters) == true) { // If "contains" and "lessThanFive" are false but "checkLetters" is true, the message dialog will reveal the input is not apart of "words".
                JOptionPane.showMessageDialog(puzzleGUI, "Your guess is not in the solutions list.");
            } else if (words.contains(input) == true && Project3.lessThanFive(input) == true && Project3.checkLetters(input, letters) == true) { // If "contains" and "lessThanFive" and "checkLetters" is true, it means there is a word in the file but it is illegal and therefore a message will be displayed to indicate this and the word will be removed from the list and limit will be decremented by 1 to indicate this change.
                JOptionPane.showMessageDialog(puzzleGUI, "This guess is correct but is illegal and will be removed from the solutions list.");
                words.remove(input);
                limit -= 1;
            } else if (words.contains(input) == true && Project3.lessThanFive(input) == false && Project3.checkLetters(input, letters) == true) { // If "lessThanFive" is false and "contains" and "checkLetters" are true, the user has found a word apart of "words".
                if (counter == 0) { // If counter is equal to 0, it will not check if the word is in the "unsortedWordList" and do checks regarding being in lowercase and if it has the first letter of the subject line and if it contains all the letters of the subject line.
                    if (Project3.checkLower(input)) { // If the input is not in lowercase, an exception will be given declaring that it is an illegal input and will display the illegal input in the console.
                        if (Project3.firstLetter(input, letters)) { // If the first letter of the subject line is not in the input, a message will be displayed regarding this, the word is illegal and will be removed from the list.
                            if (!Project3.allLetters(input, letters)) { // If the input does not contain all the letters of the subject line, the user will only receive one point rather than three.
                                points += 1;

                                unsortedWordList.append((input));
                                list.setText(sortedWordList + "\n");
                                score.setText("Score: " + points + "\n");
                                counter++;
                            } else {
                                points += 3;
                                unsortedWordList.append((input));
                                list.setText(sortedWordList + "\n");
                                score.setText("Score: " + points + "\n");
                                counter++;
                            }
                        } else {
                            JOptionPane.showMessageDialog(puzzleGUI, "Your guess does not contain the first letter.");
                            words.remove(input);
                        }
                    } else {
                        try {
                            throw new IllegalWordException("The input " + input + " is not lowercase");
                        } catch (IllegalWordException e) {
                            System.out.println(input);
                            JOptionPane.showMessageDialog(puzzleGUI, e.getMessage());
                        }
                        continue;
                    }
                } else { // If the counter is greater than 0, the input will be checked within the unsortedWordList to see if the guess was already found.
                    if (unsortedWordList.contains(input) == false) {
                        if (Project3.firstLetter(input, letters)) {
                            if (Project3.checkLower(input)) {
                                if (!Project3.allLetters(input, letters)) {
                                    points += 1;
                                    unsortedWordList.append((input));
                                    list.setText(sortedWordList + "\n");
                                    score.setText("Score: " + points + "\n");
                                    counter++;
                                } else {
                                    points += 3;
                                    unsortedWordList.append((input));
                                    list.setText(sortedWordList + "\n");
                                    score.setText("Score: " + points + "\n");
                                    counter++;
                                }
                            } else {
                                try {
                                    throw new IllegalWordException("The input " + input + " is not lowercase");
                                } catch (IllegalWordException e) {
                                    System.out.println(input);
                                    JOptionPane.showMessageDialog(puzzleGUI, e.getMessage());
                                }
                                continue;
                            }
                        } else {
                            JOptionPane.showMessageDialog(puzzleGUI, "Your guess does not contain the first letter.");
                            words.remove(input);
                        }
                    } else {
                        JOptionPane.showMessageDialog(puzzleGUI, "Your guess was already found."); // If the input is already in the linked list, it will display the showMessageDialog from JOptionPane to let the user know.
                        continue; // The loop will continue for a correct input.
                    }
                }
            }
        }

        int select = JOptionPane.showConfirmDialog(puzzleGUI, "Congratulations! You found all the words; would you like to play again?"); // If the counter reaches the limit, the while loop is terminated meaning the words were all found and the a message is displayed congratulating the user and prompts them to answer if they'd like to play again using their own file.
        if (select == 1) { // If the user selects "No", the program will terminate.
            System.exit(0);
        } else if (select == 0) { // If the user selects "Yes", the points, list, score, letterslabel, counter, unsortedWordList, and words will be restarted and the user must use the menubar to select their own file to play the game again or find the same file to play the same as before.
            points = 0;
            list.setText("");
            score.setText("Score: " + points + "\n");
            lettersLabel.setText("  Letters:  ");
            counter = 0;
            unsortedWordList.clear();
            words.clear();
        }
    }

    /**
     * Create the file menu for the GUI with "Open" and "Quit" options.
     */
    private void createFileMenu() { // The file menu which will be displayed on the GUI.
        JMenuItem item; // A JMenuItem object called "item" which defines the choices on the file menu.
        JMenuBar menuBar = new JMenuBar(); // A JMenuBar object called "menuBar" which defines the menu bar for the file menu.
        JMenu fileMenu = new JMenu("File"); // A JMenu object called "fileMenu" which will display the file option on the menu bar of the file menu.
        FileMenuHandler fmh = new FileMenuHandler(this); // A FileMenuHandler object called "fmh" which is used to determine result of using the menu bar.

        item = new JMenuItem("Open"); // item is assigned "Open".
        item.addActionListener(fmh); // The item is given an action if used.
        fileMenu.add(item); // The item is added to the file menu.

        fileMenu.addSeparator(); // The file menu separates the previous item with the next item.

        item = new JMenuItem("Quit"); // item is assigned "Quit".
        item.addActionListener(fmh); // Te item is given an action if used.
        fileMenu.add(item); // The item is added to the file menu.

        setJMenuBar(menuBar); // The menu bar is set.
        menuBar.add(fileMenu); // The menu bar is added to the fileMenu.
    }
}
