package InterviewDuck.linkList;

/**
 * @Author Devin
 * @Date 2025/6/22 14:11
 * @Description:
 **/
//判断一个链表中是否有环：https://www.mianshiya.com/bank/1824426910944350209/question/1824426911372169217#heading-0
//使用快慢指针的方法，快指针一次走两步，慢指针一次走一步，如果有环，快慢指针始终会相遇
//如果没有环，则慢指针或者快指针会遍历到链表最后，都不会与快指针相遇
public class N2LinkListHasCycle {

    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){
            if(fast == null || slow == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }


}
