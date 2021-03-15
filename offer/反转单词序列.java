/*
输入："nowcoder. a am I"
输出："I am a nowcoder."
 */

public class 反转单词序列 {
    public static void main(String[] args) {
        String s = "nowcoder. a am I";
        String s1 = ReverseSentence(s);
        System.out.println(s1);
    }
    public static String ReverseSentence(String str) {
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        if(strs.length == 0) {
            return str;
        }
        for(int i = strs.length-1;i >= 0;i--) {
            if (i==0) {
                sb.append(strs[i]);
            }else {
                sb.append(strs[i]).append(" ");
            }
        }
        return sb.toString();
    }
}
