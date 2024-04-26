package project3;

/**
 * The UnsortedWordList class represents a list of words in an unsorted manner.
 * It extends the AbstractWordList class.
 */
public class UnsortedWordList extends AbstractWordList {
	/**
     * Constructor for the UnsortedWordList class.
     * Invokes the superclass AbstractWordList constructor.
     */
    public UnsortedWordList() { // A constructor that invokes the superclass WordList.
        super();
    }
    /**
     * Adds a word to the unsorted word list.
     * 
     * @param word The word to be added to the list.
     */
    public static void add(String word) { // The objective of the "add" void method is to append the specified word to the linked list.
        append(word);
    }
}
