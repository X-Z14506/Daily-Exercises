package firstStage01;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-09
 * Time:22:02
 */
public class 十进制转二进制 {
    //法一：设置一个记位数的变量k;
    public static void main1(String[] args) {
        int k=1;			//控制位数
        int remember;	//存放余数
        int sum=0;		//用来将余数相加
        int n = 10;
        while (n!=0) {
            remember = n%2;
            n/=2;
            sum=sum+remember*k;
            k=k*10;
        }
        System.out.println("转换成二进制是："+sum);//1010
    }

    //方法二：（将每一个余数用字符的形式输出）
    public static void main2(String[] args) {
        int n=10;
        String str = "";
        while(n!=0){
            str = n%2+str;
            n = n/2;
        }
        System.out.println(str);//1010
    }

    //方法三：“移位操作”
    //       >>>逻辑运算符，向右移n位，高位补零
    //       >>算数运算符，向右移n位，正数高位补0，负数高位补1
    //       <<移位符，向左移n位
    public static void main(String[] args) {
        int n=10;
        for(int i = 31;i >= 0; i--) {
            System.out.print(n >>> i & 1);//00000000000000000000000000001010
        }
    }
}
