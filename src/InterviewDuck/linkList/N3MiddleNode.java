package InterviewDuck.linkList;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/22 14:17
 * @Description:
 **/
//寻找链表的中间结点：https://www.mianshiya.com/bank/1824426910944350209/question/1824426911669964802#heading-0
//使用快慢指针的方法，快指针一次走两步，慢指针一次走一步，最终快指针变量完，慢指针的位置就中间结点
public class N3MiddleNode {

    public static ListNode getMiddleNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] list = new int[size];
        for(int i=0;i<size;i++){
            list[i] = scanner.nextInt();
        }

        ListNode head = ListNode.getLinkList(list);
        ListNode mid = getMiddleNode(head);
        System.out.print(mid.val);

    }

}
