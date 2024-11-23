package JavaInterviewBook.Linklist;

//找到链表中倒数第K个元素值
//使用快慢指针的方式进行遍历，快指针先走k个节点
public class P33LinkListKNum {

    //使用快慢指针返回倒数第k个元素
    public static int getKNum(LNode head,int k){

        if(head == null){
            return 0;
        }
        if(head.next == null){
            return head.data;
        }

        LNode kNode = head;
        LNode fastNode = head;
        int i = 0;
        for(;i<k && fastNode != null;i++){
            fastNode = fastNode.next;
        }
        if(i < k){
            return head.data;
        }
        while(fastNode != null){
            fastNode = fastNode.next;
            kNode = kNode.next;
        }

        return kNode.data;
    }

    public static void main(String[] args){

        int[] data = {1,2,3,4,5,6,7,8};
        LNode head = LNode.initLinkNode(data);

        System.out.print("原链表数据：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        int kNum = getKNum(head,4);

        System.out.print("倒数第4个数据为：");
        System.out.print(kNum);

    }

}
