package JavaInterviewBook.list;

public class P151FindMidNum {

    private static int position(int arr[],int low,int high){

        int sigNum = arr[low];
        int pos;
        while(low < high){

            while((low < high) && (arr[high] > sigNum)){
                high--;
            }
            arr[low] = arr[high];
            while ((low < high) && (arr[low] < sigNum)){
                low++;
            }
            arr[high] = arr[low];
        }
        pos = low;
        arr[low] = sigNum;
        return pos;
    }

    public static int getMid(int arr[]){
        int low = 0;
        int n = arr.length;
        int high = n-1;
        int mid = (low + high) / 2;
        int pos = 0;
        while(true){
            pos = position(arr,low,high);

            if(pos == mid){
               break;
            }else if(pos < mid) {
                low = pos+1;
            }else{
                high = pos-1;
            }
        }
        return (n%2) != 0 ? arr[mid]:(arr[mid]+arr[mid+1])/2;
    }

    public static void main(String[] args){

        int[] arr = {1,4,2,3,5,7,6,8};
        System.out.print("原始数组为：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }

        int kNum = getMid(arr);
        System.out.print("\n数组中中位数为："+kNum);
    }

}
