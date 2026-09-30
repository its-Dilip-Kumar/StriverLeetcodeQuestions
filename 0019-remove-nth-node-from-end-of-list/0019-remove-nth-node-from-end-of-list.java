/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }

        int nthFromStart=count-n+1;
        if(nthFromStart==1) return head.next;

        temp=head;
        for(int i=1;i<nthFromStart-1;i++){
            temp=temp.next;
        }

        temp.next=temp.next.next;
        return head;
    }
}