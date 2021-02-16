package firstStage03;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-06
 * Time:23:40
 */

/*
小乐乐与序列
 */

public class Main15 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int[] a = new int[n];
        for (int i = 0;i < n;i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(a);
        System.out.print(a[0]+" ");
        for (int i = 1;i < n;i++) {
            if (a[i-1]!=a[i]) {
                sb.append(a[i]+" ");
            }
        }
        System.out.print(sb.toString().trim());
       /* List<Integer> list1 = new ArrayList<>();
        for (int i = 0;i<list.size();i++) {
            if (!list1.contains(list.get(i))) {
                list1.add(list.get(i));
                System.out.print(list.get(i)+" ");
            }
        }*/
    }
}
