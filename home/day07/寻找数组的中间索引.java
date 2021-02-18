package home.day07;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:15:57
 */
/*
输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
中心索引是 3 。
左侧数之和 (1 + 7 + 3 = 11)，
右侧数之和 (5 + 6 = 11) ，二者相等。

输入：nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心索引。

输入：nums = [2, 1, -1]
输出：0
解释：
中心索引是 0 。
索引 0 左侧不存在元素，视作和为 0 ；
右侧数之和为 1 + (-1) = 0 ，二者相等。

 */
public class 寻找数组的中间索引 {
    public static void main(String[] args) {
        int[] a1 = {1, 7, 3, 6, 5, 6};
        int[] a2 = {1, 2, 3};
        int[] a3 = {2, 1, -1};
        System.out.println(pivotIndex(a1));
        System.out.println(pivotIndex(a2));
        System.out.println(pivotIndex(a3));
    }
    public static int pivotIndex(int[] nums) {
        //左边和*2+中间索引的值 = 总和
        //1.先求总和
        int sum = 0;
        for(int i : nums) {
            sum+=i;
        }
        //2.求左边和
        int leftSum = 0;
        for(int i = 0;i < nums.length;i++) {
            if(2*leftSum + nums[i] == sum) {
                return i;
            }
            leftSum += nums[i];
        }
        //走到这说明没有找到中间索引
        return -1;
    }
}
