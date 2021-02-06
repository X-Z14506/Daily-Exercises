package second.day02;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-04
 * Time:21:05
 */


public class Main1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,3};
        int n = 6;
        Main1 main1 = new Main1();
        int ret = main1.getValue(arr,n);
        System.out.println(ret);
    }
    public int getValue(int[] gifts, int n) {
        int maxCount = 0;
        int max = 0;
        for (int i = 0;i < gifts.length;i++) {
            int k = gifts[i];
            int count = 0;
            for (int j = 0;j < gifts.length;j++) {
                if (gifts[j] == k) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                max = gifts[i];
            }
        }
        if (maxCount > (n/2)) {
            return max;
        }else {
            return 0;
        }
    }
}
