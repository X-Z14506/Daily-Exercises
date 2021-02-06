package second.Day01;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-04
 * Time:18:39
 */
/*

给定一个string数组p及其大小n，同时给定长字符串string s，请返回一个bool数组，
元素为true或false对应p中的对应字符串是否为s的子串。要求p中的串长度小于等于8，
且p中的串的个数小于等于500，同时要求s的长度小于等于1000。

输入：["a","b","c","d"],4,"abc"
输出：[true,true,true,false]
 */
public class Main1 {
    public static void main(String[] args) {
        String[] p = {"a","b","c","d"};
        int n = 4;
        String s = "abc";
        System.out.println(s.contains("bc"));
        /*System.out.println(s.substring(0,s.length()-1));
        System.out.println(s.subSequence(0,s.length()));
        System.out.println(s.subSequence(0,s.length()-1).equals(p[1]));
        System.out.println(s.subSequence(0,s.length()-1).equals(p[0]));
        System.out.println(s.subSequence(0,s.length()-1).equals(p[2]));
        System.out.println(s.subSequence(0,s.length()-1).equals(p[3]));*/
        Main1 main1 = new Main1();
        boolean[] ret  = main1.chkSubStr(p,n,s);
        System.out.println(Arrays.toString(ret));

    }
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] ret = new boolean[p.length];
        for (int i = 0;i < n;i++) {
            ret[i] = s.contains(p[i]);
        }
        return ret;
    }
}
