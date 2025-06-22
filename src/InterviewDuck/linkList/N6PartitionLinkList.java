package InterviewDuck.linkList;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/22 15:44
 * @Description:
 **/
//分割链表：https://www.mianshiya.com/bank/1824426910944350209/question/1824426914450788353#heading-1
//
public class N6PartitionLinkList {

    public static ListNode partitionLink(ListNode head,int x){
        ListNode smallList = new ListNode(0);
        ListNode lagerList = new ListNode(0);
        ListNode siglist = new ListNode(0);
        ListNode small = smallList;
        ListNode sig = siglist;
        ListNode large = lagerList;
        ListNode cur = head;

        while(cur != null){
            if(cur.val < x){
                ListNode node = new ListNode(cur.val);
                node.next = null;
                small.next = node;
                small = small.next;
            }else if(cur.val > x){
                ListNode node = new ListNode(cur.val);
                node.next = null;
                large.next = node;
                large = large.next;
            }else {
                ListNode node = new ListNode(cur.val);
                node.next = null;
                sig.next = node;
                sig = sig.next;
            }
            cur = cur.next;
        }
        large.next = null;
        small.next = siglist.next;
        sig.next = lagerList.next;
        return smallList.next;
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] list = new int[size];
        for(int i=0;i<size;i++){
            list[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        ListNode head = ListNode.getLinkList(list);
        ListNode res = partitionLink(head,x);
        ListNode.printLinkList(res);

    }

}
