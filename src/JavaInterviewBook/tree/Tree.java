package JavaInterviewBook.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    int data;//树中存储的数据
    Tree leftChild,rightChild;//树的左右树节点

    public Tree(int data){
        this.data = data;
    }

    /**
     * 利用层序遍历，找到对应数据的树中结点
     * 层序遍历：利用一个队列，
     * 1.首先取出当前结点
     * 2.判断当前结点是否有子结点，依次将左右结点加入队列中
     * 3.依次类推，直到队列中数据为空
     */
    public static Tree findTreeNode(Tree root,int nodeNum){
        Queue<Tree> queue = new LinkedList<>();//创建一个队列，使用链表实现
        queue.offer(root);//将当前结点添加到队列中
        while(!queue.isEmpty()){
            Tree cureNode = queue.poll();//取出当前队列中的队首结点
            if(cureNode.data == nodeNum){
                return cureNode; //若当前结点数据与目标值相同则返回
            }
            if(cureNode.leftChild != null){
                queue.offer(cureNode.leftChild);//判断当前结点是否存在左树结点，有则加入到队列中
            }
            if(cureNode.rightChild != null){
                queue.offer(cureNode.rightChild);//判断当前结点使用存在右树结点，有则加入到队列中
            }
        }
        return null;
    }


    //利用中序遍历，将数组构建成二叉树
    //中序遍历使用递归
    public static Tree buildTree(int[] arr,int low,int high){
        if(low <= high){
            //以数组中间位置数据为根结点，左右部分分别为左右子树
            int mid = (low+high+1) / 2;
            //树的根节点为数组的中间元素
            Tree root = new Tree(arr[mid]);
            //递归左半部分数组构造左子树
            root.leftChild = buildTree(arr,low,mid-1);
            //递归右半部分数组构造右子树
            root.rightChild = buildTree(arr,mid+1,high);
            return root;
        }else {
            return null;
        }
    }

    //利用中序遍历打印当前树的结点值
    public static void printTreeMidOrder(Tree root){
        if(root == null){
            return;
        }
        //首先遍历根结点的左子树
        if(root.leftChild != null){
            printTreeMidOrder(root.leftChild);
        }
        //遍历打印当前根结点的值
        System.out.print(root.data + " ");
        //遍历打印当前根结点的右子树
        if(root.rightChild != null){
            printTreeMidOrder(root.rightChild);
        }
    }

    //利用先序遍历打印树中的内容数据
    public static void printTreePreOrder(Tree root){
        if(root == null)
            return;
        //首先访问当前结点
        System.out.print(root.data + " ");
        //递归遍历当前结点的左子树
        if(root.leftChild != null){
            printTreePreOrder(root.leftChild);
        }
        //递归遍历当前结点的右子树
        if(root.rightChild != null){
            printTreePreOrder(root.rightChild);
        }
    }

    //后序遍历打印树中的内容数据
    public static void printTreePostOrder(Tree root){
        if(root == null)
            return;
        if(root.leftChild != null){
            printTreePostOrder(root.leftChild);
        }
        if(root.rightChild != null){
            printTreePostOrder(root.rightChild);
        }

        System.out.print(root.data + " ");
    }

    //层序遍历打印树中内容数据
    //层序遍历利用队列进行
    public static void printTreeLayerOrder(Tree root){
        if(root == null)
            return;
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Tree curNode = queue.poll();
            System.out.print(curNode.data + " ");
            if(curNode.leftChild != null){
                queue.offer(curNode.leftChild);
            }
            if(curNode.rightChild != null){
                queue.offer(curNode.rightChild);
            }
        }
    }

    //判断当前两颗树是否相等（具有相同的结构）
    //如果两颗树相等，那么根结点值相等，且他们的左右子树结构也相等
    //这里就考虑使用递归的方法
    public static Boolean isTreeREqual(Tree root1,Tree root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.data == root2.data){
            return isTreeREqual(root1.leftChild,root2.leftChild) &&
                    isTreeREqual(root1.rightChild,root2.rightChild);
        }else {
            return false;
        }
    }

}
