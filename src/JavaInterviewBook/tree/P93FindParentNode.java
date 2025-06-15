package JavaInterviewBook.tree;

import java.util.Stack;

//找到两个树中任意两个结点的父结点
//总共有三种解决方案：
//路径对比法，及找到根结点分别到两个结点的路径栈，然后遍历栈中第一个相同的结点就是父结点
//1.首先判断node1是否在根结点的子树上，并且在判断过程中将根节点添加到该路径的路径栈中；
//2.对node2同理
//3.将得到分别得到的两个栈进行遍历，找到第一个相同的结点
//方法二:结点编号法
//1.将二叉树所有结点进行编号(利用层序遍历)
//2.分别求出node1和node2的编号n1和n2,然后没次找出n1和n2中较大的值初以2,直到n1==n2为止
//3.此时n1或者n2的值就是node1和node2的最近公共父节点
//方法三：后序遍历法
//1.递归查找到node1和node2的最近公共父节点可以转化为找到一个结点node；
//  查找到node1和node2的最近公共父节点可以转化为找到一个结点node
public class P93FindParentNode {

    /**
     * 获取根节点root到node当前结点的路径，并添加到栈s中
     */
    public static Boolean getPathFromRoot(Tree root, Tree node, Stack<Tree> s){
        if(root == null){
            return false;
        }
        //如果根节点跟当前结点相同则加入到栈中
        if(node == root){
            s.push(root);
            return true;
        }
        //如果node结点在root结点的左子树或者右子树上
        //那么root就是node的祖先结点，将其加入到栈中
        if(getPathFromRoot(root.leftChild,node,s)
                || getPathFromRoot(root.rightChild,node,s)){
            s.push(root);
            return true;
        }
        return false;
    }

    //查找树中任意两个结点node1和node2的共同父结点
    public static Tree findParentNode(Tree root,Tree node1,Tree node2){
        Stack<Tree> stack1 = new Stack<>();//保存根结点到node1的路径栈
        Stack<Tree> stack2 = new Stack<>();//保存根结点到node2的路径栈

        //获取从root到node1的路径栈
        getPathFromRoot(root,node1,stack1);
        //获取从root到node2的路径栈
        getPathFromRoot(root,node2,stack2);

        Tree parentNode = null;
        //遍历两个路径栈，找到第一个相同的结点就是共同父结点
        while(stack1.peek() == stack2.peek()){
            parentNode = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return parentNode;
    }

    /**
     * 计算任意两个结点中的距离
     * 在得到父结点的基础上，可以分别计算以下几个值：
     * 1.node1结点到根结点root的距离D1
     * 2.node2结点到根结点root的距离D2
     * 3.parentNode结点到根结点root的距离D
     * 则node1和node2的距离为：D1 + D2 - 2*D
     */
    public static int finTwoNodeDist(Tree root,Tree node1,Tree node2){
        Stack<Tree> stack1 = new Stack<Tree>();//存放root到node1的结点路径
        Stack<Tree> stack2 = new Stack<Tree>();//存放root到node2的结点路径
        Stack<Tree> stack3 = new Stack<Tree>();//存放root到parent的结点路径

        //获取root到达结点node1的路径
        getPathFromRoot(root,node1,stack1);
        //获取root到达结点node2的路径
        getPathFromRoot(root,node2,stack2);

        //获得root到达node1与node2的路径长度
        int DistRootToNode1 = stack1.size();
        int DistRootToNode2 = stack2.size();

        //找到父节点parentNode
        Tree parentNode = null;
        //获取node1与node2最近的父节点,遍历两个栈
        while (stack1.peek() == stack2.peek()){
            parentNode = stack1.peek();
            stack1.pop();
            stack2.pop();
            if(stack1.empty() || stack2.empty())
                break;
        }
        //获取root到达parent的路径
        getPathFromRoot(root,parentNode,stack3);

        //获得root到达parent的路径长度
        int DistRootToParent = stack3.size();

        //利用公式Dist(node1,node2) = Dist(root,node1) + Dist(root,node2) - 2*Dist(root,parentNode)
        return (DistRootToNode1 + DistRootToNode2 - 2*DistRootToParent);

    }



    public static void main(String[] args){
        int[] list = {-1,3,6,-7,9};
        Tree root = Tree.buildTree(list,0,list.length-1);
        System.out.print("树的中序遍历结果为：");
        Tree.printTreeMidOrder(root);



    }

}
