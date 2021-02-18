package home.day10;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-16
 * Time:14:48
 */
public class Tes {
    public static void main(String[] args) {
        int left = 0;
        int right = 6;
        while (left<right) {
           int mid = (right+left+1)/2;
            System.out.println(left+" "+mid+" "+right);
           left++;
           right--;

        }
    }
}
