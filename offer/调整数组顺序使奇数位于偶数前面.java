import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int[] ints = reOrderArray(a);
        System.out.println(Arrays.toString(ints));
       /* reOrderArray(a);
        System.out.println(Arrays.toString(a));*/
    }
    public static int[] reOrderArray(int [] array) {
        if (array == null || array.length < 1) {
            return null;
        }
        int[] newArr = new int[array.length];
        int odd = 0;
        int even = 0;
        for(int i =0;i<array.length;i++) {
            if(array[i]%2==0){
                even++;
            }else{
                odd++;
            }
        }
        int left = 0;
        int right = odd;
        for(int i =0;i < array.length;i++) {
            if(array[i]%2!=0){
                newArr[left++]=array[i];
            }else{
                newArr[right++]=array[i];
            }
        }
        for(int i = 0;i < array.length;i++) {
            array[i] = newArr[i];
        }
        return array;
    }
}
