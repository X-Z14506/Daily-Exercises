package first.Day13;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-07
 * Time:10:08
*/

/*
   题目描述
        美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统。
        2014年底，为庆祝“计算机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。现在你也跟他一起画吧！

        输入
        多组输入，每组数据一行，每行给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。

        输出
        输出由给定字符C画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%（四舍五入取整）。
        每组数据后空一行

        样例输入
        10 a
        样例输出
         aaaaaaaaaa
         a        a
         a        a
         a        a
         aaaaaaaaaa
 */
public class Main {
    //方法一：
    //每种方法的输入输出是一样的，然后这种方法需要分输入的是奇数还是偶数。若偶数要输出行数为列数的一半；
    //而若输入的是奇数，那么由于50%并且四舍五入，所以行数永远是列数的一半抹去小数加一，即int类型的除法
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNext()) {
            n = sc.nextInt();
            String str = sc.next();
            char c = str.charAt(0);
            //输入为偶数的情况下
            if(n%2==0) {
                //行数
                for(int i=0;i<n/2;i++) {
                    //如果是第一行或者最后一行，要打印n个字符
                    if(i==0||i==n/2-1) {
                        for(int j=0;j<n;j++)
                            System.out.print(c);
                     //如果不是第一行或者最后一行，第一列和最后一列输出字符，中间全部是空格
                    }else {
                        for(int j=0;j<n;j++) {
                            if(j==0||j==n-1)
                                System.out.print(c);
                            else
                                System.out.print(" ");
                        }
                    }
                    //每行打印完了要换到下一行
                    System.out.println();
                }

             //输入为奇数的情况下
            }else {
                for(int i=0;i<n/2+1;i++) {
                    if(i==0||i==n/2) {
                        for(int j=0;j<n;j++)
                            System.out.print(c);
                    }else {
                        for(int j=0;j<n;j++) {
                            if(j==0||j==n-1)
                                System.out.print(c);
                            else
                                System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
        sc.close();
    }

    //方法2：
    //这种方法由于四舍五入，按照int类型的计算，就不用区分奇偶数。
    // 就可以直接得到行数，行数为列数n加1然后除以2，不用分类，减少代码长度。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNext()) {
            n = sc.nextInt();
            //单个字符的输入好像不符合语法
            //先定义字符串输入
            //然后将第一个字符放入字符型数据拿到
            String str = sc.next();
            char c = str.charAt(0);
            //表示输出行数
            //例如 由于四舍五入，则偶数：n=10,行数就为11/2=5， 奇数：n=9时，行数为10/2=5
            for(int i=0;i<(n+1)/2;i++) {
                //第一行和最后一行输出
                if(i==0||i==(n+1)/2-1) {
                    for(int j=0;j<n;j++)
                        System.out.print(c);
                    //每行的换行
                    System.out.println();
                }
                else {
                    //中间行数的输出
                    for(int j=0;j<n;j++) {
                        if(j==0||j==n-1)
                            System.out.print(c);
                        else
                            System.out.print(" ");
                    }
                    //每行的换行
                    System.out.println();
                }
            }
            //每组之间的换行
            System.out.println();
        }
    }
}
