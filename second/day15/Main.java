package second.day15;

import javax.swing.plaf.multi.MultiViewportUI;
import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-20
 * Time:16:29
 */

/*
    锤子剪刀布
 */
public class Main {
    //记录甲、乙胜利次数
    private static int winA = 0;
    private static int winB = 0;

    //记录胜利使用的手势的次数
    private static HashMap<Character,Integer> A = new LinkedHashMap<>();
    private static HashMap<Character,Integer> B = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count = n;
            sc.nextLine();
            while (count-- > 0) {
                String[] strings = sc.nextLine().split(" ");
                StringBuffer sb = new StringBuffer();
                for (String s : strings) {
                    sb.append(s);
                }
                Cjb(sb.toString());
            }
            //计算平局数
            int peace = n-winB-winA;
            System.out.println(winA+" "+peace+" "+winB);
            System.out.println(winB+" "+peace+" "+winA);

            //正常情况,即A、B都有输有赢
            if (A.size()!=0 && B.size()!=0) {
                System.out.println(Mvp(A)+" "+Mvp(B));
            }
            //A全胜
            if (A.size()!=0 && B.size()==0) {
                char a = (Mvp(A) == 'B') ? 'J':((Mvp(A)== 'C')?'B':'C');
                System.out.println(Mvp(A)+" "+a);
            }
            //B全胜
            if (B.size()!=0 && A.size()==0) {
                char b = (Mvp(B) == 'B') ? 'J':((Mvp(B)=='C') ? 'B':'C');
                System.out.println(b+" "+ Mvp(B));
            }
        }
    }

    private static char Mvp(HashMap<Character, Integer> map) {
        Set<Character> set = map.keySet();
        int temp = 0;
        //ret的初始字符取大于'J'的ASCII值即可
        char ret = 'Z';
        for (char c : set) {
            if (temp <= map.get(c)) {
                temp = map.get(c);
                if (ret>c) {
                    ret = c;
                }
            }
        }
        return ret;
    }

    private static void Cjb(String s) {
        if (s.equals("CJ") || s.equals("JB") || s.equals("BC")) {
            winA++;
            A.put(s.charAt(0),A.containsKey(s.charAt(0)) ? A.get(s.charAt(0))+1 : 1);
        }
        if (s.equals("JC") || s.equals("BJ") || s.equals("CB")) {
            winB++;
            B.put(s.charAt(1),B.containsKey(s.charAt(1)) ? B.get(s.charAt(1))+1 : 1);
        }
    }

}
