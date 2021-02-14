package firstStage02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:21:59
 */

/*

输入：2
输出：
* * *
* *
*
* *
* * *

输入：3
输出：
* * * *
* * *
* *
*
* *
* * *
* * * *

 */

    /*

        上半部分：
            z行
            先输出"* ",第1行z+1个，第2行z-0个，第3行z-1个，第i行z-i+2个
            再输出"  ",第1行0个，第2行1个，第3行2个，第4行3个，第i行i-1个
        中间部分"* "和z-1个"  "
        下半部分：
            z行
            先输出"* ",第1行z-1个，第2行z+0个，第3行z+1个，第i行i+1个
            再输出"  ",第1行3个，第2行2个，第3行1个，第i行z-i个
     */
public class Main08 {
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = n+1;
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= m ; i++) {
                String s = String.join("",Collections.nCopies(m+1-i, "* "));
                //最后* 后面的空格
                s += String.join("",Collections.nCopies(i-1," "));
                list.add(s);
            }
            Boolean flag = true;
            for (int i = 0; i >= 0; ) {
                if(i == list.size()-1){
                    flag = false;
                }
                System.out.println(list.get(i));
                i = flag ? ++i : --i;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int init = 2;
            int init2 = num-1;
            int init3 = 0;
            //先打印num+1行
            for (int i = num+1;i > 0;i--) {
                System.out.print(String.join("", Collections.nCopies(i,"* ")));
                System.out.println(String.join("",Collections.nCopies(init3++,"  ")));
            }
            //在打印num行,这个num行第一行都是从2个*开始逐行+1
            for (int j = 1;j<=num;j++) {
                System.out.print(String.join("",Collections.nCopies(init++,"* ")));
                System.out.println(String.join("",Collections.nCopies(init2--,"  ")));
            }
        }
    }
}
