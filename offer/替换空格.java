package offer;

import javax.print.DocFlavor;
import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-11
 * Time:17:57
 */
/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("HelloWorld  ");
        String s1 = replaceSpace(s);
        System.out.println(s1);
        StringBuffer s2  = new StringBuffer("Hello   World");
        String s3 = replaceSpace(s2);
        System.out.println(s3);

    }
    /*
    /*
        问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换！
        问题2：在当前字符串替换，怎么替换才更有效率（不考虑java里现有的replace方法）。
            从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
            从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
    */
    public static String replaceSpace(StringBuffer str) {
        //先计算空格数量
        int spacenum = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexOld = str.length()-1; //indexOld为为替换前的str下标
        int newLength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度
        int indexNew = newLength-1;//indexNew为把空格替换为%20后的str下标
        str.setLength(newLength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        for(;indexOld>=0 && indexOld<newLength;--indexOld){
            if(str.charAt(indexOld) == ' '){  //
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            }else{
                str.setCharAt(indexNew--, str.charAt(indexOld));
            }
        }
        return str.toString();
    }
}
