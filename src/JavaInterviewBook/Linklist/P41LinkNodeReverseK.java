package JavaInterviewBook.Linklist;

//把链表以K个结点为一组进行翻转
public class P41LinkNodeReverseK {

    //翻转当前
    public static LNode Reverse2Node(LNode begin){
        if(begin == null || begin.next == null)
            return begin;
        LNode pre = begin;
        LNode cur = begin.next;
        pre.next = null;

        while(cur != null){
            LNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void reverseK(LNode head,int k){
        if(head == null || head.next == null){
            return;
        }

        LNode preNode = head;
        LNode beginNode = head.next;

        while(beginNode != null || beginNode.next != null){

            LNode endNode = beginNode;
            for(int i=0;i<k-1;i++){
                if(endNode.next == null){
                    return;
                }
                endNode = endNode.next;
            }

            LNode next = endNode.next;
            endNode.next = null;
            preNode.next = Reverse2Node(beginNode);
            beginNode.next = next;
            preNode = beginNode;
            beginNode = next;
        }
    }

    public static void main(String[] args){

        int[] data = {1,2,3,4,5,6,7,8,9,10,11};
        LNode head = LNode.initLinkNode(data);

        System.out.print("原链表数据：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        reverseK(head,3);

        System.out.print("\n翻转相邻结点后数据如下：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

    }

}
