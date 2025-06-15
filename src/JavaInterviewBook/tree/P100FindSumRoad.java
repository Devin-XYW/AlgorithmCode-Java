package JavaInterviewBook.tree;

import java.util.Vector;

/**
 * 输入一个整数，找到所有满足路径中结点值之和等于这个整数的路径
 */
public class P100FindSumRoad {


    /**
     * 找到并打印出所有满足从根结点开始的路径中所有结点值等于num值的路径：
     * 1.对二叉树进行先序遍历，把遍历的路径记录下来，添加到vector列表中
     * 2.当遍历到叶子结点时，判断当前路径上的所有结点之和是否等于给定的整数值
     * 3.如果相等则输出路径信息
     */
    public static void findSumRoad(Tree root, int num, int sum, Vector<Integer> pathV){
        //先序遍历
        //首先记录当前根结点,并添加到列表中
        sum += root.data;
        pathV.add(root.data);
        //判断当前结点是否为叶子结点且遍历路径上所有结点的和等于num
        if(root.leftChild == null && root.rightChild == null && sum==num){
            //打印当前列表中的路径结点
            for(int i=0;i<pathV.size();i++){
                System.out.print(pathV.get(i) + " ");
            }
            System.out.println();
        }

        //遍历左子树
        if(root.leftChild != null){
            findSumRoad(root.leftChild,num,sum,pathV);
        }

        //遍历右子树
        if(root.rightChild != null){
            findSumRoad(root.rightChild,num,sum,pathV);
        }

        //递归到上一层去除当前遍历的结点
        pathV.remove(pathV.size() - 1);
    }


    public static void main(String[] args){
        int[] list = {-1,3,6,-7,9};
        Tree root = Tree.buildTree(list,0,list.length-1);
        System.out.print("树的先序遍历结果为：");
        Tree.printTreePreOrder(root);

        Vector<Integer> pathV = new Vector<>();
        System.out.println("\n路径为: ");
        findSumRoad(root,8,0,pathV);

    }

}
