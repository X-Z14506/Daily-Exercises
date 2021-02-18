package home.day01;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:14:16
 */
public class 转换成小写字母 {
    public static void main(String[] args) {
        String hello = toLowerCase("Hello");
        System.out.println(hello);
    }
    public static String toLowerCase(String str) {
        if(str== null || str.length()==0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length();i++) {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                sb.append(String.valueOf(c).toLowerCase());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
