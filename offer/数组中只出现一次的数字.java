package offer;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-10
 * Time:11:08
 */
/*
    一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class 数组中只出现一次的数字 {
    public static void main(String[] args) {
        int[] a = {2,5,78,5,2,6};
        int[] b = new int[1];
        int[] c = new int[1];
        FindNumsAppearOnce(a,b,c);
    }
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < array.length;i++) {
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                int e = map.get(array[i]);
                map.put(array[i],++e);
            }
        }
        boolean flag = false;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer,Integer> m : entries) {
            if (m.getValue() == 1) {
                if (!flag) {
                    num1[0] = m.getKey();
                    flag = true;
                }else {
                    num2[0] = m.getKey();
                    break;
                }
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
