package JavaInterviewBook.Linklist;

//P24:分别删除有序和无序链表中重复的结点
//无序：使用双层循环进行嵌套循环查询重复项进行删除
//有序：利用有序的特点，使用双指针进行遍历删除
public class P24DeleteDupLinkNode {

    //无序链表：删除无序链表的重复结点
    public static void DeleteDupNode1(LNode head){
        if(head == null || head.next == null){
            return;
        }

        LNode outNode = head.next;
        LNode inNode = outNode.next;
        LNode preNode = outNode;
        //外层循环：outNode结点遍历
        while(outNode.next != null){
            //内层循环：inNode结点遍历，判断与outNode的值
            while(inNode != null){
                if(inNode.data == outNode.data){
                    preNode.next = inNode.next;
                    inNode.next = null;
                    inNode = preNode.next;
                }else {
                    preNode = inNode;
                    inNode = inNode.next;
                }
            }
            //增加外层循环outNode结点的位置，并复位内层结点
            outNode = outNode.next;
            inNode = outNode.next;
            preNode = outNode;
        }

    }

    //有序链表：通过双指针方式实现删除重复项
    public static void DeleteDupNode2(LNode head){
        if(head == null || head.next == null){
            return;
        }

        LNode preNode = head.next;
        LNode curNode = preNode.next;
        //由于有序的特点，使用双指针进行单层遍历
        while(curNode != null){
            if(curNode.data == preNode.data){
                preNode.next = curNode.next;
                curNode.next = null;
                curNode = preNode.next;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }


    }

    public static void main(String[] args){

//        int[] data = {1,3,2,2,4,1,5,3};
        int[] data = {1,2,2,2,3,3,4,5,5,6};
        LNode head = LNode.initLinkNode(data);

        System.out.print("原链表数据：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        DeleteDupNode2(head);

        System.out.print("\n删除重复结点后数据如下：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

    }
}
