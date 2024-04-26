package project3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Project3 class contains various static methods for handling word checking and file processing.
 */
public class Project3 {
	/**
     * Extracts an array of strings from a text file.
     * 
     * @return An array of strings extracted from the text file.
     */
    public static String[] main() { // The output of this method is an array of strings extracted from a text file.
        String[] stringArray = null; // The array which will be returned.
        try {
            File file = new File("P1input.txt");
            Scanner scanner = new Scanner(file); // The first scanner will find the amount of lines in the text file.
            int count = 0; // The objective is for the scanner to determine the number of lines and store the value in the integer variable count, which will be incremented via a while loop until all lines have been counted. The while loop will conclude once all lines have been counted and the scanner will be close to prevent memory leak. 
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            scanner.close();
            scanner = new Scanner(file); // The scanner will become refreshed to now store the array with the words as the amount of lines was found which can store them all.
            stringArray = new String[count]; // The StringArray is now initialized with the count of lines collected from the integer variable "count" in line 14.
            count = 0; // The goal is to store the stringArray as the scanner will read each line, the integer variable "count" will be assigned 0 as it will be postfix incremented in a while loop to place the word in its respective index and once all the lines are read, the while loop will terminate and the scanner will close to prevent memory leak.
            while (scanner.hasNextLine()) {
                stringArray[count] = scanner.nextLine();
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) { // When a file isn't found, the exception is given and print the error information to the standard error stream to help track errors.
            e.printStackTrace();
        }
        return stringArray;
    }
    /**
     * Extracts an array of strings from a text file.
     * 
     * @return An array of strings extracted from the text file.
     */
    public static String[] getFile(String name) { // The output of this method is an array of strings extracted from a text file.
        String[] stringArray = null; // The array which will be returned.
        try {
            File file = new File(name);
            Scanner scanner = new Scanner(file); // The first scanner will find the amount of lines in the text file.
            int count = 0; // The objective is for the scanner to determine the number of lines and store the value in the integer variable count, which will be incremented via a while loop until all lines have been counted. The while loop will conclude once all lines have been counted and the scanner will be close to prevent memory leak. 
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            scanner.close();
            scanner = new Scanner(file); // The scanner will become refreshed to now store the array with the words as the amount of lines was found which can store them all.
            stringArray = new String[count]; // The StringArray is now initialized with the count of lines collected from the integer variable "count" in line 14.
            count = 0; // The goal is to store the stringArray as the scanner will read each line, the integer variable "count" will be assigned 0 as it will be postfix incremented in a while loop to place the word in its respective index and once all the lines are read, the while loop will terminate and the scanner will close to prevent memory leak.
            while (scanner.hasNextLine()) {
                stringArray[count] = scanner.nextLine();
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) { // When a file isn't found, the exception is given and print the error information to the standard error stream to help track errors.
            e.printStackTrace();
        }
        return stringArray;
    }

    /**
     * Checks if the given string contains only specified characters.
     * 
     * @param check The string to be checked.
     * @param array The array of characters to check against.
     * @return True if the string only contains characters from the array, false otherwise.
     */
    public static boolean checkLetters(String check, char[] array) { // This is a boolean method titled "checkLetters" which will use two parameters, a string and a char array which will check to see if the string does not use a letter which
        for (char letter: check.toCharArray()) { // A for each loop which will use a char variable called "letter" which will iterate through the string variable "check" which will be turned into a char array in order to iterate.
            boolean find = false;
            char lowercaseLetter = Character.toLowerCase(letter);
            for (char arrayLetter: array) { // Another for each loop which will use a char variable called "arrayLetter" which will iterate through the char array "array".
                if (lowercaseLetter == Character.toLowerCase(arrayLetter)) { // If the char variable "lowercaseLetter" is equal to the "arrayLetter" in lowercase form (turned into lowercase to ignore case), the boolean variable "find" will be assigned true and the for each loop will terminate.
                    find = true;
                    break;
                }
            }
            if (!find) { // If "find" remains false, the method will return false.
                return false;
            }
        }
        return true; // If "find" was assigned true, the method will return true.
    }

    /**
     * Checks if a given word has less than five letters.
     * 
     * @param word The word to check.
     * @return True if the word has less than five letters, false otherwise.
     */
    public static boolean lessThanFive(String word) { // This is a boolean method titled "lessThanFive" which uses one parameter being a string which will check to see if the string is less than five letters.
        if (word.length() < 5) { // If the length of the string variable "word" is less than five, the method will return true.
            return true;
        }
        return false; // If the length of "word" is greater than or equal to 5, the method will return false.
    }
    
    /**
     * Checks if the first letter of a word is valid based on specified characters.
     * 
     * @param check The word to check the first letter.
     * @param array The array of characters to check against.
     * @return True if the first letter is valid, false otherwise.
     */
    public static boolean firstLetter(String check, char[] array) { // This is a boolean method named "firstLetter" that accepts a string and a char array as parameters; its purpose is to determine whether the initial letter of the supplied letters is a legal component of the word.
        boolean find = false; // "find" is a boolean variable that will be utilized to store the outcome of the method.
        for (char letter: check.toCharArray()) { // An for each loop that utilizes the char variable "letter" to iterate over the char array "check."
            char lowercaseLetter = Character.toLowerCase(letter); // "lowercaseLetter" is a char variable that is initialized to the string "letter" in lowercase.
            if (lowercaseLetter == array[0]) { // "find" is evaluated and set to true if "lowercaseLetter" is equal to the initial letter of the array; otherwise, the iteration terminates and return find.
                find = true;
                break;
            } else { // Otherwise, it will proceed with the iteration process until the letter is located; in that case, "find" will remain false and is ultimately returned.
                continue;
            }
        }
        return find;
    }
    
    /**
     * Checks if a word contains all the specified characters.
     * 
     * @param check The word to check.
     * @param array The array of characters to check against.
     * @return True if the word contains all specified characters, false otherwise.
     */
    public static boolean allLetters(String check, char[] array) { // The "allLetters" boolean method accepts a string and a char array as parameters; its purpose is to determine whether a given word contains every letter in the array.
        boolean[] found = new boolean[array.length]; // "found" is a boolean array that contains the length of the "array" char array.

        for (char letter: check.toCharArray()) { // An for each loop that iterates over the char array "check" using the char variable "letter."
            char lowercaseLetter = Character.toLowerCase(letter); // Initializing the char variable "lowercaseLetter" to the lowercase string "letter" is its purpose.

            for (int i = 0; i < array.length; i++) { // Iterate the value of "i" in the for loop until it equals the length of the char array.
                char checkLetter = Character.toLowerCase(array[i]); // "checkLetter" is a char variable to which the lowercase value of the char array at index i is assigned.

                if (lowercaseLetter == checkLetter) { // In the event that "lowercaseLetter" is equivalent to "checkLetter," the value "found" will be set to true at index i, and the iteration will terminate.
                    found[i] = true;
                    break;
                }
            }
        }

        for (boolean isFound: found) { // The "found" value is iterated through using the boolean variable "isFound" in a for.
            if (!isFound) { // The method will return false if "isFound" is false; otherwise, it will return true at the conclusion of the iteration.
                return false;
            }
        }

        return true;
    }
    
    /**
     * Checks if a word is equal to its lowercase version.
     * 
     * @param word The word to check.
     * @return True if the word is equal to its lowercase version, false otherwise.
     */
    public static boolean checkLower(String word) { // The goal of this boolean method "checkLower" is to see if the word is equal to its lowercase version.
        if (!word.equals(word.toLowerCase())) {
            return false;
        }
        return true;
    }
}
