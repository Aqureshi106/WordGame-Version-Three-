package project3;

/**
 * The WordList class is responsible for constructing a linked list of words.
 * It extends the WordListAbstract class.
 */
public class WordList extends WordListAbstract { // This abstract class is responsible for constructing the linked list.
	/**
     * Constructor for the WordList class.
     * Invokes the superclass WordListAbstract.
     */
    public WordList() { // A constructor that invokes the superclass WordList.
        super();
    }
    /**
     * Adds a word to the linked list.
     * 
     * @param word The word to be added to the linked list.
     */
    public static void add(String word) { // The objective of the "add" void method is to append the specified word to the linked list.
        append(word);
    }
}
