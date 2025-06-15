package JavaInterviewBook.list;

import java.util.HashSet;

/**
 * 找到列表中唯一重复的元素
 * 数字1~1000放在含有1001个元素的数组中,其中只有唯一的一个元素值重复
 * 方法一：hash法
 * 方法二：数据映射法
 */
public class P112FindRangeNum {

    //方法一：使用hash法进行，创建一个hash数组进行映射判断重复元素
    public static int findRangNum_1(int[] ary){
        if(ary == null) return -1;

        int len = ary.length;
        HashSet<Integer> hashlist = new HashSet<>();
        for(int i=0;i<len;i++){
            //遍历ary的值到hash表中，判断hash表中是否有对应值
            if(hashlist.contains(ary[i])){
                return ary[i];
            }
            hashlist.add(ary[i]);
        }
        return -1;
    }

    //方法二：数据映射法
    //将数组中的值作为数据下标进行遍历，同时将对应下标的值改为相反数
    //如果当再次遍历到一个下标位置的值为负数时，则表示为重复数字
    public static int findRangeNum_2(int[] arr){
        if(arr == null) return -1;
        int len = arr.length;
        int index = 0;
        int i=0;
        while(true){
            //数组中的元素值只能小于len，否则会越界
            if(arr[i] >= len){
                return -1;
            }
            if(arr[index] < 0){
                break;
            }

            arr[index] *= -1;
            index = -1*arr[index];
        }
        return index;
    }

}
