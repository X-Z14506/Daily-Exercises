package second.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-16
 * Time:23:01
 */
/*
大整数排序 TODO ：IDEA可以跑，牛客不通过
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0;i < n;i++) {
                String s = sc.nextLine();
                list.add(s);
            }
            //对list内容进行大小排序
            sort(list);
            //输出list
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static void sort(List<String> list) {
        for (int i = 0;i < list.size()-1;i++) {
            String s1 = list.get(i);
            for (int j = i+1;j < list.size();j++) {
                String s2 = list.get(j);
                if (s1.length()>s2.length()) {
                    //交换list的i下标和j下标的内容
                    swap(list,i,j);
                }else if (s1.length()==s2.length()) {
                    for (int k = 0;k < s1.length();k++) {
                        if (s1.charAt(k) > s2.charAt(k)) {
                            swap(list,i,j);
                        }
                    }
                }
            }
        }
        //System.out.println(list);
    }

    public static List<String> swap(List<String> list,int i,int j) {
        String s1 = list.get(i);
        String s2 = list.get(j);
        String temp = s1;
        list.set(i,s2);
        list.set(j,temp);
        return list;
    }
}
