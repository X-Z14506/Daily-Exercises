public class 斐波那切数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //方法一：
            System.out.println(Fibonacci(n));
            //方法二：
            System.out.println(Fib(n));
        }
    }
    //方法一：递归
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2 && n > 0) {
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);

    }
    //方法二：循环,比递归效率高
    public static int Fib(int n) {
        if (n <= 2) {
            return 1;
        }
        int temp = 0;
        int fib1 = 1;
        int fib2 = 1;
        for (int i = 2;i < n;i++) {
            temp = fib1+fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        return fib2;
    }
}
