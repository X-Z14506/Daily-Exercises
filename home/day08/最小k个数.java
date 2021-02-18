package home.day08;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:17:03
 */
public class 最小k个数 {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(smallestK(a, 4)));
    }
    public static int[] smallestK(int[] arr, int k) {
        if(arr == null || k<=0) {
            return new int[0];
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++) {
            q.offer(arr[i]);
        }
        System.out.println(q);
        int[] ret = new int[k];
        for(int i = 0;i < k;i++) {
            ret[i] = q.poll();
        }
        return ret;
    }
}
