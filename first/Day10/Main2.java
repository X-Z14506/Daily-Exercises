package first.Day10;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-03
 * Time:10:17
 */
public class Main2 {
    public static void main(String[] args) {
        Object o = new Object() {
            public boolean equals(Object o1) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }
}
