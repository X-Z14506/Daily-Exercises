package firstStage02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-02
 * Time:21:24
 */

/*
输入：5
     1 6 9 22 30
     8

输出：1 6 8 9 22 30

 */
public class Main27 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        String[] strings = reader.readLine().split(" ");
        int[] ints = new int[n+1];
        for (int i = 0;i < strings.length;i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int m = Integer.parseInt(reader.readLine());
        ints[n] = m;
        Arrays.sort(ints);
        for (int i = 0;i < ints.length;i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
