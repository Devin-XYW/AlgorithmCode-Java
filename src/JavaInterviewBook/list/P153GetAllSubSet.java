package JavaInterviewBook.list;

import java.util.ArrayList;

/**
 * 求集合的所有子集
 * 采用迭代法: 每一次迭代,都是上一次迭代的结果
 *             +上次迭代结果中每个元素都加上当前迭代的元素
 *             +当前迭代的元素
 *例如: 原始集合为: {a,b,c}
 *     第一次迭代: {a}
 *     第二次迭代: {a,ab,b}
 *     第三次迭代: {a,ab,b,ac,abc,bc,c}
 * 时间复杂度: O(2^n)
 */
public class P153GetAllSubSet {

    //迭代法求集合中所有的子集
    public static ArrayList<String> getAllSubSet(String str){
        ArrayList<String> arr = new ArrayList<>();
        arr.add(str.substring(0,1));//将第一个字母加入到数组中
        for(int i=1;i<str.length();i++){
            int len = arr.size();
            for(int j=0;j<len;j++){
                //将当前集合中的每一个字符串与当前字符进行拼接
                arr.add(arr.get(j)+str.charAt(i));
            }
            arr.add(str.substring(i,i+1));//将当前字符加入到子集中

        }
        return arr;
    }

}
