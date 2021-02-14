package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:16:55
 */

/*
    题目描述
        BoBo买了一箱酸奶，里面有n盒未打开的酸奶，KiKi喜欢喝酸奶，第一时间发现了酸奶。KiKi每h分钟能喝光一盒酸奶，并
        且KiKi在喝光一盒酸奶之前不会喝另一个，那么经过m分钟后还有多少盒未打开的酸奶？

        输入描述:
        多组输入，每组输入仅一行，包括n，h和m（均为整数）。输入数据保证m <= n * h。
        输出描述:
        针对每组输入，输出也仅一行，剩下的未打开的酸奶盒数。

        输入：8 5 16
        输出：4
 */
    public class Main26 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] s = scanner.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int h = Integer.parseInt(s[1]);
            int m = Integer.parseInt(s[2]);
            //如果能m取余h等于0，说明正好喝了m/h杯酸奶
            //如果不等于0，说明喝了不是m/h+1杯酸奶，第m/h+1杯酸奶还没有喝完
            System.out.println((m%h==0) ? n-m/h : n-(m/h)-1);
        }
    }
