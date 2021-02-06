package second.day28;

import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-05
 * Time:19:44
 */
/*
数组中出现次数超过一半的数字
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int ret = MoreThanHalfNum_Solution(arr);
        System.out.println(ret);
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < array.length;i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i],1);
            }else {
               int val = map.get(array[i]);
               map.put(array[i],++val);
            }
        }
        Set<Map.Entry<Integer, Integer>> maps = map.entrySet();
        for (Map.Entry<Integer,Integer> m : maps) {
            if (m.getValue() > array.length/2) {
                return m.getKey();
            }
        }
        return 0;
    }
}
