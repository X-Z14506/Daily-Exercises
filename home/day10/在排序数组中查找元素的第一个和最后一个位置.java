package home.day10;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-16
 * Time:14:54
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ints = searchRange(nums, 8);
        System.out.println(Arrays.toString(ints));
        int[] ints1 = search(nums,8);
        System.out.println(Arrays.toString(ints1));
    }
    //暴力解法，直接遍历
    public static int[] search(int[] nums,int t) {
        int[] arr = {-1,-1};
        if(nums==null || nums.length==0) {
            return arr;
        }
        if(nums.length==1 && nums[0]==t) {
            arr[0]=0;
            arr[1]=0;
            return arr;
        }
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] == t && arr[0]==-1) {
                arr[0] = i;
                continue;
            }
            if(nums[i] == t && arr[0] != -1) {
                arr[1] = i;
            }
        }
        if(arr[0]!=-1 && arr[1]==-1) {
            arr[1]=arr[0];
        }
        return arr;
    }
    //二分查找法
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len==0) {
            return new int[]{-1,-1};
        }

        int firstIndex = findFirstIndex(nums,target);
        if (firstIndex == -1) {
            return new int[]{-1,-1};
        }

        int lastIndex = findLastIndex(nums,target);
        return new int[]{firstIndex,lastIndex};
    }

    private static int findLastIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<right) {
            mid = (left+right + 1)/2;
            //中间元素如果小于目标值，则最后一个目标值一定在mid的右边
            if (nums[mid] < target) {
                left = mid+1;
            }
            //中间元素如果等于目标值，则最后一个目标值一定在mid的左边（包含mid）
            else if (nums[mid] == target) {
                left = mid;
            }
            //中间元素大于目标值，则最后一个目标值一定在mid左边
            else if (nums[mid]>target) {
                right = mid-1;
            }
        }
        if (nums[left] == target) {
            return left;
        }else {
            return -1;
        }
    }

    private static int findFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left<right) {
            mid = (left+right)/2;
            //中间元素如果小于目标值，则第一个目标值一定在mid的右边
            if (nums[mid] < target) {
                left = mid+1;
            }
            //中间元素如果等于目标值，则第一个目标值一定在mid的左边（包含mid）
            else if (nums[mid] == target) {
                right = mid;
            }
            //中间元素大于目标值，则第一个目标值一定在mid左边
            else if (nums[mid]>target) {
                right = mid-1;
            }
        }
        if (nums[left] == target) {
            return left;
        }else {
            return -1;
        }
    }
}
