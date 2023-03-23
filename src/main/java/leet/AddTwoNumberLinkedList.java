package leet;

import utils.ListNode;

public class AddTwoNumberLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultListNode = new ListNode(0);
        ListNode result = resultListNode;
        while (l1 != null | l2 != null | carry == 1) {
            int nodeValue = 0;
            if (l1!= null){
                nodeValue += l1.getVal();
                l1 = l1.getNext();
            }

            if (l2!= null){
                nodeValue += l2.getVal();
                l2 = l2.getNext();
            }
            nodeValue = nodeValue+ carry;
            carry = nodeValue /10;
            resultListNode.setNext(new ListNode((nodeValue% 10)));
            resultListNode = resultListNode.getNext();
        }
        return result.getNext();
    }
}
