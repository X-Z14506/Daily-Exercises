package second.day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-09
 * Time:12:29
 */

/*
数字分类
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int sum1 = 0;
        List<Integer> A2 = new ArrayList<>();
        int sum2 = 0;
        List<Integer> A3 = new ArrayList<>();
        List<Integer> A4 = new ArrayList<>();
        double sum4 = 0;
        List<Integer> A5 = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        for (int i = 1;i < n;i++){
            int e = Integer.parseInt(strings[i]);
            if (e%5==0 && e%2==0) {
                sum1+=e;

            }else if (e%5==1) {
                A2.add(e);
                if (A2.size()%2!=0) {
                    sum2+=e;
                }else {
                    sum2-=e;
                }

            }else if (e%5==2) {
                A3.add(e);

            }else if (e%5==3) {
                A4.add(e);
                sum4+=e;
            }else if (e%5==4) {
                A5.add(e);
            }
        }
        list.add(0,sum1);
        list.add(1,sum2);
        list.add(2,A3.size());
        double avg4 = sum4/A4.size();
        Collections.sort(A5);
        list.add(3,avg4);
        list.add(4,A5.get(A5.size()-1));
        for (int i = 0;i < 3;i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.print(String.format("%.1f",list.get(3))+" ");
        System.out.print(list.get(4));
    }
}
