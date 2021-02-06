package first.Day18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-12
 * Time:13:21
 */

/*
      如何取出Map中的key和value
 */
public class T {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "zhangsan1");
        map.put(6, "zhangsan2");
        map.put(3, "zhangsan3");
        map.put(4, "zhangsan4");
        Set<Integer> keySet = map.keySet();
        //  方法1：
        for (int key : keySet) {
            System.out.println(key + "--->" + map.get(key));
        }
        /*
                1--->zhangsan1
                3--->zhangsan3
                4--->zhangsan4
                6--->zhangsan2
         */

        //方法2：
        for (int key : map.keySet()) {
            System.out.println(key + "-------" + map.get(key));
        }

        /*
        1-------zhangsan1
        3-------zhangsan3
        4-------zhangsan4
        6-------zhangsan2
         */

        //方法3：
        Iterator<Integer> it = keySet.iterator();
        while (it.hasNext()) {
            int key = it.next();
            String value = map.get(key);
            System.out.println(key + "   " + value);
        }

        /*
        1   zhangsan1
        3   zhangsan3
        4   zhangsan4
        6   zhangsan2
         */
    }

}
