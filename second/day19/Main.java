package second.day19;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-26
 * Time:12:06
 */

/*
   木棒拼图：

   思路：首先要围成一个面积大于1的n边形，则任一n-1条边长度之和大于另一边长度
        用二维数组存放输入的数据，用LinkedList存放木棒的长度，
        加木棒用add，减木棒用remove，然后在判断能否构成多边形
        先给LinkedList排序，n-1条小边之和大于最大边，就能拼出多边形，否则不能
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0;i<n;i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                save(arr,i+1);
            }

        }
    }

    private static void save(int[][] arr,int e) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < e;i++) {
            if (arr[i][0] == 1) {
                list.add(arr[i][1]);
            }else {
                list.remove(arr[i][1]);
            }
        }
        if (canConstitude(list)) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    private static boolean canConstitude(List<Integer> list) {
        Collections.sort(list);
        int sum = 0;
        for (int i = 0;i<list.size()-1;i++) {
            sum+=list.get(i);
        }
        if (sum > list.get(list.size()-1)) {
            return true;
        }else {
            return false;
        }
    }
}
