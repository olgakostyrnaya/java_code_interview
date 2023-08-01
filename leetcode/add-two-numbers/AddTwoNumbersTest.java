import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AddTwoNumbersTest {
    private AddTwoNumbers addTwoNumbers;

    @BeforeEach
    void setUp() {
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    void whenLengthOfListsDifferents() {
        //create nodes for l1
        ListNode l1Node1 = new ListNode(9);
        ListNode l1Node2 = new ListNode(9);
        ListNode l1Node3 = new ListNode(9);
        ListNode l1Node4 = new ListNode(9);
        //add links for l1
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;
        l1Node3.next = l1Node4;

        //create nodes for l2
        ListNode l2Node1 = new ListNode(9);
        ListNode l2Node2 = new ListNode(9);
        ListNode l2Node3 = new ListNode(9);
        ListNode l2Node4 = new ListNode(9);
        ListNode l2Node5 = new ListNode(9);
        ListNode l2Node6 = new ListNode(9);
        ListNode l2Node7 = new ListNode(9);
        //add links for l2
        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;
        l2Node3.next = l2Node4;
        l2Node4.next = l2Node5;
        l2Node5.next = l2Node6;
        l2Node6.next = l2Node7;

        int[] expected = {8,9,9,9,0,0,0,1};

        assertArrayEquals(expected, ListNode.toIntArray(addTwoNumbers.addTwoNumbers(l1Node1,l2Node1)));
    }
}
