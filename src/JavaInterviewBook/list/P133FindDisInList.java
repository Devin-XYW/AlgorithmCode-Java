package JavaInterviewBook.list;

/**
 * 求数组中的两个元素的最小距离,给定一个数组，数组中含有重复元素，给定两个数据num1和num2
 * 求这两个数字在数组中出现的位置和最小距离
 * 方法一：蛮力法，两层遍历，外层循环遍历到num1，内层循环对数组从头开始遍历
 * 方法二：动态规划方法
 * 1.当遇到num1时,记录下num1的值对应的数组下标的位置lastPos1,通过求lastPos1与上次遍历到num2下标的位置的值
 *   lastPos2的差可以求得最近一次遍历到的num1和num2的距离
 * 2.当遇到num2时,同样记录下它在数组中下标的位置lastPos2,然后通过求lastPos2与上次遍历到的num1下标的位置值
 *   lastPos1的差可以求得最近一次遍历到的num1与num2的距离
 * 例子: 数组{4 5 6 4 7 4 6 7 8 5 6 4},num1=4,num2=8
 *      1. 首先遍历到4,此时下标lastPos1=0,由于此时还没有遍历到num2,因此没必要计算num1与num2的值
 *      2. 再次遍历到4,此时更新lastPos1=3
 *      3. 再次遍历到4,此时更新lastPos1=5
 *      4. 再次遍历到4,此时更新lastPos1=7
 *      5. 遍历到8,更新lastPOs2=9; 此时由于前面已经遍历到过num1,因此可以求出当前num1与num2的最小距离为|lastPos1-lastPos2|
 *      6. 接着往下遍历,重复以上过程
 */
public class P133FindDisInList {

    /**
     * 动态规划的方法求解两数之间的最短距离
     * @return
     */
    public static int findDisInList(int[] arr,int num1,int num2){
        int lastPos1 = -1;//上次遍历到num1的位置
        int lastPos2 = -1;//上次遍历到num2的位置
        int mimDist = Integer.MAX_VALUE;//num1与num2之间的最小距离
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num1){
                lastPos1 = i;
                if(lastPos2 >= 0){
                    mimDist = Math.min(mimDist,lastPos1-lastPos2);
                }
            }

            if(arr[i] == num2){
                lastPos2 = i;
                if(lastPos1 >= 0){
                    mimDist = Math.min(mimDist,lastPos2-lastPos1);
                }
            }
        }
        return mimDist;
    }

    public static void main(String[] args){

        int[] arr = {4,5,6,4,7,4,6,4,7,8,5,6,4,3,10,8};
        System.out.print("原始数组为：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        int kNum = findDisInList(arr,4,8);
        System.out.print("数组中4和8的最小距离为："+kNum);

    }

}
