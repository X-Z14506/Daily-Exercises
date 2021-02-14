package firstStage02;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-02
 * Time:22:18
 */

/*
输入两个升序排列的序列，将两个序列合并为一个有序序列并输出。

 输入：   5 6
         1 3 7 9 22
         2 8 10 17 33 44

输出：1 2 3 7 8 9 10 17 22 33 44
 */
public class Main30 {

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            //把合并后的数组都放到第一个数组里
            int[] arr1 = new int[n+m];
            int[] arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }
            mergeSort(arr1,arr2,n-1,m-1);
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < arr1.length; i++) {
                res.append(arr1[i]);
                if (i!=arr1.length-1)res.append(" ");
            }
            System.out.println(res.toString());
        }
    }
    //归并排序，合并数组1和数组2
    public static void mergeSort(int[] arr1,int[] arr2,int a,int b){
        if (arr2 == null || arr2.length == 0){
            return;
        }
        int tail = arr1.length-1;
        while(a>=0 && b >=0){
            if (arr1[a]>arr2[b]){
                arr1[tail--] = arr1[a--];
            }else{
                arr1[tail--] = arr2[b--];
            }
        }
        while(a>=0){
            arr1[tail--] = arr1[a--];
        }
        while(b>=0){
            arr1[tail--] = arr2[b--];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings1 = reader.readLine().split(" ");
        String[] strings2 = reader.readLine().split(" ");
        String[] strings3 = reader.readLine().split(" ");
        int n = Integer.parseInt(strings1[0]);
        int m = Integer.parseInt(strings1[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < strings2.length;i++) {
            list.add(Integer.parseInt(strings2[i]));
        }
        for (int i = 0;i < strings3.length;i++) {
            list.add(Integer.parseInt(strings3[i]));
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.print(i+" ");
        }
    }
}
