package JavaInterviewBook.Linklist;

//判断两个单链表是否有交叉
//使用快慢指针方法：长度较长的链表快指针先走len1-len2步，然后同时遍历
public class P49LinkListIsIntersect {

    public static int getLength(LNode head){
        LNode p = head.next;
        int length=0;
        while(p != null){
            length++;
            p = p.next;
        }
        return length;
    }


    public static int isIntersect(LNode head1,LNode head2){
        if((head1 == null || head2 == null)
                || ((head1.next == null || head2.next == null) &&(head1.data != head2.data))){
            return 0;
        }

        int len1 = getLength(head1);
        int len2 = getLength(head2);
        LNode curLen1Node = head1.next;
        LNode curLen2Node = head2.next;
        if(len1 > len2){
            for(int i=0;i<(len1 - len2);i++){
                curLen1Node = curLen1Node.next;
            }
        }else {
            for(int i=0;i<(len2 - len1);i++){
                curLen2Node = curLen2Node.next;
            }
        }

        while(curLen1Node != null && curLen2Node != null){
            if(curLen1Node.data == curLen2Node.data){
                return curLen1Node.data;
            }
            curLen1Node = curLen1Node.next;
            curLen2Node = curLen2Node.next;
        }
        return 0;
    }


    public static void main(String[] args){

        int[] data1 = {7,1,2,3,4,5,6};
        int[] data2 = {4,2,1,5,6};
        LNode link1 = LNode.initLinkNode(data1);
        LNode link2 = LNode.initLinkNode(data2);

        System.out.print("Link1链表数据：");
        for(LNode cur=link1.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        System.out.print("Link2链表数据：");
        for(LNode cur=link2.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        int nodeData = isIntersect(link1,link2);
        System.out.print("两链表相交结果为："+nodeData);

    }

}
