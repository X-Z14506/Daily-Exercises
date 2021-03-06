package first.Day02201123;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-25
 * Time:20:04
 */


/*
有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶
 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水
 喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？

输入描述:
输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），
 表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。

输出描述:
对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。

输入例子:

3
10
81
0
输出例子:
1
5
40
*/

public class Code02 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        while (input.hasNext()) {
            int num = input.nextInt();
            if (num!=0) {
                int ret = maxDrinks(num);
                System.out.println(ret);
            }
        }
    }

    private static int maxDrinks(int num) {
        //先将手上的空瓶子三个一组分好，
        int k = 0;
        while (num >= 3) {
            //1.空瓶子为三的倍数时，k为可以换回饮料的个数
            if (num % 3 == 0) {
                k = k + num/3;
                num = num/3;
            }
            //2.空瓶子不为三的个数时，num为空瓶子数
            if (num % 3 != 0) {
                k= k + num/3;
                int i = num%3;
                num = num/3 + i;
            }
        }
        //3.空瓶子数为2时，还可以换一瓶饮料，所以k+1；
        if (num == 2) {
            k = k+1;
        }
        return k;
    }
}
