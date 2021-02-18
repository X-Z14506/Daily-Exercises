package home.day05;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:11:55
 */
public class 存在重复元素 {
    public static void main(String[] args) {
        int[] a = {1,2,2,1};
        boolean b = containsDuplicate(a);
        System.out.println(b);
    }
    //法一：map
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            int e = nums[i];
            if (map.containsKey(e)) {
                return true;
            }
            map.put(e,1);
        }
        return false;
    }
    //法二：set，set自带去重功能
    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        if (set.size() < nums.length) {
            return true;
        }else {
            return false;
        }
    }
}
