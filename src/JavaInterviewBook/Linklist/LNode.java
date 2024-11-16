package JavaInterviewBook.Linklist;

public class LNode {

    int data; // 链表数据值
    LNode next;// 单链表下一个结点

    // 初始化链表：根据传入的list，创建带头结点的链表
    public static LNode initLinkNode(int[] list) {
        // 链表头结点
        LNode head = new LNode();
        head.next = null;
        LNode temp = null;
        LNode cur = head;

        // 根据传入的list创建单链表
        for (int i = 0; i < list.length; i++) {
            temp = new LNode();
            temp.data = list[i];
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }
        return head;
    }
}
