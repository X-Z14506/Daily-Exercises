package first.Day18;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-12
 * Time:10:33
 */

/*
    题目描述：
        一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
        在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。

        给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
        输入描述：
        输入一个string型基因序列，和int型子串的长度。
        输出描述：
        找出GC比例最高的子串，如果有多个输出第一个的子串。

        示例：输入AACTGTGCGACCTGA
                5，
             输出GCACG

        思路：
        由题可知，A+C+G+T=n。因此，求G:C最高，即求在长度为n的字符串里出现G和C次数最多的子串。
        从输入字符串下标为0的位置开始，依次遍历n个字符，记录出现C或G的次数，
        如果高于之前记录的最大值，则更新最大出现次数和最大子串开始的下标(i)。
 */

public class Main {

    //方法一
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        List<String> list = new ArrayList<>();

        //StringBuilder sb = new StringBuilder(str);
        //遍历基因序列，找出所有子序列
        for (int i = 0; i < str.length() - n + 1; i++) {
            if (str.charAt(i) == 'G' || str.charAt(i) == 'C') {
                String s = str.substring(i, i + n);
                list.add(s);
            }
        }
        System.out.println(list);//[CTGTG, GTGCA, GCACG, CACGA, CGACC, GACCT, CCTGA]
        int preMax = 0;
        int preMaxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int max = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'G' || s.charAt(j) == 'C') {
                    max++;
                }
            }
            if (max > preMax) {
                preMax = max;
                preMaxIndex = i;
            }
        }
        System.out.println(str.substring(preMaxIndex, preMaxIndex + n));//CTGTG
        System.out.println(list.get(preMaxIndex));//GCACG
    }

       /* Map<String,Integer> map = new HashMap<>(list.size());
        //遍历List，将list存的东西放入map
        for (int i = 0; i < list.size();i++) {
            String s = list.get(i);
            int count = 0;
            for (int j = 0;j < s.length();j++) {
                if (s.charAt(j) == 'G' || s.charAt(j)=='C'){
                    count++;
                }
            }
            map.put(s,count);
        }
        System.out.println(map);*/

        //方法二：优化后
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            String str=sc.next();
            int n=sc.nextInt();
            int max=0;
            int maxIndex=0;
            //String res="";
            for(int i=0;i<=str.length()-n;i++){
                //String sub=str.substring(i,i+n);//截取子串
                int count=0;
                for(int j=i;j<i+n;j++){
                    if(str.charAt(j)=='C'||str.charAt(j)=='G'){
                        count++;
                    }
                    if(count>max){
                        max=count;
                        maxIndex=i;
                    }
                }
            }
            System.out.println(str.substring(maxIndex,maxIndex+n));
        }


}
