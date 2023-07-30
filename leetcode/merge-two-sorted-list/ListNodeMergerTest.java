package com.company.leetcode.mergetwosortedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListNodeMergerTest {
    private ListNodeMerger listNodeMerger;

    @BeforeEach
    void setUp() {
        listNodeMerger = new ListNodeMerger();
    }

    @Test
    void ifListNodeContainsNegativeNumbers() {
        ListNode prehead1 = new ListNode(-1);
        ListNode list1 = prehead1;
        list1.next = new ListNode(-2);
        list1.next = new ListNode(-1);
        list1.next = new ListNode(2);
        list1.next = new ListNode(4);

        ListNode prehead2 = new ListNode(-1);
        ListNode list2 = prehead1;
        list1.next = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next = new ListNode(6);
        list1.next = new ListNode(7);


    }

}
