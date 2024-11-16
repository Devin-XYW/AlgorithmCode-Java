package JavaInterviewBook.Linklist;

/**
 * 实现链表逆序 P20
 * 1.方法1：就地置逆法，使用双指针的方式，定义前驱和当结点，进行遍历逐步进行置逆
 *
 */
public class P20LinkListReverse {

    // 方法1：就地置逆法
    // 使用双指针遍历的方式进行就地置逆
    public static void Reverse1(LNode head) {
        if (head == null || head.next == null) {
            return;
        }

        LNode preNode = head;
        LNode curNode = head.next;
        LNode nextNode = curNode.next;
        curNode.next = null;
        preNode = curNode;
        curNode = nextNode;
        while (curNode.next != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        curNode.next = preNode;
        head.next = curNode;
    }

    //方法2: 使用递归法进行就地置逆‘
    //使用递归法来实现逆序
    //将不带头结点的单链表逆序
    public static LNode RecursiveReverse(LNode head){
        if(head == null || head.next == null){
            return head;
        }else {
            //反转后面的结点
            LNode newhead = RecursiveReverse(head.next);
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }
    //这里实现的是将带头结点的单链表的逆序
    public static void Reverse2(LNode head){
        if(head == null)
            return;
        LNode firstNode = head.next;
        head.next = RecursiveReverse(firstNode);
    }

    //方法3：头插法
    //从链表的第二个结点开始，在头部进行插入
    public static void Reverse3(LNode head){
        if(head == null || head.next == null){
             return;
        }

        LNode cur = head.next.next;
        LNode next = null;
        head.next.next = null;

        while(cur != null){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }

    }

    public static void main(String[] args) {

        int[] list = { 1, 2, 3, 4, 5, 6, 7 };
        LNode head = LNode.initLinkNode(list);

        System.out.print("置逆前:");
        LNode cur = head;
        for (cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }

        Reverse3(head);

        System.out.print("置逆后:");
        for (cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }

    }
}
