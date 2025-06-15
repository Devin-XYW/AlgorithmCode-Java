package JavaInterviewBook.Linklist;

//翻转链表中相邻两个结点
public class P39LinkNodeReverse2 {

    //翻转链表中相邻的两个结点
    public static void reverseNode(LNode head){
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        LNode preNode = head;
        LNode curNode = head.next;

        while(curNode != null && curNode.next != null){
            LNode nextNode = curNode.next;
            preNode.next = nextNode;
            curNode.next = nextNode.next;
            nextNode.next = curNode;

            preNode = curNode;
            curNode = curNode.next;
        }
    }


    public static void main(String[] args){

        int[] data = {1,2,3,4,5,6};
        LNode head = LNode.initLinkNode(data);

        System.out.print("原链表数据：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        reverseNode(head);

        System.out.print("\n翻转相邻结点后数据如下：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

    }

}
