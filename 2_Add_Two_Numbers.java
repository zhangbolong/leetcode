/*
You are given two linked lists representing two non-negative numbers. The 
digits are stored in reverse order and each of their nodes contain a 
single digit. Add the two numbers and return it as a linked list.

@Example 
    342 + 465 = 807
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
@基本思路
    先建一个Head Node, 然后算l1和l2的加法，考虑并处理Carry,用一个point来做指针，当l1或l2任意一方枯竭后，分别对l1和l2单独
    做加法，最后等到l1和l2都枯竭了，看看还有没有carry，有carry的话前面再加一个1，最后返回的是head.next
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null & l2 == null){
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum%10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }

        while(l1 != null){
            int sum = carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            point = point.next;
        }

        while(l2 != null){
            int sum = carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l2.next;
            point = point.next;
        }

        if(carry !=0 ){
            point.next = ListNode(carry);
        }
        return head.next;
    }
}