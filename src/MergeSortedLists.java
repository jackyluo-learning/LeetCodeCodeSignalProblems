import org.junit.Test;

import java.util.List;

public class MergeSortedLists {
    /*
    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        ListNode l1 = null;
        ListNode l2 = null;
    }


    public ListNode mergeSortedList1(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode lastNode = null;
        ListNode firstNode = null;
        while(current1 != null || current2 != null){
            ListNode newNode = null;
            if(current1 == null){
                newNode = new ListNode(current2.val);
                current2 = current2.next;
            }
            else if(current2 == null){
                newNode = new ListNode(current1.val);
                current1 = current1.next;
            }
            else if(current1.val >= current2.val){
                newNode = new ListNode(current2.val);
                current2 = current2.next;
            }
            else{
                newNode = new ListNode(current1.val);
                current1 = current1.next;
            }
            if(firstNode == null){
                firstNode = newNode;
            }
            if(lastNode == null){
                lastNode = newNode;
            }
            else{
                lastNode.next = newNode;
                lastNode = newNode;
            }
        }
        return firstNode;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        if(current1 == null){
            return current2;
        }
        else if(current2 == null){
            return current1;
        }
        else if(current1.val >= current2.val){
            current2.next = mergeTwoLists2(current1, current2.next);
            return current2;
        }
        else{
            current1.next = mergeTwoLists2(current2, current1.next);
            return current1;
        }
    }
}
