package project3;

/**
 * This abstract class is responsible for constructing and managing a linked list of words.
 */
public abstract class WordListAbstract { // This abstract class is responsible for constructing the linked list.
	/**
     * Protected static WordNode object representing the first node in the linked list.
     */
    protected static WordNode first = new WordNode(null); // "first" is the name of a protected static WordNode object that is initialized to null.
    /**
     * Protected static WordNode object representing the last node in the linked list.
     */
    protected static WordNode last = first; // "last" is the name of a protected static WordNode object that is initialized to the initial node.
    /**
     * Protected static integer variable representing the length of the linked list.
     */
    protected static int length = 0; // "length" is a protected static integer variable that is initialized to zero.

    /**
     * Returns the current length of the linked list.
     * 
     * @return The length of the linked list
     */
    public static int getLength() { // The objective of the "getLength" integer method is to obtain the list's length so that nodes can be appended.
        return length;
    }

    /**
     * Appends a new node with the specified word to the linked list.
     * 
     * @param word The word to append to the linked list
     */
    public static void append(String word) { // The objective of the "append" void method is to append the String parameter "word" as a node to the linked list.
        WordNode newNode = new WordNode(word); // A WordNode object denoted as "newNode" is utilized to create a new WordNode when the string parameter is passed in.

        if (length == 0) { // The subsequent node will be allocated the new node if the length is set to 0. and the final node will be established.
            first.next = newNode;
            last = newNode;
        } else { // In the absence of that, a WordNode object designated as "current" will be allocated from the node following the initial one, while one designated as "prev" will be assigned from the first node.
            WordNode current = first.next;
            WordNode prev = first;

            while (current != null && word.toString().compareTo(current.word.toString()) > 0) { // In cases where the current node is not null and "word" is greater than zero in comparison to the current node, the preceding node will be assigned current, and the current node will be assigned the node that follows it.
                prev = current;
                current = current.next;
            }
            prev.next = newNode; // The new node will be assigned to the node following prev.
            newNode.next = current; // The node that is designated as the current node will follow the newNode.

            if (current == null) { // If the current node is null, the new node will be assigned last.
                last = newNode;
            }
        }

        length++; // As the list is appended, the length will be incremented.
    }

    /**
     * Returns a string representation of the linked list.
     * 
     * @return A string representation of the linked list
     */
    public String toString() { // This method's objective is to transform a WordNode into a string.
        WordNode p = first.next; // A WordNode object with the id "p" that is assigned the node following the initial one.
        String returnString = ""; // Initialized with an empty string, the string variable "returnString" is utilized to return the node as a string.
        while (p != null) { // // If "p" is not null, the node and "returnString" will be concatenated, resulting in the node being converted to a string before being assigned to the node.
            returnString += p.word + " ";
            p = p.next;
        }
        return returnString.toLowerCase(); // The node is returned in lowercase string format.
    }
    
    /**
     * Checks if the linked list contains the specified word.
     * 
     * @param word The word to search for in the linked list
     * @return true if the word is found, false otherwise
     */
    public static boolean contains(String word) { // The "contains" boolean method verifies whether the specified word is present in the linked list.
        WordNode node = first.next; // An additional node is declared and allocated to follow the initial node.
        while (node != null) { // In the event that the node not equal to null and the parameter is also equal to the node to be converted into a string (ignoring case), the method will return true; otherwise, the node will be assigned to the subsequent node.
            if (node.word.equalsIgnoreCase(word)) {
                return true;
            }
            node = node.next;
        }
        return false; // The consequence in the absence of the word within the linked list.
    }
    
    /**
     * Removes a node with the specified word from the linked list.
     * 
     * @param word The word to remove from the linked list
     */
    public void remove(String word) { // The void method "remove" task is to remove a node from the list.
        WordNode current = first.next; // A WordNode called "current" assigned to a node after the first.
        WordNode previous = first; // A WordNode called "previous" assigned to the first node.

        while (current != null) { // A while loop which iterates as long as current is not null checks to see if the current node as a string is equal to the parameter "word", the node after previous will be assigned the node after current.
            if (current.word.equals(word)) {
                previous.next = current.next;
                if (current == last) { // If current is equal to the last node, last will be assigned the previous node.
                    last = previous;
                }
                length--; // As the list removes a node, the length will be decremented.
                return;
            }

            previous = current; // Previous is assigned to current.
            current = current.next; // current is assigned to the node after it.
        }
    }
    
    /**
     * Clears the linked list by removing all nodes with empty or null data.
     */
    public void clear() { // The void method "clear" task is to erase all the nodes from the list.
        WordNode current = first.next; // Start from the first node after the initial node
        WordNode previous = first; // Initialize previous as the first node

        while (current != null) {
            if (current.word != null && !current.word.trim().isEmpty()) { // Check if the current node contains a string
                previous.next = current.next; // Remove the node by updating the references
                if (current == last) {
                    last = previous; // Update the last node if the removed node was the last one
                }
                length--; // Decrement the length of the linked list
            } else {
                previous = current; // Move to the next node
            }
            current = current.next;
        }
    }
}
