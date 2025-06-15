package JavaInterviewBook.Linklist;

//合并两个有序链表，最终的链表也需要有序
//利用有序的特点
public class P44MergeLinkList {

    public static LNode mergeLinkList(LNode head1,LNode head2){
        LNode resultNode = new LNode();
        resultNode.next = null;
        LNode curResNode = resultNode;

        if(head1 == null){
            return head2;
        }

        if(head2 == null){
            return head1;
        }

        LNode curNode1 = head1.next;
        LNode curNode2 = head2.next;

        while(curNode1 != null && curNode2 != null){
            LNode node = new LNode();
            if(curNode1.data <= curNode2.data){
                node.data = curNode1.data;
                curNode1 = curNode1.next;
            }else{
                node.data = curNode2.data;
                curNode2 = curNode2.next;
            }
            curResNode.next = node;
            curResNode = node;
        }

        while(curNode1 != null){
            LNode node = new LNode();
            node.data = curNode1.data;
            curNode1 = curNode1.next;
        }

        while(curNode2 != null){
            LNode node = new LNode();
            node.data = curNode2.data;
            curNode2 = curNode2.next;
        }

        return resultNode;
    }


    public static void main(String[] args){

        int[] data1 = {1,3,5,7,9,10};
        LNode head1 = LNode.initLinkNode(data1);

        int[] data2 = {2,3,7,8};
        LNode head2 = LNode.initLinkNode(data2);

        System.out.print("原链表1数据：");
        for(LNode cur=head1.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        System.out.print("原链表2数据：");
        for(LNode cur=head2.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        LNode resLink = mergeLinkList(head1,head2);

        System.out.print("\n合并后链表如下：");
        for(LNode cur=resLink.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

    }

}
