package firstStage02;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:15:09
 */

/*
    题目描述
        有一个有序数字序列，从小到大排序，将一个新输入的数插入到序列中，保证插入新数后，序列仍然是升序。
        输入描述:
        第一行输入一个整数(0≤N≤50)。

        第二行输入N个升序排列的整数，输入用空格分隔的N个整数。

        第三行输入想要进行插入的一个整数。

        输出描述:
        输出为一行，N+1个有序排列的整数

        输入：5
             1 6 9 22 30
             8
        输出：1 6 8 9 22 30
 */

    //直接加进去，拍个顺序就好
public class Main17 {
    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        int m = scanner.nextInt();
        list.add(m);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] strings = scanner.nextLine().split(" ");
        int n1 = Integer.parseInt(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < n1;i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        String m = scanner.nextLine();
        list.add(Integer.parseInt(m));
        Collections.sort(list);

        for (int i = 0;i < list.size();i++) {
            System.out.print(list.get(i)+" ");
        }


    }

}
