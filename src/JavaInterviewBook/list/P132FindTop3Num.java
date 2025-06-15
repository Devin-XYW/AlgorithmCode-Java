package JavaInterviewBook.list;

/**
 * 找到一个数组中前3大的元素值
 */
public class P132FindTop3Num {
    
    public static int r1=0,r2=0,r3=0;
    public static void findTop3Num(int[] arr){
        for(int i=0;i<arr.length;i++){
            int num = arr[i];

            if(num > r3 && num != r2){
                r3 = num;
            }else if(num > r2 && num != r1){
                r3 = r2;
                r2 = num;
            }else if(num > r1){
                r3 = r2;
                r2 = r1;
                r1 = num;
            }
        }
    }

}
