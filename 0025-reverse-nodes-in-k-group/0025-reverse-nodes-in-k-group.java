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
    public static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return prev;
    }
    public static ListNode findKth(ListNode head,int k){
        while(head!=null && k>1){
            head=head.next;
            k--;
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevNode=null;
        ListNode nextNode=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode kthNode=findKth(temp,k);
            if(kthNode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                    break;
                }
            }else{
                nextNode=kthNode.next;
                kthNode.next=null;
                ListNode reversedHead=reverse(temp);
                if(temp==head){
                    head=reversedHead;
                }else{
                    prevNode.next=reversedHead;
                }
                prevNode=temp;
                temp=nextNode;
            }
        }
        return head;
    }
}