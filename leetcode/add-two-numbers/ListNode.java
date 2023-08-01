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