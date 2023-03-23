package leet;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;

public class AddTwoNumberLinkedListTest {


    private AddTwoNumberLinkedList addTwoNumberLinkedList;

    @Before
    public void setup() {
        addTwoNumberLinkedList = new AddTwoNumberLinkedList();
    }

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(8)));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(3, new ListNode(5))));
        ListNode listNode = addTwoNumberLinkedList.addTwoNumbers(l1, l2);
        System.out.print(listNode.getVal() + "->");
        do {
            listNode = listNode.getNext();
            System.out.print(listNode.getVal() + "->");
        } while (listNode.getNext() != null);
    }
}