package first.Day13;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-07
 * Time:8:12
 */
public class Test7 {
    public static void main(String[] args) {
        int i = 0;
        for (out('A');out('B')&&(i<2);out('C')) {
            i++;
            out('D');
        }
    }

    private static boolean out(char a) {
        System.out.print(a);//ABDCBDCB
        return true;
    }
}
