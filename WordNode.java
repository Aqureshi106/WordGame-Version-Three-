package project3;

/**
 * This class represents a node in a linked list that contains a word.
 */
public class WordNode { // This class is responsible for defining the node of a word in the linked lists.
	 /**
     * The word stored in this node.
     */
    protected String word; // A string variable that is protected titled "word" and is passed to the constructor.
    /**
     * The next node in the linked list.
     */
    protected WordNode next; // "next" is a protected WordNode object that is invoked to define the node following the initial node.

    /**
     * Constructs a new WordNode with the specified word.
     * 
     * @param word The word to be stored in the node
     */
    public WordNode(String word) {
        this.word = word; // The protected string variable will be assigned to the word parameter.
        next = null; // The following node is defined as null; it is assigned null indicating no node comes after.
    }
}
