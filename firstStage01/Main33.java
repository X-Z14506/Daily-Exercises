package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:20:52
 */

/*
    题目描述
    假设你们社团要竞选社长，有两名候选人分别是A和B，社团每名同学必须并且只能投一票，最终得票多的人为社长.
    输入描述:
    一行，字符序列，包含A或B，输入以字符0结束。
    输出描述:
    一行，一个字符，A或B或E，输出A表示A得票数多，输出B表示B得票数多，输出E表示二人得票数相等。

    输入：ABBABBAAB0
    输出：B

 */

public class Main33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ret = scanner.next();
        int a = 0;
        int b = 0;
        for (int i = 0; i < ret.length()-1;i++){
            if (ret.charAt(i) == 'A') {
                a++;
            }else if (ret.charAt(i) == 'B') {
                b++;
            }
        }
        if (a>b) {
            System.out.println('A');
        }else if (a < b) {
            System.out.println('B');
        }else {
            System.out.println('E');
        }
    }
}
