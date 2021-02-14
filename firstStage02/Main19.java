package firstStage02;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:17:24
 */


public class Main19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        List<Integer> list = new ArrayList<>();
        //int[][] arr = new int[2*m][n];
        for (int i = 0 ; i < m*2 ; i++ ) {
            String[] strings = scanner.nextLine().split(" ");
            for (int j = 0;j < strings.length;j++) {
                list.add(Integer.parseInt(strings[j]));
            }
        }
        int prev = 0;
        int last = m*n;
        int count = 0;
        for (int i = 0;i < m*n;i++) {
            if (list.get(prev++) == list.get(last++)) {
                count++;
            }
        }
        //整型转浮点型
        double ret = count;
        //*100=以百分比的形式
        System.out.println(String.format("%.2f",ret/(m*n)*100));
    }
}
