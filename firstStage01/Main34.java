package firstStage01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:21:04
 */

/*

 */
public class Main34 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String[] score = s.nextLine().split(" ");
            int[] e = new int[score.length];
            for (int i =0; i < e.length;i++) {
                e[i] = Integer.parseInt(score[i]);
            }
            Arrays.sort(e);
            System.out.println(Arrays.toString(e));
        }
    }
}
