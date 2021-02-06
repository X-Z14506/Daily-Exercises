package first.Day01201122;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-24
 * Time:19:00
 */

public class Main {

    public static void main(String[] args) {
        int[] a = {1,3,5,2,2};
        System.out.println(findKth(a, 5, 3));//2
    }
    /*有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

    给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
    测试样例：[1,3,5,2,2],5,3
        返回：2*/
    public static int findKth(int[] a, int n, int K) {
        return find(0,n-1,a,K);
    }
    public static int find(int left,int right, int[] arr,int k) {
        int ret = partation(left,right,arr);
        if (ret+1>k) {
            return find(left,ret-1,arr,k);
        }else if (ret+1<k) {
            return find(ret+1,right,arr,k);
        }else {
            return arr[ret];
        }
    }
    public static int partation(int left,int right,int[] arr) {
        int temp = arr[left];
        while (left < right) {
            //设定arr[left]为基准，将小于基准的放在基准右边,大于基准的放在左边
            while (left < right && arr[right] <= temp) {
                right--;
            }
            if (left>=right) {
                break;
            }else {
                arr[left] = arr[right];//将大于基准的值放在基准左边
            }
            while (left < right && arr[left] >= temp) {
                left++;
            }
            if (left >= right) {
                break;
            }else {
                arr[right] = arr[left];//将小于基准的值放在基准右边
            }
        }
        //将基准最后放再最后一个空位置，这个空位置的下标即为基准的下标
        arr[left] = temp;
        return left;
    }
}


//public class Main {
//    public int findKth(int[] a, int n, int K) {
//        return  help(0,n-1,a,K);
//    }
//    private int help(int left, int right, int[] a, int k) {
//        int m=partation(left,right,a);
//        if(m+1 > k){
//            return  help(left,m-1,a,k);
//        }else if(m+1<k){
//            return help(m+1,right,a,k);
//        }else {
//            return a[m];
//        }
//    }
//
//    private int partation(int left, int right, int[] a) {
//        int pivotValue =a[left];
//        while (left<right){
//            while (left<right && a[right]<=pivotValue){
//                right--;
//            }
//            a[left]=a[right];
//            while (left<right && a[left]>=pivotValue){
//                left++;
//            }
//            a[right]=a[left];
//        }
//        a[left]=pivotValue;
//        return left;
//    }
//}
