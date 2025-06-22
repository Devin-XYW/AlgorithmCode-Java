package InterviewDuck.linkList;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/22 13:47
 * @Description:
 **/
//反转链表：https://www.mianshiya.com/bank/1824426910944350209/question/1824426911112122370#heading-0
public class N1ReverseLinkList {

    public static ListNode reverseList(ListNode head){
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] list = new int[size];
        for(int i=0;i<size;i++){
            list[i] = scanner.nextInt();
        }

        ListNode head = ListNode.getLinkList(list);
        ListNode reverseList = reverseList(head);
        ListNode.printLinkList(reverseList);
        scanner.close();
    }
}
