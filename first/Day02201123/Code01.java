package first.Day02201123;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-25
 * Time:19:42
 */

/*有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，
 则这两个数字组成一个逆序对，请设计一个高效的算法，计算给定数组中的逆序对个数。*/

public class Code01 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,0};
        int n = 8;
        System.out.println(count(A, n));//7
    }
    public static int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n;i++) {
            for (int j = i+1;j < n;j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
