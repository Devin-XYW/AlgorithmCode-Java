package InterviewDuck.doublelink;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/15 15:49
 * @Description:
 **/
//双指针题1:https://www.mianshiya.com/bank/1824426908549402626/question/1824426908712980481#heading-0
public class N1TwoNumSum {

    public static int[] findTwoSum(int[] list,int target){
        int left = 0;
        int right = list.length - 1;

        while(left < right){
            int sum = list[left] + list[right];
            if(sum == target){
                return new int[]{left,right};
            }else if(sum < target){
                left++;
            }else {
                right--;
            }
        }

        return null;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];

        for(int i=0;i<n;i++){
            a[i] = scanner.nextInt();
        }

        int t = scanner.nextInt();

        int[] result = findTwoSum(a,t);

        if(result != null){
            System.out.println("结果为:" + result[0] + "," + result[1]);
        }else {
            System.out.println("No solution found");
        }
        scanner.close();
    }

}
