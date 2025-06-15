package JavaInterviewBook.list;

/**
 * 找到数组中第K小的数：
 * 1.使用快速排序对数组进行排序，再取出第k个元素值
 * 2.使用类快排的方式，利用快排每次递归遍历都确认一个数的位置的特点
 */
public class P130FindSmallKNum {

    //=================使用快排对数组进行排序====================
    //快排单次遍历的逻辑
    public static int potion(int[] arr,int low,int high){
        int curNum = arr[low];//以low位置的值为基准
        while(low<high){
            //低指针和高指针同时向对方进行遍历
            //高指针遍历，找到比基准curNum值小的元素值
            while (low<high && arr[high] >= curNum){
                high--;
            }
            //将当前高指针元素值替换到低指针的位置
            arr[low] = arr[high];
            //低指针遍历，找到比基准curNum值大的元素值
            while(low<high && arr[low] <= curNum){
                low++;
            }
            //将当前低指针元素替换到高指针的位置
            arr[high] = arr[low];
        }
        //遍历结束，则low的位置就是基准值的位置
        arr[low] = curNum;
        return low;
    }

    //快速排序递归方法
    public static void quickSort(int[] arr,int low,int high){
        int pos = potion(arr,low,high);

        if((low < pos) && (pos < high)){
            quickSort(arr,low,pos-1);
            quickSort(arr,pos+1,high);
        }
    }

    //==================使用类快排的方法==============
    public static int findSmallK(int[] arr,int low,int high,int k){

        //使用类快排方法
        int i = low;
        int j = high;
        int splitNum = arr[i];
        while (i<j){
            //高指针开始遍历，找到高位置比基准值小的元素
            while (i<j && (arr[j] >= splitNum)){
                j--;
            }
            if(i<j){
                arr[i++] = arr[j];//将高位和低位值进行交换
            }
            //低指针开始遍历低指针，找到低位置比基准值大的元素
            while(i<j && (arr[i] <= splitNum)){
                i++;
            }
            if(i<j){
                arr[j--] = arr[i];//将高位和低位值进行交换
            }
        }
        arr[i] = splitNum;
        //当前基准值在子数组arr[low]到arr[high]中的下标偏移量
        int subArrayIndex = i-low;
        //如果当前基准值在子数组中的位置恰好为k-1，则该数就是倒数第k小的元素值
        if(subArrayIndex == k-1){
            return arr[i];
        }else if(subArrayIndex > k-1){
            //判断当前基准值所在的位置大于k-1，则只需要再low到i-1中找到第k小的元素
            return findSmallK(arr,low,i-1,k);
        }else {
            //判断当前基准值所在的位置小于k-1，则在i+1到high范围中找到第k-splitNum-1小的元素
            return findSmallK(arr,i+1,high,k-subArrayIndex-1);
        }
    }


    public static void main(String[] args){

        int[] arr = {2,8,1,6,10,3,9};
        System.out.print("原始数组为：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        int k = 3;
        int kNum = findSmallK(arr,0,arr.length-1,k);
//        quickSort(arr,0,arr.length-1);
//        System.out.print("快排后的数组为：");
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i] + " ");
//        }
//        int kNum = arr[k-1];
        System.out.print("倒数第k小的元素为："+kNum);

    }

}
