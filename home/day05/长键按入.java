package home.day05;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:12:07
 */
public class 长键按入 {
    public static void main(String[] args) {
        String name = "rick";
        String typed = "kric";
        boolean longPressedName = isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0;//name的下标
        int j = 0;//typed的下标
        while (j < typed.length()) {
            //如果name[i]==typed[j]时，说明两个字符串存在一对匹配的字符，将i和j都后移
            if (i < name.length() && name.charAt(i)==typed.charAt(j)) {
                i++;
                j++;
            //若果type[j]==type[j-1],说明这个字符是多敲进来的，所以只用将j后移
            }else if (j>0 && typed.charAt(j)==typed.charAt(j-1)) {
                j++;
            //i=0，j=0时的字符都不一样，直接false；
            //或者i和j对应的下标字符不同且j和j-1的也不同，返回false
            }else {
                return false;
            }
        }
        return i==name.length();
    }
}
