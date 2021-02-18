package home.day06;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:13:05
 */
public class 仅仅反转字母 {
    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        String s1 = reverseOnlyLetters(s);
        System.out.println(s1);
    }
    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0;
        int right = S.length()-1;
        while(left<right) {
            //从左往右找到第一个是字符的
            while (left<right &&!Character.isLetter(chars[left])) {
                left++;
            }
            //从右往左找到第一个是字符的
            while (left<right && !Character.isLetter(chars[right])) {
                right--;
            }
            //程序走到这里说明left和right对应的字符都是字母
            swap(chars,left,right);
            left++;
            right--;
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
}
