package LinkedList;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DetectLoopLinkedList {


    public boolean detectLoopLinkedList(LinkedList linkedList){
        HashMap<LinkedList.Node, LinkedList.Node> hashMap = new HashMap<>();
        LinkedList.Node node = linkedList.head;
        while(node != null){
            if(hashMap.containsKey(node.next)) return true;
            hashMap.put(node, node.next);
            node = node.next;
        }
        return false;
    }

    @Test
    public void test(){
        LinkedList linkedList = new LinkedList();
        linkedList.push(20);
        linkedList.push(4);
        linkedList.push(15);
        linkedList.push(10);

        linkedList.head.next.next.next = linkedList.head;
        Assert.assertTrue(detectLoopLinkedList(linkedList));
    }
}


