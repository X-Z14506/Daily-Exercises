package firstStage02;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-01
 * Time:16:25
 */

/*
题目描述
用筛选法求n以内的素数。筛选法求解过程为：将2~n之间的正整数放在数组内存储，将数组中2之后的所有能被2整除的数清0，再将3之后的所有能被3整除的数清0 ，以此类推，直到n为止。数组中不为0 的数即为素数。
输入描述:
多组输入，每行输入一个正整数（不大于100）。
输出描述:
针对每行输入的整数n，输出两行，第一行，输出n之内（包括n）的素数，用空格分隔，

第二行，输出数组中2之后0 的个数。每行输出后换行。

输入：20
输出：2 3 5 7 11 13 17 19
     11
 */



public class Main18 {
    //方法二：用list和map作为媒介
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        //把数填充到存储媒介
        for (int i = 2; i <= n ; i++) {
            map.put(i,i);
        }
        //素数替换为0
        for (int i = 2; i <= n ; i++) {
            for (Map.Entry<Integer, Integer> en : map.entrySet()) {
                Integer key = en.getKey();
                //只筛选i之后的
                if(key > i){
                    //取余为0
                    if((key%i) == 0){
                        en.setValue(0);
                    }
                }
            }
        }
        int count = 0;
        //获取结果
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            Integer value = en.getValue();
            if(value == 0){
                count++;
            }else{
                list.add(value);
            }

        }
        //输出结果
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println(count);
    }



    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] ints = new int[n-1];
            int m = 2;
            //给数组内放入2-n；
            for (int i = 0;i < ints.length;i++) {
                ints[i] = m++;
            }
            //打印出n以内的所有素数
            isPrime(n);

            int count = 0;
            for (int i = 0;i<ints.length;i++) {
                //先判断第i个元素是否为0，因为前面循环可能已经将其置为0，若不为0，则执行子循环
                if (ints[i]!=0) {
                    for (int j = i+1;j < ints.length;j++){
                        if (ints[j]%ints[i]==0 &&  ints[j] != 0) {
                            ints[j] = 0;
                            count ++;
                        }
                    }
                }

            }
            System.out.println(count);
            //System.out.println(Arrays.toString(ints));
        }

    }
    public static void isPrime(int n) {
        for (int i = 2;i <= n;i++) {
            boolean flag = false;
            for (int j = 2 ;j < i;j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
