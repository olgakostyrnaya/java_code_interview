import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    private AddTwoNumbers addTwoNumbers;

    @BeforeEach
    void setUp() {
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    void whenLengthOfListsDifferents() {
        //l1 = [9,9,9,9];
        //l1 = [9,9,9,9,9,9,9]

        ListNode prehead1 = new ListNode(-1);
        ListNode l2 = prehead1;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;
        l2.next = new ListNode(9);
        l2 = l2.next;

        ListNode prehead2 = new ListNode(-1);
        ListNode l1 = prehead2;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;
        l1.next = new ListNode(9);
        l1 = l1.next;

        //System.out.println(addTwoNumbers.addTwoNumbers(prehead1.next,prehead2.next).toString());

        //expected [8,9,9,9,0,0,0,1]
    }
}
