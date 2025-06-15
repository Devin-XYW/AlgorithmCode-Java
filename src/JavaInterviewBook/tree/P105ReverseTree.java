package JavaInterviewBook.tree;

/**
 * 镜像翻转一个二叉树
 */
public class P105ReverseTree {

    /**
     * 镜像翻转一个二叉树：
     * 使用先序遍历递归将所有结点的左右子树进行对换即可实现
     */
    public static void reverseTree(Tree root){
        if(root == null){
            return;
        }
        //交换左右子树
        Tree tmp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = tmp;

        //递归遍历左右子树
        reverseTree(root.leftChild);
        reverseTree(root.rightChild);

    }


    public static void main(String[] args){

    }

}
