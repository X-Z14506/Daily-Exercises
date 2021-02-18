package home.day09;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:17:51
 */
public class 二进制求和 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String s = addBinary(a, b);
        System.out.println(s);
        System.out.println('c'-'d');
    }
    public static String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carryOver = 0;
        StringBuilder sb = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i>=0 && j>=0) {
            int sum = carryOver;
            sum+=a.charAt(i--)-'0';
            sum+=b.charAt(j--)-'0';
            carryOver = sum/2;//如果相加得2则进位
            sb.append(sum%2);//将低位上的数拼接到sb
        }
        //如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i>=0) {
            int sum = carryOver+a.charAt(i--)-'0';
            carryOver = sum/2;
            sb.append(sum%2);
        }
        //  如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j>=0) {
            int sum = carryOver + b.charAt(j--)-'0';
            carryOver = sum/2;
            sb.append(sum%2);
        }
        ///如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carryOver==1) {
            sb.append(carryOver);
        }
        //反转字符串得到结果
        return sb.reverse().toString();
    }
}
