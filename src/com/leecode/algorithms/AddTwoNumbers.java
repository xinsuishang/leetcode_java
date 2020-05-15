package com.leecode.algorithms;

/**
 * @author xinsuishang
 * @description https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @date 2020/5/15 14:58
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + temp;
            temp = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (temp == 1) {
            cur.next = new ListNode(temp);
        }
        return pre.next;

    }
}
