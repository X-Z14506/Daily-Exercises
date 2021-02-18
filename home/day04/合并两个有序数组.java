package home.day04;

import java.util.Arrays;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:19:37
 */
public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 4;
        int n = 3;
        System.out.println(Arrays.toString(nums1));
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m-1;//（指针）nums1数组最后一个元素的下标
        n = n-1;//（指针）nums2数组最后一个元素的下标
        int i = m+n+1;
        //两个排序数组从后向前遍历，从大到小依次从nums1数组的最后一个位置往前放
        while (n>=0) {//当n小于0时，说明已经将nums2数组内的元素放完了，剩下的原有的nums1数组的元素本就有序
            //m下标元素大于n下标元素
            if (m>=0 && nums1[m]>nums2[n]) {
                nums1[i--] = nums1[m--];
            }else {//说明n下标元素大于m下标元素 或者 nums1的元素全部放完，剩下的nums2的元素依次放入即可
                nums1[i--] = nums2[n--];
            }
        }
    }
}
