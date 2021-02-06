package second.day14;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-18
 * Time:22:59
 */

/*
2的个数
 */
public class Main2 {
    public static void main(String[] args) {
        int n = 32;
        System.out.println(countNumberOf2s(n));
    }
    public static int countNumberOf2s(int n) {
        int count = 0;
        for (int i = 0;i <= n;i++) {
            String s = String.valueOf(i);
            if (s.contains("2")) {
                int len = s.length();
                for (int j = 0;j<len;j++) {
                    if (s.charAt(j)=='2') {
                        count++;
                    }
                }
            }

        }
        return count;
    }
}
