package InterviewDuck.doublelink;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/15 17:57
 * @Description:
 **/
//判断某个字符串是否为另一个字符串的子序列：https://www.mianshiya.com/bank/1824426908549402626/question/1824426909853831170#heading-4
//使用双指针分别遍历两个字符串，进行字符对比
public class N5IsSubString {

    public static boolean isSubStr(String str1,String str2){
        int index1 = 0;
        int index2 = 0;

        while((index1 < str1.length()) && (index2 < str2.length())){
            if(str1.charAt(index1) == str2.charAt(index2)){
                index1++;
            }
            index2++;
        }

        return index1 == str1.length();
    }


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        System.out.println(isSubStr(str1,str2));

        scanner.close();

    }
}
