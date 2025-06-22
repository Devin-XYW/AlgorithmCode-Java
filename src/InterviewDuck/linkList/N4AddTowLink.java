package InterviewDuck.linkList;

import java.util.List;
import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/22 14:43
 * @Description:
 **/
public class N4AddTowLink {

    public static ListNode addTwoLink(ListNode head1,ListNode head2){
        ListNode res = new ListNode();
        res.next = null;
        int marks = 0;
        ListNode index1 = head1;
        ListNode index2 = head2;
        ListNode cur = res;

        while(index1 != null && index2 != null){
            int sum = index1.val + index2.val + marks;
            if(sum >= 10){
                sum = (sum - 10);
                marks = 1;
            }else {
                marks = 0;
            }
            ListNode node = new ListNode(sum);
            node.next = null;
            cur.next = node;
            cur = cur.next;
            index1 = index1.next;
            index2 = index2.next;
        }

        if (index1 != null){
            while (index1 != null){
                ListNode node = new ListNode(index1.val + marks);
                node.next = null;
                cur.next = node;
                cur = cur.next;
                marks = 0;
                index1 = index1.next;
            }
        }
        if (index2 != null){
            while (index2 != null){
                ListNode node = new ListNode(index2.val + marks);
                node.next = null;
                cur.next = node;
                cur = cur.next;
                marks = 0;
                index2 = index2.next;
            }
        }

        if(index1 == null && index2 == null){
            if(marks == 1){
                ListNode node = new ListNode(1);
                node.next = null;
                cur.next = node;
                cur = cur.next;
            }
            marks = 0;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int size1 = scanner.nextInt();
        int[] list1 = new int[size1];
        for(int i=0;i<size1;i++){
            list1[i] = scanner.nextInt();
        }

        int size2 = scanner.nextInt();
        int[] list2 = new int[size2];
        for(int i = 0; i< size2; i++){
            list2[i] = scanner.nextInt();
        }

        ListNode head1 = ListNode.getLinkList(list1);
        ListNode head2 = ListNode.getLinkList(list2);

        ListNode res = addTwoLink(head1,head2);

        ListNode.printLinkList(res.next);

        scanner.close();

    }

}
