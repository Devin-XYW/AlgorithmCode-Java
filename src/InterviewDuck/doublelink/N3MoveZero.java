package InterviewDuck.doublelink;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/15 16:23
 * @Description:
 **/
//移动数组中的零：https://www.mianshiya.com/bank/1824426908549402626/question/1824426909270822914
//给定一个整数数组nums，将数组中的所有零移动到数组的末尾，同时保持非零元素的相对顺序不变，不使用额外数组
public class N3MoveZero {

    public static void moveZero(int[] inputList){
        if(inputList.length == 1){
            return ;
        }
        int leftIndex = 0;
        for(int i=0;i<inputList.length;i++){
            if(inputList[i] != 0){
                inputList[leftIndex] = inputList[i];
                leftIndex++;
            }
        }

        while(leftIndex < inputList.length){
            inputList[leftIndex] = 0;
            leftIndex++;
        }
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] inputList = new int[size];

        for(int i=0;i<size;i++){
            inputList[i] = scanner.nextInt();
        }

        moveZero(inputList);

        for(int num:inputList){
            System.out.println(num + " ");

        }
        scanner.close();

    }

}
