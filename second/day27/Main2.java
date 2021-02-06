package second.day27;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-03
 * Time:11:58
 */

/*
查找兄弟单词

输入描述:
先输入字典中单词的个数，再输入n个单词作为字典单词。
输入一个单词，查找其在字典中兄弟单词的个数
再输入数字n

输出描述:
根据输入，输出查找到的兄弟单词的个数

示例
输入
3 abc bca cab abc 1
输出
2
bca

输出的结果，有一个坑！（结果要进行判断，有还是没有兄弟单词，没有就不输出！结果是2行数据）
我们来分析一下，首先，题目要求输入 3 abc bca cab abc 1 ，
其中3表示后边会跟着输入 3 个单词，而这3个单词需要存进字典。也就是 abc bca cab 这 3 个单词。
紧接着第 4 个单词 abc，是第二阶段了。这个单词表示是要查找的单词。需要从 字典排序后的兄弟单词列表查找。
最后的那个数字，是兄弟单词列表的一个序号，你可以理解为 List 的下标 + 1（因为List 的下标从0开始，而这个数字从 1 开始）。

我的解决方案是：
创建一个 List 作为兄弟单词列表，然后从将输入的那个字符串按照空格切分，遍历并判断是不是兄弟单词，是就存进列表。
然后，对兄弟单词列表进行排序（字典顺序，即字符串默认的排序方式）。
最终打印结果。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] words = sc.nextLine().split(" ");
            //要查的单词
            String word =  words[words.length-2];
            //单词列表
            List<String> list = new ArrayList<>();
            for (int i = 1;i <= Integer.parseInt(words[0]);i++) {
                if (isBrother(words[i],word)) {
                    list.add(words[i]);
                }
            }
           Collections.sort(list);
            System.out.println(list.size());
            int index = Integer.parseInt(words[words.length-1]);
            if (!list.isEmpty() && index<=list.size()) {
                System.out.println(list.get(index-1));
            }
        }
    }

    private static boolean isBrother(String word, String word1) {
        char[] chars = word.toCharArray();
        char[] chars1 = word1.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return new String(chars).equals(new String(chars1)) && !word.equals(word1);
    }
}
