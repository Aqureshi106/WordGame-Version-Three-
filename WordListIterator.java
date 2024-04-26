package project3;

/**
 * The WordListIterator class facilitates iteration over a linked list of words.
 */
public class WordListIterator { // The objective of this class is to facilitate linked list iteration.
    private WordNode node; // The "node" private WordNode object is utilized to access individual nodes.
    /**
     * Constructs a new WordListIterator with the specified initial node.
     * 
     * @param first The first node in the linked list
     */
    public WordListIterator(WordNode first) { // This constructor declares the initial node of the linked list.
        node = first; // The word "first" is assigned to the node, which defines the initial node.
    }
    /**
     * Returns true if there is a next node in the linked list, false otherwise.
     * 
     * @return True if there is a next node, false otherwise
     */
    public boolean hasNext() { // The purpose of this method is to determine whether a node follows the initial one.
        return (node != null); // True is returned if node is not defined as null; false is returned if it is.
    }
    /**
     * Returns the data of the next node in the linked list as a string.
     * 
     * @return The data of the next node as a string
     * @throws NullPointerException if the linked list is empty
     */
    public String next() { // Returning the data of the linked list in the form of the following node as a string is the objective of this string method.
        if (node == null)
            throw new NullPointerException("Linked list empty."); // A nullPointerException will be thrown in the event that the node is null, signifying that the linked list is devoid of any nodes.
        String currentData = node.word; // A string variable named "currentData" will be assigned the node from the WordNode class that is connected to the word if this condition is not met.
        node = node.next; // Node will be allocated the following node.
        return currentData; // Returns the current data of the nodes.
    }

}
