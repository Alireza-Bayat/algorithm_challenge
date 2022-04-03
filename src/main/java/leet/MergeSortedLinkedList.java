package leet;

import utils.ListNode;

/**
 * @author alireza_bayat
 * created on 4/3/22
 */
public class MergeSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        else {
            //TODO cases swap and other
            if (list1.getVal() <= list2.getVal())
                return null;
        }
        return list1;
    }

}
