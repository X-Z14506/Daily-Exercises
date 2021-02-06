package second.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-06
 * Time:19:59
 */
/*
统计每个月兔子的总数
 */
public class Main01 {
    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(reader.readLine());
        int totalCount = getTotalCount(month);
        System.out.println(totalCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int month = sc.nextInt();
            int totalCount = getTotalCount(month);
            System.out.println(totalCount);
        }


    }
    public static int getTotalCount(int monthCount) {
        if (monthCount < 3){
            return 1;
        }else {
           return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
        }
    }
}
