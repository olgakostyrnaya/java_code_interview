# add-two-numbers.md

+ [add-two-numbers](#add-two-numbers)

## add-two-numbers

https://leetcode.com/problems/add-two-numbers/

## Размышления
    При сложении чисел "в столбик" логика у нас следующая: 
    мы складываем числа двух слагаемых одинакового разряда и если сумма превышает 10, мы "запоминаем единичку" 
    и записываем остаток этой суммы от целочисленного деления на 10. Если связанные списки разной размерности, 
    то нужно не забыть прибавить единичку, которую мы запомнили к элементу списка большей длины.         

## Сomplexity
    Time Complexity: O(N+M), где N и M размерности списков
    Memory Complexity: O(N+M), т.к. храним результат в новом списке, максимальным размером N+M

<details><summary>Test Cases</summary><blockquote>

``` java
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
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode result = preHead;
        int carry = 0;

        while (l1 != null && l2 != null) {
            if (l1.val + l2.val + carry > 9) {
                result.next = new ListNode((l1.val + l2.val + carry) % 10);
                carry = 1;
            } else {
                result.next = new ListNode((l1.val + l2.val) % 10 + carry);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }

        while (l1 != null && carry > 0) {
            if (l1.val + carry > 9) {
                result.next = new ListNode((l1.val + carry) % 10);
            } else {
                result.next = new ListNode((l1.val) % 10 + carry);
                carry = 0;
            }
            l1 = l1.next;
            result = result.next;
        }

        while (l2 != null && carry > 0) {
            if (l2.val + carry > 9) {
                result.next = new ListNode((l2.val + carry) % 10);
            } else {
                result.next = new ListNode((l2.val) % 10 + carry);
                carry = 0;
            }
            l2 = l2.next;
            result = result.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
            result = result.next;
        }

        result.next = l1 == null ? l2 : l1;

        return preHead.next;
    }


    public ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;

        int carry = 0;

        while (l1 != null || l2 != null) {
            // Use value as 0 from the list that ended shorter than the other.
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            int sum = l1Val + l2Val + carry;

            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;

            result.next = new ListNode(sum);
            result = result.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            result.next = new ListNode(carry);
        }

        return head.next;
    }
}
```