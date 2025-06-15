package InterviewDuck.doublelink;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author Devin
 * @Date 2025/6/15 17:08
 * @Description:
 **/
//寻找String中最大连续不重复子串的长度:https://www.mianshiya.com/bank/1824426908549402626/question/1824426909543452673#heading-5
//使用双指针(或者说滑动窗口)，使用一个hash序列来记录子串
public class N4MaxCFString {

    public static int maxCFString(String inputStr){
        //使用hash序列来记录子串，判断是否重复
        Set<Character> seen = new HashSet<>();

        int left = 0;
        int right = 0;
        int maxLength = 0;

        while(right < inputStr.length()){
            //如果字符不重复，则加入到seen序列集合
            if(!seen.contains(inputStr.charAt(right))){
                seen.add(inputStr.charAt(right));
                right++;
                maxLength = Math.max(maxLength,(right - left));
            }else {
                //如果字符重复，则移除左边的字符并收缩窗口大小
                seen.remove(inputStr.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        String inputStr = scanner.next();

        System.out.println("最长连续不重复子串大小为："+maxCFString(inputStr));

        scanner.close();
    }

}
