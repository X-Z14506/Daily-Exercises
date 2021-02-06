package second.day23;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-28
 * Time:20:35
 */

/*
连续子数组和的最大值

思路：
    用total记录累计值，maxSum记录和最大。
    基于思想：对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值对整体和是有贡献的。
            如果前几项累计值负数，则认为有害于总和，total记录当前值。
    此时 若和大于maxSum 则用maxSum记录下来

 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] strings = sc.nextLine().split(" ");
            int[] ints = new int[n];
            for (int i = 0;i < n;i++) {
                ints[i] = Integer.parseInt(strings[i]);
            }
            int maxSum = maxChildArr(ints);
            System.out.println(maxSum);
        }
    }

    private static int maxChildArr(int[] ints) {
        if (ints.length == 1) {
            return ints[0];
        }else {
            int total = ints[0];
            int maxSum = ints[0];
            for (int i = 1;i < ints.length;i++) {
                if (total >= 0) {
                    total += ints[i];
                }else {
                    total = ints[i];
                }
                if (total > maxSum) {
                    maxSum = total;
                }
            }
            return maxSum;
        }
    }
}
