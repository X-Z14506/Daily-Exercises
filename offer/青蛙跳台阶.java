public class 青蛙跳台阶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(JumpFloor(n));
            System.out.println(JumpFloor2(n));
        }
    }

    private static int JumpFloor2(int target) {
        if (target <= 3 ) {
            return target;
        }
        int temp = 0;
        int fib1 = 2;
        int fib2 = 3;
        for (int i = 3;i < target;i++) {
            temp = fib1+fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        return temp;
    }

    public static int JumpFloor(int target) {
        if (target <= 3) {
            return target;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }

}
