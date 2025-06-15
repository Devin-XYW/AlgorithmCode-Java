package JavaInterviewBook.Linklist;

//判断当前链表是否有环，并且找到环的入口结点
//判断有环：使用快慢指针，慢指针一次走一步，快指针一次走两步，则最终相遇表示链表有环
public class P37LinkListLoop {

    //判断当前链表是否有环，有环则返回相遇结点；否则返回null
    public static LNode isLoop(LNode head){
        if(head == null || head.next == null){
            return null;
        }

        LNode slowNode = head.next;
        LNode fastNode = head.next;

        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if(fastNode == slowNode){
                return slowNode;
            }
        }

        return null;
    }

    public static void main(String[] args){

        int[] data = {1,2,3,4,5,6,3,8};
        LNode head = LNode.initLinkNode(data);

        System.out.print("原链表数据：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        LNode loopNode = isLoop(head);

        if(loopNode != null){
            System.out.print("当前链表存在环,相遇结点为："+loopNode.data+"\n");

            LNode beginNode = head.next;
            while(beginNode.data != loopNode.data){
                beginNode = beginNode.next;
                loopNode = loopNode.next;
            }
            System.out.print("环入口结点为："+beginNode.data+"\n");
        }else {
            System.out.print("当前链表不存在环");
        }

    }

}
