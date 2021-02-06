package second.day14;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-18
 * Time:22:03
 */

/*
在霍格沃兹找零钱
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        String[] P = strings[0].split("\\.");
        String[] A = strings[1].split("\\.");
        int[] ret = new int[A.length];

        for (int i = 2;i>=1;i--) {
            int a = Integer.parseInt(A[i]);
            int p = Integer.parseInt(P[i]);
            if (a>p) {
                ret[i] = a-p;
            }else if (i==2){
                ret[i] = a-p+29;
                ret[i-1]--;
            }else if (i==1) {
                ret[i] = a-p+17;
                ret[i-1]--;
            }
        }
        if (ret[0] == 0) {
            ret[0] = Integer.parseInt(A[0])-Integer.parseInt(P[0]);
        }else {
            ret[0] = Integer.parseInt(A[0])-Integer.parseInt(P[0])-1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ret[0]);
        sb.append(".");
        sb.append(ret[1]);
        sb.append(".");
        sb.append(ret[2]);
        System.out.println(sb);
    }
}
