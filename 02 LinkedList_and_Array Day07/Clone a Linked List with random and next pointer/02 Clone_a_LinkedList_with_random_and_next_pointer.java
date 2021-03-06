/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current = head;
        
        while( current != null){
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = current.next.next;
        }
        
        current = head;
        while( current != null){
            current.next.random = current.random == null ? null: current.random.next;
            current = current.next.next;
        }
        
        Node dummyHead = new Node(-1);
        Node dummy = dummyHead;
        current = head;
        
        while(current != null){
            dummy.next = current.next;
            dummy = dummy.next;
            current.next = current.next.next;
            current = current.next;
            
        }
        
        return dummyHead.next;
    }
}
