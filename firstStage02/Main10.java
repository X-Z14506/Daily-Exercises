package firstStage02;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-31
 * Time:21:05
 */

/*
输入：4
输出：
*
 *
  *
   *

输入：5
输出：
*
 *
  *
   *
    *
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int init = num-1;
            for (int i = 0;i < num;i++) {
                System.out.print(String.join("", Collections.nCopies(i," "))+String.join("",Collections.nCopies(1,"*")));
                System.out.println(String.join("",Collections.nCopies(init--," ")));
            }
        }
    }
}
