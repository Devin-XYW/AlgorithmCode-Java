package InterviewDuck.doublelink;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/22 13:02
 * @Description:
 **/
//盛最多水的容器：https://www.mianshiya.com/bank/1824426908549402626/question/1824426910420062209#heading-0
//使用双指针法，计算一个在数组开头开始遍历，一个在数组末尾开始遍历，不断调整两个指针来计算每次形成的容器容量
public class N7MaxWaterContainer {

    public static int maxWaterContainer(int[] list){
        int maxArea = 0;
        int left = 0;
        int right = list.length -1;

        while(left < right){

            int minHeight = Math.max(list[left],list[right]);
            int weight = (right - left);
            maxArea = Math.max(maxArea,minHeight * weight);

            if(list[left] < list[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxArea;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] list = new int[size];

        for(int i=0;i<size;i++){
            list[i] = scanner.nextInt();
        }

        System.out.println(maxWaterContainer(list));
        scanner.close();
    }

}
