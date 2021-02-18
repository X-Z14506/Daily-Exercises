package home.day11;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-16
 * Time:18:38
 */
public class 压缩字符串 {
    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(chars);
        System.out.println(compress);
    }
    public static int compress(char[] chars) {
        int endIndex = 0;//指向输出答案的结尾。
        int beginIndex = 0;//指向当前读到连续字符串的起始位置。
        for (int i = 0;i < chars.length;i++){
            //当读到最后一个字符，或者下一个下一个字符与当前不同时，则到达连续区块的结尾。
            if (i+1==chars.length ||chars[i+1] != chars[i]) {
                chars[endIndex++] = chars[beginIndex];
                if (i > beginIndex) {//说明有压缩的字符，即重复的字符,i-beginIndex即为需要被压缩字符的长度
                    for (char c : ((i-beginIndex+1)+"").toCharArray()) {
                        chars[endIndex++] = c;
                    }
                }
                beginIndex = i+1;
            }
        }
        return endIndex;
    }
}
