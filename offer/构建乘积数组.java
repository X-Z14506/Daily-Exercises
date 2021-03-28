/*
构建乘积数组
 */
public class Main11 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(multiply(a)));
    }
    public static int[] multiply(int[] A) {
        int[] a = new int[A.length];
        for (int i = 0;i < A.length;i++) {
            a[i] = 1;
            for (int j = 0;j < A.length;j++) {
                if (j!=i) {
                    a[i]*=A[j];
                }
            }
        }
        return a;
    }
}
