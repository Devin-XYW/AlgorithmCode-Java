package InterviewDuck.doublelink;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/16 23:12
 * @Description:
 **/
//合并两个有序数组：https://www.mianshiya.com/bank/1824426908549402626/question/1824426910134849537#heading-0
//注意此题中，list1有足够的位置存放两个数组的所有元素
public class N6MergeList {

    public static void mergeTwoList(int[] list1,int[] list2){
        if(list1.length < list2.length){
            return;
        }
        //由于list1有足够的位置存放两个数组的元素，所以这考虑从后向前进行遍历
        int index1 = (list1.length - list2.length - 1);
        int index2 = (list2.length - 1);
        int last = (list1.length -1);

        while(index1 >= 0 && index2 >= 0){
            if(list1[index1] < list2[index2]){
                list1[last] = list2[index2];
                last--;
                index2--;
            }else {
                list1[last] = list1[index1];
                last--;
                index1--;
            }
        }

        while(index2 >= 0){
            list1[last] = list2[index2];
            last--;
            index2--;
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int size1 = scanner.nextInt();

        int[] list1 = new int[size1];
        for(int i=0;i<size1;i++){
            list1[i] = scanner.nextInt();
        }

        int size2 = scanner.nextInt();

        int[] list2 = new int[size2];
        for(int i=0;i<size2;i++){
            list2[i] = scanner.nextInt();
        }

        mergeTwoList(list1,list2);

        for(int item:list1){
            System.out.print(item + " ");
        }

        scanner.close();
    }

}
