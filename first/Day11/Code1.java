package first.Day11;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-04
 * Time:8:11
 */


/*
给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，
请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。

输入格式：

每个输入包含1个测试用例，即一个不超过1000位的正整数N。

输出格式：

对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。

输入样例：
100311
输出样例：
0:2
1:3
3:1
 */

public class Code1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        //此处用TreeMap因为TreeMap是自动排好序的，而HashMap是无序的
        TreeMap<Character,Integer> tree = new TreeMap<>();


        for (int i = 0;i<str.length();i++) {
            char ch = str.charAt(i);
            if (ch <= '9'&& ch >= '0') {
                if (!tree.containsKey(ch)) {

                    //new Integer和Integer.valueOf区别：
                    //new Integer(127)：每次调用得到一个新对象
                    //Integer.valueOf：每次调用先看缓存池里有没有该值，有的话返回该缓存池里的内容，没有的话返回的是一个新的Integer对象，
                    tree.put(ch,new Integer(1));
                }else {
                    tree.put(ch,(Integer)tree.get(ch)+1);
                }
            }
        }

        String string = "0123456789";
        char[] ch1 = string.toCharArray();
        for (char e : ch1) {
            if (tree.containsKey(e)) {
                System.out.println(e +":"+ tree.get(e));
            }
        }
    }

}
