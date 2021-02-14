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
 * Time:21:44
 */

/*
 输入：3

 输出：
   *
  * *
 * * *
* * * *
 * * *
  * *
   *


 */
public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int count = num;
            int count2 = num+1;
            //先打印num行上三角
            for (int i = 0;i < num;i++) {
                System.out.println(String.join("", Collections.nCopies(count--," "))+String.join("",Collections.nCopies(i+1,"* ")));
            }
            //在打印num+1行下三角
            for (int j = 0;j <= num;j++) {
                System.out.println(String.join("",Collections.nCopies(j," "))+String.join("",Collections.nCopies(count2--,"* ")));
            }
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<String> remember = new ArrayList<>(n);
            for (int i = 1; i <=n+1; i++) {
                String str = String.join("",Collections.nCopies(n+1-i," "));
                str+=String.join("",Collections.nCopies(i,"* "));
                remember.add(str);
            }
            boolean flag = true;
            for (int i = 0; i >=0 ;) {
                if (i==remember.size()-1)flag=false;
                System.out.println(remember.get(i));
                i= flag?++i:--i;
            }
        }
    }
}
