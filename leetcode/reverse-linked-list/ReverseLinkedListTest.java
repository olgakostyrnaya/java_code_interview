import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList;

    @BeforeEach
    void setUp() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test
    void reverseList() {
        //create nodes l1
        ListNode l1Node1 = new ListNode(1);
        ListNode l1Node2 = new ListNode(2);
        ListNode l1Node3 = new ListNode(3);
        ListNode l1Node4 = new ListNode(4);
        ListNode l1Node5 = new ListNode(5);
        //add links for l1
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;
        l1Node3.next = l1Node4;
        l1Node4.next = l1Node5;

        int[] expected = {5,4,3,2,1};

        assertArrayEquals(expected, ListNode.toIntArray(reverseLinkedList.reverseList(l1Node1)));
    }
}
