package home.day03;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:19:04
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        if(x==1) {
            return true;
        }
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
