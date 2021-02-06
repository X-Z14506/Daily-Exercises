package second.day06;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.jnlp.ClipboardService;
import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-09
 * Time:20:18
 */
/*
最高分是多少

输入：
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出：
5
6
5
9

 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int M = Integer.parseInt(strings[1]);
            String[] strings2 = scanner.nextLine().split(" ");
            int[] ints = new int[N];
            for (int i = 0;i < N;i++) {
                ints[i] = Integer.parseInt(strings2[i]);
            }
            List<Integer> list = new ArrayList<>();

            for (int i = 0;i < M;i++) {
                String[] strings1 = scanner.nextLine().split(" ");
                if (strings1[0].charAt(0)=='Q') {
                    int index1 = Integer.parseInt(strings1[1]);
                    int index2 = Integer.parseInt(strings1[2]);
                    Arrays.sort(ints,index1-1,index2-1);
                    //query(ints,index1-1,index2-1);
                    list.add(ints[index2-1]);
                }else if (strings1[0].charAt(0)=='U') {
                    int index = Integer.parseInt(strings1[1]);
                    int num = Integer.parseInt(strings1[2]);
                    ints[index] = num;
                    if (i==M-2) {
                        Arrays.sort(ints);
                    }
                }
            }
            for (int i : list) {
                System.out.println(i);
            }
        }
    }
/*
    private static void query(int[] ints,int index1,int index2) {
        Arrays.sort(ints,index1,index2);
    }*/
}
