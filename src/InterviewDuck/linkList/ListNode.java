package InterviewDuck.linkList;

/**
 * @Author Devin
 * @Date 2025/6/22 13:47
 * @Description:
 **/
public class ListNode {

    int val;
    ListNode next;

    ListNode(){

    }

    ListNode(int x){
        val = x;
    }

    public static ListNode getLinkList(int[] list){
        ListNode head = new ListNode(list[0]);
        ListNode last = head;
        ListNode cur = null;
        last.next = cur;
        for(int i=1;i<list.length;i++){
            cur = new ListNode(list[i]);
            last.next = cur;
            last = cur;
            cur.next = null;
        }
        return head;
    }

    public static void printLinkList(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
