/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOn = 0;
        ListNode head = null;
        ListNode last = null;
        
        while(l1 != null || l2 != null)
        {
            int val1 = l1 != null ? l1.val : 0;
            if(l1 != null)
            {
                l1 = l1.next;
            }
            
            int val2 = l2 != null ? l2.val : 0;
            if(l2 != null)
            {
                l2 = l2.next;
            }
            
            int digit = (val1 + val2 + carryOn) % 10;
            carryOn = (val1 + val2 + carryOn) / 10;
           
            if(head == null)
            {
                head = new ListNode(digit);
                last = head;
            }
            else
            {
                last.next = new ListNode(digit);
                last = last.next;
            }
        }
        
        if(carryOn != 0)
        {
            last.next = new ListNode(carryOn);
        }
        
        return head;       
    }
}
