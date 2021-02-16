package firstStage03;

import sun.plugin2.gluegen.runtime.BufferFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-07
 * Time:9:17
 */
/*
小乐乐与字符串
如“ABC”的子串有“A”、“B”、“C”、“AB”、“AC”、“BC”、“ABC”。

输入：
CCHNCHN
输出：7

输入：
CCHNCHNCHNCHN
输出：30

 */

//统计C的数量，每加一个C，后面所有的H都会跟着在原有的子串数基础上加一个子串数，同理，每加一个H，后面所有的N都会跟着在原有子串数的基础上加一个子串
//  即H只需要关注前面C的数量，N只需要关注前面H的数量 ,最终输出N能为几个子串所用，即为子串数量
//  方便观察起见，为其编号,实际并无编号
//  如：C1C2HN             就有两种子串数  C1HN和C2HN
//     C1C2H1H2N          就有四种子串数  C1H1N C1H2N C2H1N C2H2N
//     C1C2H1N1C3H2N2     就有七种子串数  C1H1N1 C1H1N2 C1H2N2 C2H1N1 C2H1N2 C2H2N2 C3H2N2

public class Main16 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] chars = s.toCharArray();
        long c = 0; long h = 0; long n = 0;
        for (int i =0;i < chars.length;i++) {
            if (chars[i] == 'C') {
                c++;
            }else if (chars[i]=='H'){
                h = h+c;
            }else if (chars[i] == 'N'){
                n = n+h;
            }
        }
        System.out.println(n);
    }
}
