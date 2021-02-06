package second.day10;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-15
 * Time:20:16
 */

/*
密码验证合格程序
 */

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            boolean ret = CodeIsOk(s);
            if (ret) {
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }

    //判断密码是否合格
    public static boolean CodeIsOk(String s) {
        boolean b = true;
        //先判断长度
        if (s.length() <= 8) {
            b = false;
            return b;
        }
        //在判断符号数
        boolean b1 = CodeIsOk2(s);
        if (!b1) {
            b = false;
            return b;
        }
        //最后判断不能有相同长度超过2的子串重复
        boolean b2 = CodeIsOk3(s);
        if (!b2) {
            b = false;
            return b;
        }
        return b;
    }

    //判断是否存在三种以上的符号
    public static boolean CodeIsOk2(String s) {
        int len = s.length();
        int[] ints = new int[4];
        for (int i = 0;i < len;i++) {
            char c = s.charAt(i);
            if (c>='0' && c<='9') {
                ints[0]++;
            }else if (c>='a' && c<='z') {
                ints[1]++;
            }else if (c>='A' && c<='Z') {
                ints[2]++;
            }else {
                ints[3]++;
            }
        }
        int count = 0;
        for (int i : ints) {
            if (i == 0){
                count++;
            }
        }
        return count <= 1;
    }

    //不能有相同长度超过2的子串重复，最小的为长度为3的重复子串，
    // 若长度为4的重复子串，则长度为3的子串也包含在里面，所以只需要找长度为3的子串即可
    private static boolean CodeIsOk3(String s) {
        //遍历整个密码串
        for (int i = 0;i < s.length()-3;i++) {
            //从前向后找子串
            String s1 = s.substring(i,i+3);
            String otherString = s.substring(i+3,s.length()-1);
            if (otherString.contains(s1)) {
                return false;
            }
        }
        return true;
    }
}
