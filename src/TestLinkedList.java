public class TestLinkedList {
    public static void main(String[] args) {
        // create two LinkedList objects
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();

        // add values to ll1
        ll1.add(1);
        ll1.add(2);
        ll1.add(3);
        ll1.add(2);
        ll1.add(5);

        // print ll1
        System.out.println("ll1: " + ll1); // 5, 2, 3, 2, 1

        // print ll1's size
        System.out.println("ll1's size: " + ll1.size()); // 5

        // remove one node from ll1
        ll1.remove(2);

        // print ll1
        System.out.println("ll1 updated: " + ll1); // 5, 3, 2, 1

        // try to remove one node that does not exist from ll1
        ll1.remove(8);

        // print ll1
        System.out.println("ll1 updated: " + ll1); // 5, 3, 2, 1

        // print ll1's size
        System.out.println("ll1's new size: " + ll1.size()); // 4

        // check if ll1 contains the value 3
        System.out.println("Does ll1 contain the value 3? " + ll1.contain(3)); // true
        // check if ll1 contains the value 8
        System.out.println("Does ll1 contain the value 8? " +ll1.contain(8)); // false

        // add same values as current ll1 values to ll2
        ll2.add(1);
        ll2.add(2);
        ll2.add(3);
        ll2.add(5);

        // print ll1 and ll2
        System.out.println("ll1: " + ll1); // 5, 3, 2, 1
        System.out.println("ll2: " + ll2); // 5, 3, 2, 1

        // compare both lists
        System.out.println("Are both lists identical? " + ll1.compare(ll2)); // true
        // magic compare both lists
        System.out.println("Do both lists contain the same values but not in the same order? " + ll1.magicCompare(ll2)); // false

        // remove one node from ll2
        ll2.remove(5);

        // print ll1 and ll2
        System.out.println("ll1: " + ll1); // 5, 3, 2, 1
        System.out.println("ll2: " + ll2); // 3, 2, 1

        // compare both lists
        System.out.println("Are both lists identical? " + ll1.compare(ll2)); // false
        // magic compare both lists
        System.out.println("Do both lists contain the same values but not in the same order? " + ll1.magicCompare(ll2)); // false

        // remove all values from ll2
        ll2.remove(3);
        ll2.remove(2);
        ll2.remove(1);

        // print ll2
        System.out.println(ll2); // The list is empty.

        // try to remove a value from ll2
        ll2.remove(1);

        // print ll2
        System.out.println(ll2); // The list is empty.

        // print ll2's size
        System.out.println("ll2's size: " + ll2.size()); // 0

        // add same value as ll1 to ll2, but in a different order
        ll2.add(2);
        ll2.add(5);
        ll2.add(1);
        ll2.add(3);

        // print ll1 and ll2
        System.out.println("ll1: " + ll1); // 5, 3, 2, 1
        System.out.println("ll2: " + ll2); // 3, 1, 5, 2

        // compare both lists
        System.out.println("Are both lists identical? " + ll1.compare(ll2)); // false
        // magic compare both lists
        System.out.println("Do both lists contain the same values but not in the same order? " + ll1.magicCompare(ll2)); // true
    }
}
