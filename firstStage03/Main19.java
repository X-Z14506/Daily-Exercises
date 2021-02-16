package firstStage03;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:10:46
 */

/*
算一下有多少同学被叫家长。
输入：
3
80 100 90
40 70 65
20 84 93

输出：
1

 */

public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0;i < n;i++) {
            String[] s = sc.nextLine().split(" ");
            double score = avgScore(s);
            if (score < 60 ) {
                count++;
            }
        }
        System.out.println(count);
    }
    static double avgScore(String[] s) {
        int[] ints = new int[s.length];
        double avg = 0;
        double sum = 0;
        for (int i = 0;i< s.length;i++) {
            ints[i] = Integer.parseInt(s[i]);
            sum+=ints[i];
        }
        avg = sum/3;
        return avg;
    }
}
