package InterviewDuck.linkList;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/22 15:29
 * @Description:
 **/
//排序一个链表：https://www.mianshiya.com/bank/1824426910944350209/question/1824426912810815489#heading-0
//针对链表的排序，推荐使用归并排序
//1.找到链表的中点
//2.拆分链表，分而治之排序好两半
//3.合并两个有序链表
public class N5SortLinkList {

    public static ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode mergeSort(ListNode left,ListNode right){

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(left != null && right != null){
            if(left.val <= right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = (left != null) ? left : right;
        return dummy.next;
    }

    public static ListNode sortLinkList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        //1.首先找到链表的中点
        ListNode mid = getMiddleNode(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        //2.分别对链表中点左右部分进行递归排序
        left = sortLinkList(left);
        right = sortLinkList(right);

        //3.再对左右两边排好序进行合并
        return mergeSort(left,right);

    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] list = new int[size];
        for(int i=0;i<size;i++){
            list[i] = scanner.nextInt();
        }

        ListNode head = ListNode.getLinkList(list);
        ListNode res = sortLinkList(head);
        ListNode.printLinkList(res);

    }
}
