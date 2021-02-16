package firstStage03;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:14:33
 */
public class Main23{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] ints = new int[n][n];
        for(int i = 0; i < n;i++) {
            String[] s = sc.nextLine().split(" ");
            for(int j = 0;j < n;j++) {
                ints[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(ints[i][j]!=0) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}