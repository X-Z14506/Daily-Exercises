package home.day11;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-16
 * Time:12:07
 */
public class Test {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(test(num));//30
        float[][] a = new float[6][];
        float b[][] = new float[6][6];
        String s = "123adc";
        String s1 = s.toUpperCase();
        System.out.println(s);
        System.out.println(s1);
    }

    private static int test(int num) {
        try {
            num+=10;
            return num;
        }catch (RuntimeException e) {

        }catch (Exception e) {

        } finally {
            num+=10;
            return num;//30
        }
    }

}
