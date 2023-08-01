import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ListNodeMergerTest {
    private ListNodeMerger listNodeMerger;

    @BeforeEach
    void setUp() {
        listNodeMerger = new ListNodeMerger();
    }


    @Test
    void ifListNodeContainsNegativeNumbers() {
        //create nodes for l1
        ListNode l1Node1 = new ListNode(-2);
        ListNode l1Node2 = new ListNode(-1);
        ListNode l1Node3 = new ListNode(2);
        ListNode l1Node4 = new ListNode(4);
        //add links for l1
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;
        l1Node3.next = l1Node4;

        //create nodes for l2
        ListNode l2Node1 = new ListNode(1);
        ListNode l2Node2 = new ListNode(3);
        ListNode l2Node3 = new ListNode(5);
        ListNode l2Node4 = new ListNode(7);
        //add links for l2
        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;
        l2Node3.next = l2Node4;

        int[] expected = {-2,-1,1,2,3,4,5,7};

        assertArrayEquals(expected, ListNode.toIntArray(listNodeMerger.mergeTwoLists(l1Node1,l2Node1)));
    }

    @Test
    void ifListNodeDifferentSize() {
        //create nodes for l1
        ListNode l1Node1 = new ListNode(0);
        ListNode l1Node2 = new ListNode(2);
        ListNode l1Node3 = new ListNode(5);
        //add links for l1
        l1Node1.next = l1Node2;
        l1Node2.next = l1Node3;

        //create nodes for l2
        ListNode l2Node1 = new ListNode(6);
        ListNode l2Node2 = new ListNode(9);
        ListNode l2Node3 = new ListNode(10);
        ListNode l2Node4 = new ListNode(11);
        //create links for l2
        l2Node1.next = l2Node2;
        l2Node2.next = l2Node3;
        l2Node3.next = l2Node4;

        int[] expected = {0,2,5,6,9,10,11};

        assertArrayEquals(expected, ListNode.toIntArray(listNodeMerger.mergeTwoLists(l1Node1,l2Node1)));
    }
}
