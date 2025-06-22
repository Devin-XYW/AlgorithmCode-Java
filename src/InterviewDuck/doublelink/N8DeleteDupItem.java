package InterviewDuck.doublelink;

import java.util.Scanner;

/**
 * @Author Devin
 * @Date 2025/6/22 13:25
 * @Description:
 **/
//删除一个排序数组中的重复项：https://www.mianshiya.com/bank/1824426908549402626/question/1824426910709469186#
//使用快慢指针求解，这里扩展一下，求去除重复元素后的数组元素和数组大小
public class N8DeleteDupItem {

    public static int deleteDupItem(int[] list){
        int slow = 0;
        int fast = 0;

        while((slow < (list.length-1)) && (fast < list.length)){

            if(list[fast] == list[slow]){
                fast++;
            }else{
                list[slow+1] = list[fast];
                slow++;
            }
        }

        return slow;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] list = new int[size];

        for(int i=0;i<size;i++){
            list[i] = scanner.nextInt();
        }

        int dupSize = deleteDupItem(list);

        for(int i=0;i<=dupSize && (dupSize <= (size-1));i++){
            System.out.print(list[i] + " ");
        }
        scanner.close();
    }

}
