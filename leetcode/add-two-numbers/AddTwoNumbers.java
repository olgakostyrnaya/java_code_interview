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



//    class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            ListNode result = new ListNode();
//            ListNode head = result;
//
//            int carry = 0;
//
//            while (l1 != null || l2 != null) {
//                // Use value as 0 from the list that ended shorter than the other.
//                int l1Val = l1 != null ? l1.val : 0;
//                int l2Val = l2 != null ? l2.val : 0;
//
//                int sum = l1Val + l2Val + carry;
//
//                carry = sum >= 10 ? 1 : 0;
//                sum = sum % 10;
//
//                result.next = new ListNode(sum);
//                result = result.next;
//                l1 = l1 != null ? l1.next : null;
//                l2 = l2 != null ? l2.next: null;
//            }
//
//            if (carry != 0) {
//                result.next = new ListNode(carry);
//            }
//
//            return head.next;
//        }
//    }
}