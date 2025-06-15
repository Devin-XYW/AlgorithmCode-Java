package JavaInterviewBook.list;


/**
 * 对数组进行循环移位：把一个含有n个元素的数组循环右移K位
 * 使用翻转法
 *  将数组分为两部分,首先将两个部分分别翻转,再将整个数组一起翻转,翻转的操作理解为转置的操作
 *  例: 将123456向右移两位
 *  1.首先将数组分为两部分: 1234 和 56
 *   2.翻转1234(转置): 1234--->4321
 *   3.翻转56(转置): 56--->65
 *   4.翻转432165: 432165--->561234
 */
public class P156RightShiftList {

    //对数组从start到end子数组进行翻转
    public static void reverse(int[] arr,int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rightShift(int[] arr,int k){
        int len = arr.length;
        k %= len; //将数组分为两部分
        reverse(arr,0,len-k-1);
        reverse(arr,len-k,len-1);
        reverse(arr,0,len-1);
    }


}
