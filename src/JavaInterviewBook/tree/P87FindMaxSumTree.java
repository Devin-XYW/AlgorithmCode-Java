package JavaInterviewBook.tree;

/**
 * 求一颗二叉树中的最大子树和，并找到子树的根结点
 */
public class P87FindMaxSumTree {

    //找到一颗二叉树中的最大子树和，可以使用后序遍历的特点，递归进行以下步骤：
    //1.求当前结点的左子树最大子树和
    //2.求当前结点的右子树最大子树和
    //3.将当前根结点的数据值加上左右子数据的最大数据和，记录当前值
    //4.依次类推，递归遍历记录最大值和对应的根结点
    public static int maxSum = 0;
    public static Tree maxTreeNode = null;
    public static int findMaxSumTree(Tree root){
        if(root == null){
            return 0;
        }
        //首先求出左子树最大子树和
        int lmax = findMaxSumTree(root.leftChild);
        //其次求出右子树最大子树和
        int rmax = findMaxSumTree(root.rightChild);
        //加上当前根结点的值
        int sum = lmax + rmax + root.data;
        //以root为根的子树和大于前面所求的最大值
        if(sum > maxSum){
            maxSum = sum;
            maxTreeNode = root;
        }
        return sum;//返回以root为根结点的子树所有结点的和
    }

    public static void main(String[] args){

        int[] list = {-1,3,6,-7,9};
        Tree root = Tree.buildTree(list,0,list.length-1);
        System.out.print("树的中序遍历结果为：");
        Tree.printTreeMidOrder(root);

        findMaxSumTree(root);

        System.out.print("树的最大子树和结果为："+maxSum+",对应的子树根结点为："+maxTreeNode.data);


    }


}
