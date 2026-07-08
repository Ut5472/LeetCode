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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        int carry = 0;
        while(l1!=null && l2!=null){
            int total = l1.val + l2.val + carry;
            ans.val = total % 10;
            carry = total/10;
            if(l1.next != null || l2.next != null || carry > 0){
                ans.next = new ListNode(0);
                ans = ans.next;
            }
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null){
            while(l1!=null){
            int total = l1.val + carry;
            ans.val = total % 10;
            carry = total/10;
            if(l1.next != null || carry > 0){
                ans.next = new ListNode(0);
                ans = ans.next;
            }
            l1=l1.next;
            }
        }
        if(l2!=null){
            while(l2!=null){
            int total = l2.val + carry;
            ans.val = total % 10;
            carry = total/10;
            if( l2.next != null || carry > 0){
                ans.next = new ListNode(0);
                ans = ans.next;
            }
            l2=l2.next;
            }
        }
        if(carry>0){
            ans.val = carry;
        }
        return temp;
        
    }
}