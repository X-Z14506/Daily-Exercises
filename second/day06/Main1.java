package second.day06;

import org.omg.PortableInterceptor.INACTIVE;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-09
 * Time:19:51
 */
/*
小易的升级之路
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(strings1[0]);
            int init = Integer.parseInt(strings1[1]);
            String[] strings2 = sc.nextLine().split(" ");
            for (int i = 0;i < n;i++) {
                int e = Integer.parseInt(strings2[i]);
                if (e <= init) {
                    init+=e;
                }
                if (e > init) {
                    //求最大公约数
                    int temp = init;
                    while (temp>1) {
                        //找到两个数最小值，如果能同时被两个数整除，这个即为最大公约数
                        if (init%temp==0 && e%temp==0) {
                            init+=temp;
                            break;
                        }
                        //如果不能，往下递减，直到找到为止
                        temp--;
                    }
                }
            }
            System.out.println(init);
        }
    }
}
