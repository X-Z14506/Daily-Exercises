package offer;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-09
 * Time:23:06
 */

public class 统计一个数在升序数组中出现的次数 {
    public static void main(String[] args) {
        int[] a = {1,2,3,3,3,3,4,5};
        int i = GetNumberOfK(a, 3);
        System.out.println(i);
    }
    public static int GetNumberOfK(int[] nums, int K) {
        if(nums.length <= 0 || nums == null) return 0;
        //找到左边第一个k的下标
        int first = binarySearch(nums, K);
        //找到右边第一个k+1的下标
        int last = binarySearch(nums, K+1);
        //如果fist==nums.length或者nums[first]!=k说明没数组中不存在k这个数
        return (first == nums.length || nums[first] != K)? 0 : last - first;
    }
    private static int binarySearch(int[] nums, int K){
        int low = 0, high = nums.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= K) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
