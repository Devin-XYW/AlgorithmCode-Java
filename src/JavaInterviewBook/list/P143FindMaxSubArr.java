package JavaInterviewBook.list;

/**
 * 求一个数组中连续的最大和，并记录最大和子数组的起始下标位置
 * 通过对公式End[i] = max(End[i-1]+arr[i],arr[i])的分析可以看出
 * 当End[i-1]<0时，End[i]=array[i]
 * 其中End[i]表示包含array[i]的子数组和，如果其中一个值使得End[i-1] < 0,
 * 那么就从arr[i]重新开始
 */
public class P143FindMaxSubArr {

    private static int begin = 0;
    private static int end = 0;
    public static int maxSubArray(int[] arr){
        int n = arr.length;
        int maxSum = Integer.MAX_VALUE;//子数组最大值
        int nSum = 0;//包含子数组最后一位的最大值
        int nStart = 0;
        for(int i=0;i<n;i++){
            if(nSum < 0){
                //当前元素和mSum值小于0时，此时更新开始下标
                nSum = arr[i];
                nStart = i;
            }else {
                //当前mSum值大于0，则继续加当前遍历到的数组值
                nSum += arr[i];
            }
            if(nSum > maxSum){
                maxSum = nSum;
                begin = nStart;
                end = i;
            }
        }
        return maxSum;
    }


}
