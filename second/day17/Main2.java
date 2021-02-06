package second.day17;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-21
 * Time:23:23
 */

/*
风口的猪-中国牛市
 */
public class Main2 {
    public static void main(String[] args) {
        int[] arr = {3,8,5,1,7,8};
        System.out.println(calculateMax(arr));
    }
    public static int calculateMax(int[] prices) {
        int len = prices.length;
        int[] ints = new int[len];
        ints[0]=0;
        int minIndex = 0;//最小值的下标
        //从左到右，求收益最大值放入ints中
        for (int i = 1;i<len;i++) {
            if (prices[i]>prices[i-1]) {
                ints[i] = Math.max(prices[i]-prices[minIndex],ints[i-1]);//动态规划，利用前面的值填写后面的值
            }else {
                ints[i] = ints[i-1];
                if (prices[i]<prices[minIndex]) {
                    minIndex = i;
                }
            }
        }
        //从右到左，求收益最大值
        int[] ints1 = new int[len];
        ints1[len-1]=0;//最左边的初始值赋为0
        int maxIndex = len-1;//最大值的下标
        for (int i = len-2;i>=0;i--) {
            if (prices[i]<prices[i+1]){
                ints1[i] = Math.max(prices[maxIndex]-prices[i],ints1[i+1]);
            }else {
                ints1[i] = ints[i+1];
                if (prices[maxIndex]<prices[i]) {
                    maxIndex = i;
                }
            }
        }
        //根据输入ints和ints1求解整个郭恒的最大值
        int ret = 0;
        for (int i = 0;i<len;i++) {
            ret = Math.max(ints[i]+ints1[i],ret);
        }
        return ret;
    }
}
