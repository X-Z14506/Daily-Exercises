package first.Day16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-10
 * Time:9:24
 */

/*
    问题描述：
    本题要求读入 N 名学生的成绩，将获得某一给定分数的学生人数输出。

    输入格式：
    输入在第 1 行给出不超过 10​5​​ 的正整数 N，即学生总人数。随后一行给出 N 名学生的百分制整数成绩，中间以空格分隔。最后一行给出要查询的分数个数 K（不超过 N 的正整数），随后是 K 个分数，中间以空格分隔。

    输出格式：
    在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。

    输入样例：
    10
    60 75 90 55 75 99 82 90 75 50
    3 75 90 88

    输出样例：
    3 2 0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        List list = new ArrayList();
        while (n!=0&&in.hasNext()) {
            for (int i=0;i<n;i++) {
                int score = in.nextInt();
                list.add(score);
//                list.add(" ");
            }
            int size = list.size();
            int setScore = in.nextInt();
            for (int i = 0;i < size;i++) {
                if (list.get(i).equals(setScore)) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
