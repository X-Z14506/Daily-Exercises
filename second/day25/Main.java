package second.day25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-01
 * Time:22:17
 */

/*
电话号码
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");
        List<List<String>> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                for (int r = 0; i < list.size(); i++) {
                    StringBuilder sb = new StringBuilder();

                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                            sb.append(s.charAt(j));
                        }
                        if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
                            String str = String.valueOf(s.charAt(j));
                            for (int k = 2; k <= 9; k++) {
                                if (map.get(k).contains(str)) {
                                    sb.append(k);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}