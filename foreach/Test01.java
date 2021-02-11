package foreach;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-23
 * Time:10:01
 */

import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *  JDK5.0的新特性  foreach
 */
public class Test01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("java");
        list.add("我爱java");

        //得到list集合元素的三种方式

        //1.遍历，使用迭代器方式
        System.out.println("=======遍历，使用迭代器方式===============");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }

        //2.使用下标方式（只针对于有下标的集合）
        System.out.println("==========使用下标方式（只针对于有下标的集合）==============");
        for (int i = 0; i < list.size();i++) {
            System.out.println(list.get(i));
        }

        //3.使用foreach
        System.out.println("===============使用foreach=================");
        for(String s : list) {
            System.out.println(s);
        }
    }
}
