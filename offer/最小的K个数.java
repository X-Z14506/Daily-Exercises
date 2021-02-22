package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-19
 * Time:16:01
 */
public class 最小的K个数 {
    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        int k = 4;
        ArrayList<Integer> list = GetLeastNumbers_Solution(a, k);
        System.out.println(list);
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0;i < input.length;i++) {
            queue.add(input[i]);
        }
        for (int i = 0;i < k;i++) {
            list.add(queue.poll());
            //System.out.println(queue);
        }
        return list;
    }
}
