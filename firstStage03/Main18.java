package firstStage03;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:10:14
 */

/*
小乐乐输入百分制成绩，他想将成绩转换成等级制。
转换规则为：90-100为’A’，80-89为’B’，70-79为’C’，60-69为’D’，59以下为’E’。如果输入的成绩不在0-100之间，输出’F’。
 */
public class Main18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int score = sc.nextInt();
            System.out.println(change(score));
        }
    }
    static char change(int score){
        if (score>=90 && score<=100) {
            return 'A';
        }else if (score>=80 && score <= 89) {
            return 'B';
        }else if (score>=70 && score <= 79) {
            return 'C';
        }else if (score>=60 && score <= 69) {
            return 'D';
        }else if (score>=0 && score <= 59) {
            return 'E';
        }else {
            return 'F';
        }
    }
}
