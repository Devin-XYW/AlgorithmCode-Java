package JavaInterviewBook.hash;

import java.util.Stack;

/**
 * 排序栈元素
 * 将栈中元素进行排序，使用递归的方法
 * 首先对不包含栈顶元素的子栈进行排序
 * 如果栈顶元素大于子栈的栈顶元素，则交换这两个元素
 * 所以与翻转栈中元素思路相同，只需要在交换栈顶元素和子栈时加入一个判断即可
 */
public class P69SortStack {

    /**
     * 将栈底元素翻转到栈顶
     * 这里只是新增一个判断，如果当前元素大于栈顶元素则进行交换
     * @param s
     */
    public static void MoveBottomToTop(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        //首先取出当前栈顶元素
        int top1 = s.peek();
        s.pop();
        if(!s.empty()){
            MoveBottomToTop(s);//递归子栈
            int top2 = s.peek();
            if(top1 > top2){
                s.pop();
                s.push(top1);
                s.push(top2);
                return;
            }
        }
        s.push(top1);
    }

    public static void SortStack(Stack<Integer> s){
        if(s.empty()){
            return;
        }
        MoveBottomToTop(s);
        int top = s.peek();
        s.pop();
        SortStack(s);
        s.push(top);
    }


    public static void main(String[] args){

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();

        int[] inputList = {4,2,1,6,5,3};
        for(int i=0;i<inputList.length;i++){
            stack.push(inputList[i]);
            index.push(inputList[i]);
        }

        System.out.print("排序前栈中的元素出栈顺序为：");
        while(!index.empty()){
            System.out.print(index.peek()+" ");
            index.pop();
        }

        SortStack(stack);

        System.out.print("\n排序后栈中的元素出栈顺序为：");
        while(!stack.empty()){
            System.out.print(stack.peek()+" ");
            stack.pop();
        }

    }

}
