package firstStage02;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-02
 * Time:22:31
 */

/*
输入一个班级5个学生各5科成绩，输出5个学生各5科成绩及总分。
输出描述：五行，按照输入顺序每行输出一个学生的5科成绩及总分（小数点保留1位），用空格分隔。


输入：
98.5 96.0 100 99 88
60.5 77 88.5 99 60
80 80.5 89 91 92
93 94 95.5 96 97.5
100 98 88.5 88 78.5

输出：
98.5 96.0 100.0 99.0 88.0 481.5
60.5 77.0 88.5 99.0 60.0 385.0
80.0 80.5 89.0 91.0 92.0 432.5
93.0 94.0 95.5 96.0 97.5 476.0
100.0 98.0 88.5 88.0 78.5 453.0

 */
public class Main31 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        int[] score = new int[5];
        //循环5次，只要读到的不为空，就执行while循环
        while ((string = reader.readLine()) != null) {
            //每进一次循环，给一次sum
            int sum = 0;
            String[] strings = string.split(" ");
            for (int i = 0;i < strings.length;i++) {
                 int score1 = (int)(Double.parseDouble(strings[i])*10);
                System.out.print(score1/10+"."+score1%10+" ");
                sum += score1;
            }
            System.out.println(sum/10+"."+sum%10);
        }
    }
}
