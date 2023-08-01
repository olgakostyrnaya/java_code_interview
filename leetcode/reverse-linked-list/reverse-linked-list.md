# reverse-linked-list.md

+ [reverse-linked-list](#reverse-linked-list)

## reverse-linked-list

https://leetcode.com/problems/reverse-linked-list/

## Размышления
    Решение "в лоб" - записать элементы списка в массив. Создать новый связанный список на основе элементов массива, начиная с последнего.
    Не является оптимальным т.к. использует доп память для хранения элементов списка и требуется дважды пройтись по каждому из элементов списка. 
    Оптимальное решение: хранить в буфере ссылку на текущий элемент и перезаписывать ссылку next для каждого элемента. 
    Первый элемент будет иметь в next = null, а последний наоборот в next будет иметь предпоследний элемент. 
## Сomplexity 
    Для оптимального решения:
    Time Complexity: O(N) - зависим от количества элементов в исходном списке, должны пройти минимум 1 раз
    Memory Complexity: O(1) - не используем доп память

<details><summary>Test Cases</summary><blockquote>

``` java
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

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        int[] temp = new int[5000];
        int i = 0;

        while (head != null) {
            temp[i] = head.val;
            head = head.next;
            i++;
        }

        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        while (i > 0) {
            cur.next = new ListNode(temp[--i]);
            cur = cur.next;
        }

        return preHead.next;
    }

    public ListNode reverseListOptimal(ListNode head) {
        ListNode prev = null;
        ListNode current = head;


        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

```