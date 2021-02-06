package second.web1;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-05
 * Time:18:16
 */

/*
数组中值出现了一次的数
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] s = sc.nextLine().split(" ");
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0;i < n;i++) {
                int e = Integer.parseInt(s[i]);
                if (!map.containsKey(e)) {
                    map.put(e,1);
                }else {
                    int val = map.get(e);
                    map.put(e,++val);
                }
            }
            List<Integer> list = new ArrayList<>();
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();
            for (Map.Entry<Integer,Integer> m : set) {
                if (m.getValue()%2!=0) {
                    list.add(m.getKey());
                }
                if (list.size()==2) {
                    break;
                }
            }
            Collections.sort(list);
            System.out.println(list.get(0)+" "+list.get(1));
        }
    }
}
