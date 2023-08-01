# merge-two-sorted-list.md

+ [merge-two-sorted-list](#merge-two-sorted-list)

## merge-two-sorted-list

https://leetcode.com/problems/merge-two-sorted-lists/

## Размышления

## Сomplexity
    Time Complexity: O(N), где N - размер наименьшего из двух связанных списков. 
    Т.к. если один из списков закончился, нам нужно просто указать ссылку на текущий элемент списка, который большей размерности 
    Memory Complexity: O(N+M), где N и M - размеры связанных списков, т.к. создаем новый список, объединяющий оба списка

<details><summary>Test Cases</summary><blockquote>

``` java
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
```

</blockquote></details>

``` java
import java.util.Arrays;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static int[] toIntArray(ListNode node) {
        int[] result = new int[5000];
        int i = 0;
        while (node != null) {
            result[i++] = node.val;
            node = node.next;
        }

        return Arrays.copyOfRange(result, 0, i);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class ListNodeMerger {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;

        return result.next;
    }
}
```