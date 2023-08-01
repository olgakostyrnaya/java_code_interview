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
