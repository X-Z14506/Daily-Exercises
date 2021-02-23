package offer;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-09
 * Time:21:52
 */

/*
最大连续子序列的和只可能从数组0到n-1中某个位置开始，我们可以遍历0到n-1个位置，
计算由这个位置开始的所有连续子序列中的和的最大值，最终求出全局最大值即可。
更详细的讲，就是计算从位置0开始的最大连续子序列的和，从位置1开始的最大连续子序列的和…。直到从位置n-1开始的最大连续子序列的和，
最后求出所有这些连续子序列和中的最大值，这个值就是答案。

时间复杂度：O(N2)
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] a = {1,-2,3,10,-4,7,2,-5};
        int ret = FindGreatestSumOfSubArray(a);
        System.out.println(ret);
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
        int maxSum = array[0]; //初始化最大值起初为第一个元素
        //求以第i个元素开始的所有子序列和
        for(int i = 0;i < array.length;i++) {
            int sum = 0;
            for(int j = i;j < array.length;j++) {
                //从位置 i开始计算从 i开始的最大连续子序列和的大小，如果大于 max，则更新 max。
                sum+=array[j];
                if(sum>maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
