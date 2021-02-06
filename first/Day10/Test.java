package first.Day10;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-03
 * Time:9:00
 */
public class Test {
    public static void main0(String[] args) {
        int i = 0;
        double j = 0;
        for (double sum = 0; sum<100; i++) {
            sum = i*2.5-i/5*6;
            j = sum;
        }
        System.out.println(j);
        System.out.println(i);
    }

    public static void main(String[] args) {
        try{
            int i = 100/0;
            System.out.println(i);
        }catch (Exception e) {
            System.out.println(1);
            throw new RuntimeException();
        }finally {
            System.out.println(2);
        }
        System.out.println(3);//执行了异常就不会执行这句了，不执行异常会执行这句
    }

    //////////////////////////////////////////////////////////////////////
    public static void main1(String[] args) {
        Test01 test = new Test01();
        System.out.println("000"+test.add(9,34));
    }
}
class Test01 {
    public int add(int a, int b) {
        try {
            return a+b;
        }catch (Exception e) {
            System.out.println("catch语句块");
        }finally {
            System.out.println("finally语句块");
        }
        return 0;
    }
}

