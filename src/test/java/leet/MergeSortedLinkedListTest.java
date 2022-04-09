package leet;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;

public class MergeSortedLinkedListTest {

    private MergeSortedLinkedList mergeSortedLinkedList;
    private ListNode listNode1;
    private ListNode listNode2;

    @Before
    public void setup() {
        mergeSortedLinkedList = new MergeSortedLinkedList();
        listNode1 = new ListNode(1, new ListNode(5, new ListNode(10)));
        listNode2 = new ListNode(2, new ListNode(4, new ListNode(12)));
    }

    @Test
    public void testMergeTwoLists() {
        printList(mergeSortedLinkedList.mergeTwoLists(listNode1, listNode2));
    }

    private void printList(ListNode list) {
        while (list.getNext() != null)
            System.out.print(list.getVal() + " -> ");
    }
}