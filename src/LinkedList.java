// Morgane Bentzinger - 261062953

/*
    Note: Since I have never really worked with recursion before but am comfortable using loops, I tried to use recursion
    whenever it was possible for practice.
 */

import java.util.ArrayList;

public class LinkedList {

    // linked list node class
    private class Node {
        public int value;
        public Node nextNode;

        // node constructor
        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }

    private Node head = null;
    private int size = 0;

    // add a new node to the linked list
    public void add(int value) {
        Node newNode = new Node(value, this.head); // create the new node and assign the current head as a next node
        this.head = newNode; // change the head to the new node
        this.size++; // increase the size of the list
    }

    // helper for recursion used in the remove method
    private void removeHelper(Node currentNode, Node previousNode, int value) {
        if(currentNode == null) { // base case
            return;
        }

        if(currentNode.value == value) {
            if(currentNode == this.head) { // if the node to remove is the head
                this.head = currentNode.nextNode; // change the head to the next node (if list contains only 1 node, head = null)
            } else {
                previousNode.nextNode = currentNode.nextNode;
            }
            currentNode.nextNode = null; // assign current node's nextNode to null
            this.size--; // decrement the size of the list
            return;
        }
        else {
            removeHelper(currentNode.nextNode, currentNode, value); // check next node
        }
    }

    // remove the first node containing the specified value from the linked list
    public void remove(int value) {
        removeHelper(this.head, null, value); // check first node
    }

    // getter for LinkedList size
    public int size() {
        return this.size;
    }

    // helper for recursion used in the contain method
    private boolean containHelper(Node currentNode, int value) {
        if(currentNode == null) { // base case
            return false;
        }

        if(currentNode.value == value) { // if the current node contains the value
            return true;
        } else {
            return containHelper(currentNode.nextNode, value); // check next node
        }
    }

    // check if the LinkedList contains a value
    public boolean contain(int value) {
        return containHelper(this.head, value); // check first node
    }

    // convert a node to a string
    private static String nodeToString(Node currentNode) {
        if(currentNode.nextNode == null) { // if the current node is the last node
            return currentNode.value + "";
        }
        else {
            return currentNode.value + ", " + nodeToString(currentNode.nextNode); // check next node
        }
    }

    // use nodeToString to convert the whole linked list to a string
    @Override
    public String toString() {
        Node currentNode = this.head;

        if(currentNode == null) { // if the first node is null
            return "The list is empty.";
        }
        else {
            return nodeToString(currentNode); // convert current node to string
        }
    }

    // check if two linked lists are identical
    public boolean compare(LinkedList ll) {
        // check if the string versions of the two lists are identical
        if(this.toString().equals(ll.toString())) {
            return true;
        }
        else {
            return false;
        }
    }

    // convert a linked list to an ArrayList
    private ArrayList<Integer> listToArray(Node currentNode, ArrayList<Integer> arrayList) {

        if(currentNode == null) { // base case
            return arrayList;
        }

        arrayList.add(currentNode.value); // add current node's value to ArrayList
        return listToArray(currentNode.nextNode, arrayList); // go to next node
    }

    public boolean magicCompare(LinkedList ll) {

        if(this.compare(ll) || this.size != ll.size) { // if the linked list are exactly identical or if their sizes are not the same
            return false;
        }

        // create array lists with the values of the linked lists
        ArrayList<Integer> valuesList1 = listToArray(this.head, new ArrayList<Integer>());
        ArrayList<Integer> valuesList2 = listToArray(ll.head, new ArrayList<Integer>());

        // sort the array lists values
        valuesList1.sort(null);
        valuesList2.sort(null);

        // compare the array lists
        return valuesList1.equals(valuesList2);
    }

}
