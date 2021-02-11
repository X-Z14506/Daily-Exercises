package generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-23
 * Time:9:34
 */

public class GenericTest01 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("http://www.baidu.com");
        list.add("http://www.tengxun.com");
       /* list.add("abc");
        list.add("zdy");
        list.add(new String("java"));*/
        System.out.println(list.size());

        //用迭代器遍历
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            String s1 = s.substring(7);
            System.out.println(s1);
        }
    }
}
