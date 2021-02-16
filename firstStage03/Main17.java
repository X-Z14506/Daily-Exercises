package firstStage03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:10:04
 */

/*
小乐乐与二段数
 */
public class Main17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int temp;
        while (true) {
            temp = sc.nextInt();
            if (temp == 0) {
                break;
            } else {
                arr.add(temp);
            }
        }
        for (Integer o : arr) {
            printMinDoubleNumber(o);
        }
    }

    public static void printMinDoubleNumber(int number) {
        long temp = number;
        while (true) {
            if (isMinDoubleNumber(temp)) {
                System.out.println(number + ": " + temp);
                return;
            }
            temp += number;
        }
    }

    public static boolean isMinDoubleNumber(long number) {
        if (number < 10) {
            return false;
        }
        long temp;
        long preTemp = number % 10;
        int count = 1;
        number /= 10;
        while (number > 0) {
            if (count > 2) return false;
            temp = number % 10;
            if (temp != preTemp) {
                count++;
            }
            preTemp = temp;
            number /= 10;
        }

        if (count == 2) {
            return true;
        }else {
            return false;
        }
    }
}
