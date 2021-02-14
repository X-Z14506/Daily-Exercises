package firstStage02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-02
 * Time:21:44
 */
/*
序列中删除指定数字（所有）

输入：6
     1 2 3 4 5 9
     4

输出：1 2 3 5 9

输入：10
     1 1 2 3 4 4 5 4 9 4
     4
输出：1 1 2 3 5 9
 */

public class Main28 {
    //遍历数组，不需要删除的直接输出，需要删除的元素，continue，跳过输出语句
    public static void main2(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] ns = new int[n];
        String[] str = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            ns[i] = Integer.parseInt(str[i]);
        }

        int s = Integer.parseInt(bf.readLine());//要删除的整数
        for(int i = 0; i < ns.length; i++){
            if(ns[i] == s){
                continue;
                //当条件 ns[i]==s 的时候执行 continue 语句，
                //continue 语句会终止本次循环，循环体中 continue 之后的语句将不再执行，
                //接着进行下次循环，所以输出结果中没有 s。
                //也就相当于删除指定数字
            }
            System.out.print(ns[i] + " ");
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = reader.readLine().split(" ");
        int m = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0;i < strings.length;i++) {
            int k = Integer.parseInt(strings[i]);
            //如果k不为要删除的数，放入ints数组
            if ( k != m) {
                list.add(k);
            }
        }
        for (int i : list) {
            System.out.print(i+" ");
        }
    }
}
