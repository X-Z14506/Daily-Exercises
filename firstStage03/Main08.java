package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-04
 * Time:23:46
 */

/*
井字棋
KiKi和BoBo玩 “井”字棋。也就是在九宫格中，只要任意行、列，或者任意对角线上面出现三个连续相同的棋子，就能获胜。请根据棋盘状态，判断当前输赢。

输入描述:
三行三列的字符元素，代表棋盘状态，字符元素用空格分开，代表当前棋盘，其中元素为K代表KiKi玩家的棋子，为O表示没有棋子，为B代表BoBo玩家的棋子。
输出描述:
如果KiKi获胜，输出“KiKi wins!”；
如果BoBo获胜，输出“BoBo wins!”；
如果没有获胜，输出“No winner!”。

输入:
K O B
O K B
B O K

输出：
KiKi wins!

 */
public class Main08 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char[][] strings = new char[3][3];
        for (int i =0;i < 3;i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0;j < 3;j++) {
                strings[i][j] = s[j].charAt(0);
            }
        }

      /*  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] input = new char[3][3];

        for(int i=0; i<3; i++){
            String row = br.readLine();
            for(int j=0; j<3; j++){
                input[i][j] = row.charAt(2*j);
            }
        }
*/
        boolean KKWin = false;
        boolean BBWin = false;
        KKWin = checkWinner('K',strings);
        BBWin = checkWinner('B',strings);
        if (KKWin==true && BBWin==true){
            System.out.println("No winner!");
        }else if (KKWin==true) {
            System.out.println("KiKi wins!");
        }else if (BBWin==true) {
            System.out.println("BoBo wins!");
        }else  {
            System.out.println("No winner!");
        }
    }
    static boolean checkWinner(char c ,char[][] arr ) {
        int count = 0;
        int size = 3;
        //1.先判断主对角线是否满足
        for (int i =0;i < size;i++) {
            if (arr[i][i] == c) {
                count++;
            }
        }
        if (count==3) {
            return true;
        }
        //走到这里说明没有返回，count要重新置为0，用来判断下一个位置是否满足
        count = 0;

        //2.在判断副对角线是否满足
        if (arr[0][2]==c && arr[1][1]==c && arr[2][0] == c) {
            return true;
        }

        //3.判断行是否满足
        for (int i = 0;i < size;i++) {
            for (int j = 0;j < size;j++) {
                if (arr[i][j]==c){
                    count++;
                }
            }
            if (count==3) {
                return true;
            }
            count=0;
        }

        //判断列是否满足
        for (int i = 0;i < size;i++) {
            for (int j = 0;j<size;j++) {
                if (arr[j][i] == c) {
                    count++;
                }
            }
            if (count==3) {
                return true;
            }
            count=0;
        }

        //程序走到这里说明都不满足
        return false;
    }












    public static void main1(String[] args){
        Scanner sc=new Scanner(System.in);
        String[][] s=new String[3][3];
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                s[i][j]=sc.next();
            }
        }
        int a = jing("K",s);
        int b = jing("B",s);
        if(a==b)System.out.println("No winner!");
        else if(a>b)System.out.println("KiKi wins!");
        else System.out.println("BoBo wins!");
    }
    public static int jing(String p,String[][] m){
        int sum=0;
        for(int i=0;i<3;i++){
            if(m[i][0].equals(p)&m[i][1].equals(p)&&m[i][2].equals(p)){sum++;}
            if(m[0][i].equals(p)&&m[1][i].equals(p)&&m[2][i].equals(p)){sum++;}
        }
        if(m[1][1].equals(p)&m[0][0].equals(p)&&m[2][2].equals(p)){sum++;}
        if(m[1][1].equals(p)&&m[0][2].equals(p)&&m[2][0].equals(p)){sum++;}
        return sum;
    }
}
