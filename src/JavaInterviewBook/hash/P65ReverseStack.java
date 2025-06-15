package JavaInterviewBook.hash;

import java.util.Stack;

/**
 * 翻转一个栈
 */
public class P65ReverseStack {


    /**
     * 使用递归的方法，将栈底元素移动到栈顶
     * 假设初始栈为：1,2,3,4,5
     * 首先将1进行出栈，将子栈2 3 4 5进行递归
     * 递归后的结果为1 和 5 2 3 4
     * 此时与子栈顶元素进行交换实现将栈底元素替换到栈顶
     */
    public static void moveBottomToTop(Stack<Integer> s){
        if(s.empty()){
            return;
        }

        int top1 = s.peek();//取当前栈顶元素
        s.pop();//将当前栈顶元素进行出栈，准备递归子栈
        if(!s.empty()){
            //递归处理不包含栈顶元素的子栈
            moveBottomToTop(s);//这里理解为对子栈进行递归
            int top2 = s.peek();//取子栈的栈顶元素
            //这里实现将当前元素和子栈栈顶元素进行交换
            s.pop();
            s.push(top1);
            s.push(top2);
        }else {
            s.push(top1);
        }
    }

    /**
     * 在上一步将栈底元素放到栈顶后，此时递归调用子栈
     * @param s
     */
    public static void ReverseStack(Stack<Integer> s){
        if(s.empty())
            return;
        //将当前栈中栈底的元素进行翻转到栈顶
        moveBottomToTop(s);
        int top = s.peek();
        s.pop();
        //递归处理子栈
        ReverseStack(s);
        s.push(top);
    }



    public static void main(String[] args){

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();

        int[] inputList = {1,2,3,4,5};
        for(int i=0;i<inputList.length;i++){
            stack.push(inputList[i]);
            index.push(inputList[i]);
        }

        System.out.print("翻转前栈中的元素出栈顺序为：");
        while(!index.empty()){
            System.out.print(index.peek()+" ");
            index.pop();
        }

        ReverseStack(stack);

        System.out.print("\n翻转后栈中的元素出栈顺序为：");
        while(!stack.empty()){
            System.out.print(stack.peek()+" ");
            stack.pop();
        }

    }




}
