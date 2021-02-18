package home.day10;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:20:21
 */
/*
Integer.MAX_VALUE表示int数据类型的最大取值数：2 147 483 647
Integer.MIN_VALUE表示int数据类型的最小取值数：-2 147 483 648
 */
public class 字符串转换整数atoi {
    public static void main(String[] args) {
        String s = "-91283472332";
        int i = myAtoi(s);
        System.out.println(i);
        int j = myAtoi2(s);
        System.out.println(j);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1L);
        System.out.println(0L);
        System.out.println(1L);
    }
    public static int myAtoi(String str) {
        //有前导空格的去掉前导空格
        str = str.trim();
        if (str.length() == 0) return 0;
        //0下标元素不是数字也不是符号位，直接返回0
        if (!Character.isDigit(str.charAt(0))
                && str.charAt(0) != '-' && str.charAt(0) != '+')
            return 0;
        long ans = 0L;
        //标志位用来判断0号下标的元素是不是负号
        boolean neg = str.charAt(0) == '-';
        //如果0下标元素是符号位，则从1下标开始遍历，如果不是符号位，则从0下标开始遍历
        int i = !Character.isDigit(str.charAt(0)) ? 1 : 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + (str.charAt(i++) - '0');
            //如果是正数且值大于Integer.MAX_VALUE了 返回 Integer.MAX_VALUE
            if (!neg && ans > Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
                break;
            }
            //java中经常会碰到“long c = 1L”的写法，L表示long ，long占用8个字节，表示范围：-9223372036854775808 ~ 9223372036854775807
            //1L其实就是1。
            //如果是负数且值大于1L+ Integer.MAX_VALUE，则返回1l+ Integer.MAX_VALUE
            if (neg && ans > 1L + Integer.MAX_VALUE) {
                ans = 1L + Integer.MAX_VALUE;
                break;
            }
        }
        //根据标志位判断返回正负
        return neg ? (int) -ans : (int) ans;
    }
    public static int myAtoi2(String str) {
        str = str.trim();
        if (str.length()==0) {
            return 0;
        }
        if (str.charAt(0) > '9' || str.charAt(0) < '0' && str.charAt(0)!='+' && str.charAt(0) != '-') {
            return 0;
        }
        long ret = 0L;
        boolean flag = str.charAt(0) == '-';
        int i = !Character.isDigit(str.charAt(0)) ? 1: 0;
        while ( i<str.length() && Character.isDigit(str.charAt(i))) {
            ret = ret*10+(str.charAt(i++)-'0');
            //正数超过最大值
            if (!flag && ret>Integer.MAX_VALUE) {
                ret =  Integer.MAX_VALUE;
                break;
            }
            //负数超过最大值
            if (flag && ret > Integer.MAX_VALUE+1L) {
                ret = Integer.MAX_VALUE+ 1L;
                break;
            }
        }
        return flag ? (int)-ret : (int)ret;
    }
}
