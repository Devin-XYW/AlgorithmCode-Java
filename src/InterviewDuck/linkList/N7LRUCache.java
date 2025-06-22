package InterviewDuck.linkList;

import java.util.HashMap;

/**
 * @Author Devin
 * @Date 2025/6/22 16:07
 * @Description:
 **/
//实现一个LRU缓存：https://www.mianshiya.com/bank/1824426910944350209/question/1824426914736001026#heading-0
//实现一个LRU缓存的关键在于如何高效地实现get和put操作，可以使用两个数据结构来实现这个目的：
//1.hash表：用于通过键快速访问缓存中的值
//2.双向链表：用于维护缓存中键值对的顺序，以便在缓存容量达到上限时能够快手移除最久未使用的键值对
//在实现中，将hash表的值设置为双向链表中的节点，这样就可以在O1时间复杂度内完成get和put操作
//双向链表维护访问顺序，hash表保证快速访问，解决LRU性能要求；
public class N7LRUCache {

    //哈希cache：实现复杂的键值查找
    private HashMap<Integer,DListNode> cache = new HashMap<>();
    private int size;//当前缓存大小
    private int capacity;//LRU缓存队列最大容量

    //虚拟头尾结点：简化链表边界操作
    private DListNode head,tail;

    //双向链表: 存储键值对，及前后指针
    private class DListNode{
        int key;
        int value;
        DListNode prev;
        DListNode next;
        public DListNode(){}
        public DListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    public N7LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.prev = head;
    }

    //将结点添加到头部
    private void addToHead(DListNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //移除掉某个结点
    private void removeNode(DListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //将节点移动到链表头部表示最近使用
    private void moveToHead(DListNode node){
        removeNode(node);
        addToHead(node);
    }

    //移除最久未使用的尾部结点
    private DListNode removeTail(){
        DListNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public int get(int key){
        DListNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DListNode node = cache.get(key);
        if(node == null){
            DListNode newNode = new DListNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size > capacity){
                DListNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }


}
