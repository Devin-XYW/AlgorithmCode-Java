package InterviewDuck.doublelink;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/15 16:16
 * @Description:
 **/
//判断字符串是否为回文串：https://www.mianshiya.com/bank/1824426908549402626/question/1824426908973027330#heading-0
public class N2HuiWenString {

    public static boolean isHuiWenString(String input){
        int left = 0;
        int right = input.length() -1;

        while(left < right){
            if(input.charAt(left) != input.charAt(right)){
                return false;
            }
            left++;
            right--;
        }


        return true;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();

        System.out.println("是否为回文串:"+isHuiWenString(inputStr));

        scanner.close();

    }


}
