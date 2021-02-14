package firstStage01;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:16:29
 */

/*
       题目描述
         在计算BMI（BodyMassIndex ，身体质量指数）的案例基础上，判断人体胖瘦程度。BMI中国标准如下表所示。

         BMI<18.5                   偏瘦（Underweight）
         BMI>=18.5 且 BMI<=23.9     正常(Normal)
         BMI>23.9 且 BMI<=27.9      过重(Overweight)
         BMI>27.9                   肥胖(Obese)


        输入描述:
        多组输入，每一行包括两个整数，用空格隔开，分别为体重（公斤）和身高（厘米）。
        输出描述:
        针对每行输入，输出为一行，人体胖瘦程度，即分类。

        输入：80 170
            60 170
            90 160
            50 185
        输出：Overweight
            Normal
            Obese
            Underweight
 */

public class Main39 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] strings = s.nextLine().split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            double bmi = a / Math.pow(b/100.0,2);
            if (bmi<18.5) {
                System.out.println("Underweight");
            }else if (bmi>=18.5 && bmi<=23.9) {
                System.out.println("Normal");
            }else if (bmi>23.9 && bmi<=27.9) {
                System.out.println("Overweight");
            }else {
                System.out.println("Obese");
            }
        }
    }

}
