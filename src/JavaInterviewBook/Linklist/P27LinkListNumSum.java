package JavaInterviewBook.Linklist;

import java.util.ArrayList;

//P27: 计算两个链表的数字组成的数据之和
//将两个链表所表示的数相加
// 3->4->5->6->7->9 表示数：976543
// 9->8->2->6->5 表示数：56289
// 两者相加： 2->3->8->2->3->0->1 表示数：1032832
public class P27LinkListNumSum {


    public static ArrayList<Integer> LinkNumSum(LNode head1, LNode head2){

        ArrayList<Integer> result = new ArrayList<>();

        LNode curNode1 = head1.next;
        LNode curNode2 = head2.next;
        int addNum = 0;

        while(curNode1 != null && curNode2 != null){
            int sum = curNode1.data + curNode2.data;
            if(addNum > 0){
                sum = sum+1;
            }
            if(sum >= 10){
                addNum = 1;
                sum = (sum - 10);
            }else {
                addNum = 0;
            }
            result.add(sum);
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }

        while(curNode1 != null){
            int sum = curNode1.data;
            if(addNum == 1){
                sum = sum+1;
            }
            addNum = 0;
            result.add(sum);
            curNode1 = curNode1.next;
        }

        while(curNode2 != null){
            int sum = curNode2.data;
            if(addNum == 1){
                sum = sum+1;
            }
            addNum = 0;
            result.add(sum);
            curNode2 = curNode2.next;
        }

        return result;
    }

    public static void main(String[] arg){

        int[] data1 = {3,4,5,6,7,9};
        int[] data2 = {9,8,2,6,5};
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

        ArrayList<Integer> resList = LinkNumSum(link1,link2);
        System.out.print("链表相加结果为：");
        for(int i=resList.size()-1;i>=0;i--){
            System.out.print(resList.get(i));
        }


    }

}
