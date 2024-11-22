package JavaInterviewBook.Linklist;

//找到当前链表中的中间结点
//方案：使用快慢指针，慢指针一次1步，快指针一次2步
public class P30LinkListMiddle {

    public static LNode findMiddleNode(LNode head){

        if(head == null || head.next == null){
            return head;
        }

        LNode slowNode = head;
        LNode fastNode = head;
        while (fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public static void main(String[] args){

        int[] data = {1,2,3,4,5,6,7};
        LNode head = LNode.initLinkNode(data);

        System.out.print("原链表数据：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        LNode middleNode = findMiddleNode(head);

        System.out.print("中间结点数据为：");
        System.out.print(middleNode.data + " ");

    }
}
