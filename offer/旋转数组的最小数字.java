import java.util.Arrays;


public class 旋转数组的最小数字 {

    //此方法借助java本身API
    public int minNumberInRotateArray2(int [] array) {
        if(array==null || array.length==0) {
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }

    //此方法没用java自己的API
    public int minNumberInRotateArray(int [] array) {


        //若数组大小为0，返回0。
        if(array.length==0) {
            return 0;
        }
        int start = 0;
        int last = array.length-1;
        //// 最后剩下一个元素，即为答案
        while (start<last) {
            //每次进入循环，start或last会变化，因此mid也会变化
            int mid = (start+last)/2;
            if (array[mid] < array[last]) {
                last = mid;
            }else if (array[mid] > array[last]) {
                start = mid+1;
            }else {
                --last;
            }
        }
        return array[start];
    }
}
