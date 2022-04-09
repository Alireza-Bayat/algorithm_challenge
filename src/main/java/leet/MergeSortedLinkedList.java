package leet;

import utils.ListNode;

/**
 * @author alireza_bayat
 * created on 4/3/22
 */
public class MergeSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = null;
        return mergeTwoLists(list1, list2, listNode);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2, ListNode resList) {
        if (list1 == null)
                return list2;
        else if (list2 == null)
                return list1;
        else {
            if (list1.getVal() <= list2.getVal()) {
                if (resList != null) {
                    resList.setNext(new ListNode(list1.getVal()));

                } else {
                    resList = new ListNode();
                    resList.setVal(list1.getVal());
                }
                mergeTwoLists(list1.getNext(), list2, resList);
            } else {
                if (resList != null) {
                    resList.setNext(new ListNode(list2.getVal()));

                } else {
                    resList = new ListNode();
                    resList.setVal(list2.getVal());
                }
                mergeTwoLists(list1, list2.getNext(), resList.getNext());
            }
        }
        return resList;
    }


//    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        if(l1.val < l2.val){
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else{
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }


}
