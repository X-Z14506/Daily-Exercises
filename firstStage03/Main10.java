package firstStage03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-05
 * Time:22:34
 */

/*
小乐乐定闹钟

输入描述:
输入现在的时刻以及要睡的时长k（单位：minute），中间用空格分开。

输入格式：hour:minute k(如hour或minute的值为1，输入为1，而不是01)

(0 ≤ hour ≤ 23，0 ≤ minute ≤ 59，1 ≤ k ≤ 109)

输出描述:
对于每组输入，输出闹钟应该设定的时刻，输出格式为标准时刻表示法（即时和分都是由两位表示，位数不够用前导0补齐）。

输入：
0:0 100
输出：
01:40

输入：
1:0 200
输出：
04:20

 */
public class Main10{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //先按空格将读入的一行分成两部分，在从第一部分中按冒号将第一部分分成时和分
        String[] strings1 = reader.readLine().split(" ");
        String[] strings2 = strings1[0].split(":");

        //当前时间的小时数
        int curH = Integer.parseInt(strings2[0]);
        //当前时间的分钟数
        int curM = Integer.parseInt(strings2[1]);
        //定时时间
        int timer = Integer.parseInt(strings1[1]);
        //定时的小时数
        int hours = timer/60;
        //定时的分钟数
        int minutes = timer%60;

        //定时时间到的时间的小时数
        curH = (curH+hours+(curM+minutes)/60)%24;
        //定时时间到的时间的分钟数
        curM = (curM+minutes)%60;
        System.out.println(String.format("%02d",curH)+":"+ String.format("%02d",curM));
    }



    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            String[] time = s[0].split(":");
            int sleep = Integer.parseInt(s[1]);
            int hour = sleep/60;
            int minute = sleep%60;
            int curH = Integer.parseInt(time[0]);
            int curM = Integer.parseInt(time[1]);
            curH = (curH+hour+(minute+curM)/60)%24;
            curM = (curM+minute)%60;
            System.out.println(String.format("%02d",curH)+":"+ String.format("%02d",curM));
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  data = sc.nextLine();
        int p = data.indexOf(":");
        int q = data.indexOf(" ");

        int h = Integer.parseInt(data.substring(0, p));
        int m = Integer.parseInt(data.substring(p+1, q));
        int k = Integer.parseInt(data.substring(q+1));

        //先将总小时数和总分钟数算出来，让该进位的进位
        m = m + k % 60;
        h = h + k / 60 + m / 60;

        //在求出总小时相对于24小时制为几点，总分中数相对于60为多少分
        m = m % 60;
        h = h % 24;

        String h1, m1;
        if (h < 10){
            h1 = "0" + h;
        }else {
            h1 = h + "";
        }

        if (m < 10){
            m1 = "0" + m;
        }else {
            m1 = m + "";
        }

        System.out.println(h1 + ":" + m1);
    }
}