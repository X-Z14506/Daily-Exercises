package second.web1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-05
 * Time:18:26
 */
/*
单调栈结构
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] s = sc.nextLine().split(" ");
            //System.out.println(Arrays.toString(s));
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i < n;i++) {
                list.add(Integer.valueOf(s[i]));
            }
            int[] save = new int[2];
            for (int i = 0;i < n;i++) {
                int left = i-1;
                int right = i+1;
                while (left >= 0) {
                    if (list.get(i) <= list.get(left)) {
                        left--;
                    }else if (list.get(i) > list.get(left)) {
                        save[0] = left;
                        break;
                    }
                }
                if (left < 0) {
                    save[0] = -1;
                }
                //i右边
                while (right < list.size()) {
                    if (list.get(i) <= list.get(right)) {
                        right++;
                    }else if(list.get(i) > list.get(right)) {
                        save[1] = right;
                        break;
                    }
                }
                if (right >= list.size()) {
                    save[1] = -1;
                }
                System.out.println(save[0]+" "+save[1]);
            }
        }
    }
}
