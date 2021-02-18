package home.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-17
 * Time:13:13
 */
public class 子集 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> subsets = subsets(a);
        System.out.println(subsets);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //空数组是任意数组的子集
        lists.add(new ArrayList<>());

        for (int num :nums) {
            List<List<Integer>> newSubs = new ArrayList<>();
            for (List<Integer> sub : lists) {
                List<Integer> newSub = new ArrayList<>(sub);
                newSub.add(num);
                newSubs.add(newSub);
            }
            lists.addAll(newSubs);
        }
        return lists;
    }
}
