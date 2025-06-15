package JavaInterviewBook.tree;

/**
 * 找到以任意结点为起点和终点的最大路径和
 */
public class P106findMaxTreePath {


    //求出a、b、c中的最大值
    public static int Max(int a,int b,int c){
        int max = a>b ? a:b;
        max = max>c ? max:c;
        return max;
    }

    public static int max = 0;

    /**
     *使用后序遍历：
     * 1.求出以左子结点为起始，叶子结点为终点的最大路径和为maxLeft
     * 2.求出以右子结点为起始，叶子结点为终点的最大路径和为maxRight
     * 则包含root结点的最长路径值可能包含三种情况：
     * leftMax = root + maxLeft
     * rightMax = root + maxRight
     * allMax = root + maxLeft + maxRight
     * 则最大路径和为：Max(leftMax , rightMax , allMax)
     */
    public static int findMaxPath(Tree root){
        if(root == null) {
            return 0;
        }else {
            //使用后序遍历
            int sumLeft = findMaxPath(root.leftChild);
            int sumRight = findMaxPath(root.rightChild);

            int allMax = root.data + sumLeft + sumRight;
            int leftMax = root.data + sumLeft;
            int rightMax = root.data + sumRight;
            int tempMax = Max(allMax,leftMax,rightMax);
            if(tempMax > max){
                max = tempMax;
            }

            //返回以root为起始结点，叶子结点为结束结点的最大路径和
            int subMax = sumLeft > sumRight ? sumLeft:sumRight;
            return root.data + subMax;
        }
    }

}
