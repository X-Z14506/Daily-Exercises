




public class Main25 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //将读到的一行输出
        System.out.println(input);
    }
    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        System.out.println();
        for (int i = 0;i < strings.length;i++) {
            System.out.print(strings[i]+" ");
        }
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
题目描述
输入NxM矩阵，矩阵元素均为整数，计算其中大于零的元素之和。

输入描述:
第一行为N M(N: 矩阵行数；M: 矩阵列数,且M,N<=10)，接下来的N行为矩阵各行。
输出描述:
一行，其中大于零的元素之和。

输入：

3 3
2 3 4
-5 -9 -7
0 8 -4

输出：17
 */
public class Main24 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings1 = reader.readLine().split(" ");
        int M = Integer.parseInt(strings1[0]);
        int N = Integer.parseInt(strings1[1]);
        int sum = 0;
        for (int i = 0;i < M;i++) {
            String[] strings = reader.readLine().split(" ");
            for (int j = 0;j < strings.length;j++) {
                if (Integer.parseInt(strings[j]) > 0) {
                    sum+=Integer.parseInt(strings[j]);
                }
            }
        }
        System.out.println(sum);
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
题目描述

有一个有序数字序列，从小到大排序，将一个新输入的数插入到序列中，保证插入新数后，序列仍然是升序。
输入描述:
共三行，
第一行输入一个整数(0≤N≤50)。
第二行输入N个升序排列的整数，输入用空格分隔的N个整数。
第三行输入想要进行插入的一个整数。
输出描述:
输出为一行，N+1个有序排列的整数。

输入：7
    5 30 40 50 60 70 90
    20

输出：5 20 30 40 50 60 70 90

 */
public class Main23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] ints = new int[num+1];
        for (int i = 0;i< num;i++) {
            ints[i] = scanner.nextInt();
        }
        int num2 = scanner.nextInt();
        ints[num] = num2;
        Arrays.sort(ints);
        //System.out.println(Arrays.toString(ints));
        for (int i = 0;i<ints.length;i++) {
            System.out.print(ints[i]+" ");
        }
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*

        题目描述
        输入n科成绩（浮点数表示），统计其中的最高分，最低分以及平均分。

        输入描述:
        两行，

        第1行，正整数n（1≤n≤100）

        第2行，n科成绩（范围0.0~100.0），用空格分隔。
        输出描述:
        输出一行，三个浮点数，分别表示，最高分，最低分以及平均分（小数点后保留2位），用空格分隔。

        输入：5
             99.5 100.0 22.0 60.0 88.5

        输出：100.00 22.00 74.00

 */


public class Main22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] s = new double[n];
        for (int i = 0; i < n;i++) {
            double score = Double.parseDouble(scanner.next());
            s[i] = score;
        }
        double sum = 0;
        double max = s[s.length-1];
        double min = s[0];
        for (int i = 0; i < s.length;i++) {
            sum += s[i];
        }
        double avg = sum/s.length;
        System.out.println(String.format("%.2f",max)+" "+String.format("%.2f",min)+" "+String.format("%.2f",avg));
    }
}





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*

题目描述
今年是2019年，KiKi想知道1~2019中有多少个包含数字9的数。包含数字的数是指有某一位是“9”的数，例如“2019”、“199”等。

 */
public class Main21{
    public static void main(String[] args) {
        String s = null;
        int count = 0;
        for(int i = 1;i<=2019;i++) {
             s = String.valueOf(i);
            for(int j = 0; j < s.length();j++) {
                if (s.charAt(j)=='9') {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        double a = Double.parseDouble(strings[0]);
        double b = Double.parseDouble(strings[1]);
        double c = Double.parseDouble(strings[2]);
        double d1 = max3(a+b,b,c);
        double d2 = max3(a,b+c,c);
        double d3 = max3(a,b,b+c);
        System.out.println(String.format("%.2f",d1/(d2+d3)));

    }

    private static double max3(double a,double b,double c) {
        double max =  Math.max(Math.max(a,b),c);

        return max;
    }
}




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
算一下有多少同学被叫家长。
输入：
3
80 100 90
40 70 65
20 84 93

输出：
1

 */

public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0;i < n;i++) {
            String[] s = sc.nextLine().split(" ");
            double score = avgScore(s);
            if (score < 60 ) {
                count++;
            }
        }
        System.out.println(count);
    }
    static double avgScore(String[] s) {
        int[] ints = new int[s.length];
        double avg = 0;
        double sum = 0;
        for (int i = 0;i< s.length;i++) {
            ints[i] = Integer.parseInt(s[i]);
            sum+=ints[i];
        }
        avg = sum/3;
        return avg;
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
小乐乐输入百分制成绩，他想将成绩转换成等级制。
转换规则为：90-100为’A’，80-89为’B’，70-79为’C’，60-69为’D’，59以下为’E’。如果输入的成绩不在0-100之间，输出’F’。
 */
public class Main18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int score = sc.nextInt();
            System.out.println(change(score));
        }
    }
    static char change(int score){
        if (score>=90 && score<=100) {
            return 'A';
        }else if (score>=80 && score <= 89) {
            return 'B';
        }else if (score>=70 && score <= 79) {
            return 'C';
        }else if (score>=60 && score <= 69) {
            return 'D';
        }else if (score>=0 && score <= 59) {
            return 'E';
        }else {
            return 'F';
        }
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
小乐乐与二段数
 */
public class Main17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int temp;
        while (true) {
            temp = sc.nextInt();
            if (temp == 0) {
                break;
            } else {
                arr.add(temp);
            }
        }
        for (Integer o : arr) {
            printMinDoubleNumber(o);
        }
    }

    public static void printMinDoubleNumber(int number) {
        long temp = number;
        while (true) {
            if (isMinDoubleNumber(temp)) {
                System.out.println(number + ": " + temp);
                return;
            }
            temp += number;
        }
    }

    public static boolean isMinDoubleNumber(long number) {
        if (number < 10) {
            return false;
        }
        long temp;
        long preTemp = number % 10;
        int count = 1;
        number /= 10;
        while (number > 0) {
            if (count > 2) return false;
            temp = number % 10;
            if (temp != preTemp) {
                count++;
            }
            preTemp = temp;
            number /= 10;
        }

        if (count == 2) {
            return true;
        }else {
            return false;
        }
    }
}




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
小乐乐与字符串
如“ABC”的子串有“A”、“B”、“C”、“AB”、“AC”、“BC”、“ABC”。

输入：
CCHNCHN
输出：7

输入：
CCHNCHNCHNCHN
输出：30

 */

//统计C的数量，每加一个C，后面所有的H都会跟着在原有的子串数基础上加一个子串数，同理，每加一个H，后面所有的N都会跟着在原有子串数的基础上加一个子串
//  即H只需要关注前面C的数量，N只需要关注前面H的数量 ,最终输出N能为几个子串所用，即为子串数量
//  方便观察起见，为其编号,实际并无编号
//  如：C1C2HN             就有两种子串数  C1HN和C2HN
//     C1C2H1H2N          就有四种子串数  C1H1N C1H2N C2H1N C2H2N
//     C1C2H1N1C3H2N2     就有七种子串数  C1H1N1 C1H1N2 C1H2N2 C2H1N1 C2H1N2 C2H2N2 C3H2N2

public class Main16 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] chars = s.toCharArray();
        long c = 0; long h = 0; long n = 0;
        for (int i =0;i < chars.length;i++) {
            if (chars[i] == 'C') {
                c++;
            }else if (chars[i]=='H'){
                h = h+c;
            }else if (chars[i] == 'N'){
                n = n+h;
            }
        }
        System.out.println(n);
    }
}




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
小乐乐与序列
 */

public class Main15 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int[] a = new int[n];
        for (int i = 0;i < n;i++) {
            a[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(a);
        System.out.print(a[0]+" ");
        for (int i = 1;i < n;i++) {
            if (a[i-1]!=a[i]) {
                sb.append(a[i]+" ");
            }
        }
        System.out.print(sb.toString().trim());
       /* List<Integer> list1 = new ArrayList<>();
        for (int i = 0;i<list.size();i++) {
            if (!list1.contains(list.get(i))) {
                list1.add(list.get(i));
                System.out.print(list.get(i)+" ");
            }
        }*/
    }
}




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
青蛙跳台阶
 */
public class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n<=3) {
                System.out.println(n);
            }else {
                int ret = fib(n);
                System.out.println(ret);
            }
        }
    }
    static int fib(int n) {
        if (n<4) {
            return n;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }

    public static void main1(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(1);
        }else if(n == 2){
            System.out.println(2);
        }else{
            int a = 1;
            int b = 2;
            int c;
            for(int i = 3; i <= n; i++){
                c = a + b;
                a = b;
                b = c;
            }
            System.out.print(b);
        }
    }
}





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
想把每位的数变成0或1。如果某一位是奇数，就把它变成1，如果是偶数，那么就把它变成0
输入：22222
输出：0

输入：123
输出：101
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            for (int i = 0;i < c.length;i++) {
                if (c[i]%2==0) {
                    c[i]='0';
                }else {
                    c[i]='1';
                }
            }
            String newStr = new String(c);
            int a = Integer.parseInt(newStr);
            System.out.println(a);
        }
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
对于每组输入，输出一个正整数，为n和m的最大公约数与最小公倍数之和。

输入：10 20
输出：30

输入：15 20
输出：65


最大公约数和最小公倍数的关系：假设x和y的最大公约数是m,最小公倍数是n,则xy=mn

 */

public class Main12 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] s = bf.readLine().split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);
        System.out.print(Yue(n,m)+ Bei(n,m));
    }
    public static long Yue(long x,long y){
        while(x!=0){
            long temp = y%x;
            y = x;
            x = temp;
        }
        return y;
    }

    //最大公约数和最小公倍数的关系：假设x和y的最大公约数是m,最小公倍数是n,则xy=mn
    public static long Bei(long x,long y){
        long s = Yue(x,y);
        return x*y/s;
    }



    //效率太低，速度太慢不行
    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        long n = Integer.parseInt(strings[0]);
        long m = Integer.parseInt(strings[1]);

        //求两个数的最大公约数
        long min = Math.min(n,m);
        long x = 1;
        for (long i = min;i>0;i--) {
            if (n%i==0 && m%i==0) {
                x=i;
                //System.out.println("最大公约数为："+i);
                break;
            }
        }

        //求两个数的最小公倍数
        long max = Math.max(n,m);
        long y = m*n;
        for (long i = max;i <= m*n;i++) {
            if (i%n==0 && i%m==0 ) {
                y = i;
                //System.out.println("最小公倍数为："+i);
                break;
            }
        }
        long sum = x+y;
        System.out.println(sum);

    }
}




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n<12) {
            System.out.println(2);
            return;
        }
        System.out.println((n/12)*4+2);
       /* if (n%12==0) {
            System.out.println((n/12)*4+2);
        }*/
        //System.out.println(2+((n/12)+1)*4);
    }
}




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
小乐乐定闹钟

输入描述:
输入现在的时刻以及要睡的时长k（单位：minute），中间用空格分开。

输入格式：hour:minute k(如hour或minute的值为1，输入为1，而不是01)

(0 ≤ hour ≤ 23，0 ≤ minute ≤ 59，1 ≤ k ≤ 109)

输出描述:
对于每组输入，输出闹钟应该设定的时刻，输出格式为标准时刻表示法（即时和分都是由两位表示，位数不够用前导0补齐）。

输入：
0:0 100
输出：
01:40

输入：
1:0 200
输出：
04:20

 */
public class Main10{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //先按空格将读入的一行分成两部分，在从第一部分中按冒号将第一部分分成时和分
        String[] strings1 = reader.readLine().split(" ");
        String[] strings2 = strings1[0].split(":");

        //当前时间的小时数
        int curH = Integer.parseInt(strings2[0]);
        //当前时间的分钟数
        int curM = Integer.parseInt(strings2[1]);
        //定时时间
        int timer = Integer.parseInt(strings1[1]);
        //定时的小时数
        int hours = timer/60;
        //定时的分钟数
        int minutes = timer%60;

        //定时时间到的时间的小时数
        curH = (curH+hours+(curM+minutes)/60)%24;
        //定时时间到的时间的分钟数
        curM = (curM+minutes)%60;
        System.out.println(String.format("%02d",curH)+":"+ String.format("%02d",curM));
    }



    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            String[] time = s[0].split(":");
            int sleep = Integer.parseInt(s[1]);
            int hour = sleep/60;
            int minute = sleep%60;
            int curH = Integer.parseInt(time[0]);
            int curM = Integer.parseInt(time[1]);
            curH = (curH+hour+(minute+curM)/60)%24;
            curM = (curM+minute)%60;
            System.out.println(String.format("%02d",curH)+":"+ String.format("%02d",curM));
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  data = sc.nextLine();
        int p = data.indexOf(":");
        int q = data.indexOf(" ");

        int h = Integer.parseInt(data.substring(0, p));
        int m = Integer.parseInt(data.substring(p+1, q));
        int k = Integer.parseInt(data.substring(q+1));

        //先将总小时数和总分钟数算出来，让该进位的进位
        m = m + k % 60;
        h = h + k / 60 + m / 60;

        //在求出总小时相对于24小时制为几点，总分中数相对于60为多少分
        m = m % 60;
        h = h % 24;

        String h1, m1;
        if (h < 10){
            h1 = "0" + h;
        }else {
            h1 = h + "";
        }

        if (m < 10){
            m1 = "0" + m;
        }else {
            m1 = m + "";
        }

        System.out.println(h1 + ":" + m1);
    }
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
十进制转六进制
 */
public class Main09 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(Integer.toString(sc.nextInt(),6));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(Integer.toString(Integer.parseInt(reader.readLine()),16));
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
井字棋
KiKi和BoBo玩 “井”字棋。也就是在九宫格中，只要任意行、列，或者任意对角线上面出现三个连续相同的棋子，就能获胜。请根据棋盘状态，判断当前输赢。

输入描述:
三行三列的字符元素，代表棋盘状态，字符元素用空格分开，代表当前棋盘，其中元素为K代表KiKi玩家的棋子，为O表示没有棋子，为B代表BoBo玩家的棋子。
输出描述:
如果KiKi获胜，输出“KiKi wins!”；
如果BoBo获胜，输出“BoBo wins!”；
如果没有获胜，输出“No winner!”。

输入:
K O B
O K B
B O K

输出：
KiKi wins!

 */
public class Main08 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char[][] strings = new char[3][3];
        for (int i =0;i < 3;i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0;j < 3;j++) {
                strings[i][j] = s[j].charAt(0);
            }
        }

      /*  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] input = new char[3][3];

        for(int i=0; i<3; i++){
            String row = br.readLine();
            for(int j=0; j<3; j++){
                input[i][j] = row.charAt(2*j);
            }
        }
*/
        boolean KKWin = false;
        boolean BBWin = false;
        KKWin = checkWinner('K',strings);
        BBWin = checkWinner('B',strings);
        if (KKWin==true && BBWin==true){
            System.out.println("No winner!");
        }else if (KKWin==true) {
            System.out.println("KiKi wins!");
        }else if (BBWin==true) {
            System.out.println("BoBo wins!");
        }else  {
            System.out.println("No winner!");
        }
    }
    static boolean checkWinner(char c ,char[][] arr ) {
        int count = 0;
        int size = 3;
        //1.先判断主对角线是否满足
        for (int i =0;i < size;i++) {
            if (arr[i][i] == c) {
                count++;
            }
        }
        if (count==3) {
            return true;
        }
        //走到这里说明没有返回，count要重新置为0，用来判断下一个位置是否满足
        count = 0;

        //2.在判断副对角线是否满足
        if (arr[0][2]==c && arr[1][1]==c && arr[2][0] == c) {
            return true;
        }

        //3.判断行是否满足
        for (int i = 0;i < size;i++) {
            for (int j = 0;j < size;j++) {
                if (arr[i][j]==c){
                    count++;
                }
            }
            if (count==3) {
                return true;
            }
            count=0;
        }

        //判断列是否满足
        for (int i = 0;i < size;i++) {
            for (int j = 0;j<size;j++) {
                if (arr[j][i] == c) {
                    count++;
                }
            }
            if (count==3) {
                return true;
            }
            count=0;
        }

        //程序走到这里说明都不满足
        return false;
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
栈的压入、弹出序列

【思路】借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，
这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，
这里是4，很显然1≠4，所以我们继续压栈，直到相等以后开始出栈，
出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
这样循环等压栈顺序遍历完成，如果辅助栈还不为空，
说明弹出序列不是该栈的弹出顺序。

举例：
入栈1,2,3,4,5
出栈4,5,3,2,1
首先1入辅助栈，此时栈顶1≠4，继续入栈2
此时栈顶2≠4，继续入栈3
此时栈顶3≠4，继续入栈4
此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3
此时栈顶3≠5，继续入栈5
此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
依次执行，最后辅助栈为空。如果不为空说明弹出序列不是该栈的弹出顺序。

 */

public class Main17 {
    public static void main(String[] args) {
        //创建一个辅助栈
        Stack<Integer> stack = new Stack<>();
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        boolean ret = IsPopOrder(stack,push,pop);
        System.out.println(ret);
    }
    public static boolean IsPopOrder(Stack<Integer> stack,int [] pushA,int [] popA) {
        if (pushA.length==0 || popA.length==0) {
            return false;
        }
        //用于标识弹出序列的下标
        int popIndex = 0;
        for (int i = 0;i<pushA.length;i++) {
            //循环每次进来先将所在下标元素入辅助栈
            stack.push(pushA[i]);
            //如果栈不为空且栈顶元素等于弹出序列
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                //栈顶元素出栈
                stack.pop();
                //标识弹出序列的下标向后移动一位
                popIndex++;
            }
        }
        return stack.empty();
    }
}




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
反转链表
 */
public class Main16 {
    public ListNode16 ReverseList(ListNode16 head) {
        ListNode16 cur = head;
        ListNode16 prev = null;
        ListNode16 newHead = null;
        while (cur != null) {
            //每次循环刚进来需要开辟一个节点保存cur.next，
            // 因为要让cur指向cur前一个节点，不保存cur.next就会找不到cur.next
            ListNode16 curNext = cur.next;
            if (cur.next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
}
class ListNode16 {
    int val;
    ListNode16 next = null;

    ListNode16(int val) {
        this.val = val;
    }




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
题目描述：
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0

输入：
2,3
输出：
8.00000
 */
public class Main15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(",");
            double a = Double.parseDouble(strings[0]);
            int b = Integer.parseInt(strings[1]);
            double ret = Power(a,b);
            System.out.println(ret);
            System.out.println(Power2(a,b));
        }
    }
    //法一：注此题考察点应该不在这里
    public static double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }
    //法二：不使用API，自己实现，注意要区分次方的正负
    public static double Power2(double base,int exponent) {
        if (exponent < 0) {
            base = 1/base;
            exponent = -exponent;
        }
        if (exponent == 0) {
            return 1;
        }
        double ret = 1;
        for (int i = exponent;i>=1;i--) {
            ret*=base;
        }
        return ret;


    }
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public class Main14 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0) {
            return null;
        }
        int rootVal = pre[0];
        if (pre.length == 1){
            return new TreeNode(rootVal);
        }

        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        //在中序遍历中先找到根的位置，好确定左子树和右子树的范围
        for (int i=0 ; i<in.length;i++) {
            if (in[i]==rootVal) {
                rootIndex = i;
                break;
            }
        }

        //Arrays.copyOfRange()是左闭右开的
        root.left = reConstructBinaryTree(
                Arrays.copyOfRange(pre,1,rootIndex+1),
                Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(
                Arrays.copyOfRange(pre,rootIndex+1,pre.length),
                Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;
    }

}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
二叉搜索树的第k个节点
二叉搜索树（二叉查找树）（二叉排序树）：
     根节点的值大于其左子树中任意一个节点的值，小于其右节点中任意一节点的值，

深度优先--栈--前中后序遍历
 */
public class Main13 {
    TreeNode2 KthNode(TreeNode2 pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        Stack<TreeNode2> stack = new Stack<>();
        //计数，每次出栈一个加一次，出栈顺序就是二叉树的节点的值的大小顺序
        int count = 0;
        //判断有没有遍历完
        while (pRoot!=null || !stack.empty()) {
            //中序遍历 左根右
            while (pRoot!=null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            //出栈顺序是按照终须遍历出的栈，即二叉树节点的大小顺序
            pRoot = stack.pop();
            count++;
            if (count==k) {
                return pRoot;
            }
            pRoot = pRoot.right;
        }
        //走到这里说明k超过了二叉树的节点个数
        return null;
    }
}
class TreeNode2 {
    int val;
    TreeNode2 left = null;
    TreeNode2 right = null;

    public TreeNode2(int val) {
        this.val = val;
    }
}





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
平衡二叉树
 */
public class Main12 {
    //判断是不是平衡二叉树
    public boolean IsBalanced_Solution(TreeNode1 root) {
        if (root==null) {
            return true;
        }
        int l = height(root.left);
        int r = height(root.right);
        if (Math.abs(l-r) < 1) {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }else {
            return false;
        }
    }

    //求二叉树的高度
    public int height(TreeNode1 root) {
        if (root == null) {
            return 1;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight,rightHeight);
    }
}
class TreeNode1{
    public int val;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;
    }
}




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
不用加减乘除做加法
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
输入：1 2
输出：3
 */
public class Main10 {
    public static void main(String[] args) {
        int a = 1;
        int b = -2;
        System.out.println(Add(a, b));
        System.out.println(Add2(a,b));
    }
    public static int Add(int num1,int num2) {
        if (num2>=0) {
            for (int i = num2;i>0;i--) {
                num1++;
            }
        }else {
            for (int i = num2;i<0;i++) {
                num1--;
            }
        }
        return num1;
    }

    //法二：二进制位运算
   /* 首先看十进制是如何做的： 5+7=12，三步走
    第一步：相加各位的值，不算进位，得到2。
    第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。

    第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。

    同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。

    第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。

    第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
    继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。*/
    public static int Add2(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）

输入："google"
输出：4
 */
public class Main09 {

    public static void main(String[] args) {
        String s = "google";
        System.out.println(FirstNotRepeatingChar(s));
        System.out.println(solution(s));
        System.out.println(FirstNotRepeatingChar3(s));
    }
    public static int FirstNotRepeatingChar(String str) {

        for (int i = 0;i < str.length();i++) {
           char temp = str.charAt(i);
            int count = 0;
           for (int j = 0;j <str.length();j++) {
               if (str.charAt(j) == temp) {
                   count++;
               }
           }
           if (count == 1) {
               return i;
           }
        }
        return -1;
    }

    //方法二：其实主要还是hash，利用每个字母的ASCII码作hash来作为数组的index。
    // 首先用一个58长度的数组来存储每个字母出现的次数，
    // 为什么是58呢，主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
    // 而每个字母的index=int(word)-65，比如g=103-65=38，
    // 而数组中具体记录的内容是该字母出现的次数，最终遍历一遍字符串，
    // 找出第一个数组内容为1的字母就可以了，时间复杂度为O(n)
    public static int solution(String str){
        int[] words = new int[58];
        for(int i = 0;i<str.length();i++){
            //此处可以不用加强转，因为英文字符可以自动转换为int
            words[(str.charAt(i))-65] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }

    //方法三：
    public static int FirstNotRepeatingChar3(String str) {
        if(str==null)return -1;
        if(str.length()==0)return -1;
        char[] ch=str.toCharArray();
        int pos=-1;
        int i=0,j=0;
        for(i=0;i<ch.length;i++){
            for(j=0;j<ch.length;j++){
                if((ch[i]==ch[j])&&(i!=j))break;
            }
            if(j==ch.length){
                pos=i;
                break;
            }
        }
        return pos;
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
合并两个有序的链表
 */

public class Main8 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        //合并后的新链表的头结点
        ListNode listNode = new ListNode(-1);
        ListNode cur = listNode;//遍历用的节点
        while (list1!=null && list2!=null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }else {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
        }
        //退出循环说明至少有一个链表已经全部遍历完了，因为两个链表都是升序，
        //所以剩下的未遍历的都是大于新链表的最后一个节点的
        if (list1!=null) {
            cur.next = list1;
        }else {
            cur.next = list2;
        }
        return listNode.next;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
二叉树的深度
 */
public class Main07 {
    //递归
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }

    //非递归，每遍历一层就加一
    public int TreeDepth2(TreeNode root) {
        if(root==null) return 0;
        ArrayList<TreeNode> arr=new ArrayList<>();
        arr.add(root);
        int count=0;
        while(arr.size()!=0){
            count++;
            for(int i=0; i<arr.size(); i++){
                TreeNode temp=arr.remove(0);
                if(temp.left!=null)
                    arr.add(temp.left);
                if(temp.right!=null)
                    arr.add(temp.right);
            }
        }
        return count;
    }

    public int TreeDepth3(TreeNode pRoot)
    {
        if(pRoot == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int depth = 0, count = 0, nextCount = 1;
        while(queue.size()!=0){
            TreeNode top = queue.poll();
            count++;
            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }
}





////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
  操作给定的二叉树，将其变换为源二叉树的镜像。
 */
    
public class Main06 {
    //先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，
    //当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);

    }
}
class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}





/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个  非递减排序(原数组后一个元素>=前一个元素)的数组的一个旋转，输出旋转数组的最小元素。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

输入：[3,4,5,1,2]
输出：1

 */
    //二分查找,原数组后一个元素>=前一个元素
    //这里我们把target 看作是右端点，来进行分析，那就要分析以下三种情况，看是否可以达到上述的目标。
    //
    //情况1，arr[mid] > target：4 5 6 1 2 3
    //     arr[mid] 为 6， target为右端点 3， arr[mid] > target, 说明[first ... mid] 都是 >= target 的，
    //     因为原始数组是非递减，所以可以确定答案为 [mid+1...last]区间,所以 first = mid + 1
    //情况2，arr[mid] < target:5 6 1 2 3 4
    //      arr[mid] 为 1， target为右端点 4， arr[mid] < target, 说明答案肯定不在[mid+1...last]，
    //      但是arr[mid] 有可能是答案,所以答案在[first, mid]区间，所以last = mid;
    //情况3，arr[mid] == target:
    //      如果是 1 0 1 1 1， arr[mid] = target = 1, 显然答案在左边
    //      如果是 1 1 1 0 1, arr[mid] = target = 1, 显然答案在右边
    //      所以这种情况，不能确定答案在左边还是右边，那么就让last = last - 1;慢慢缩少区间，同时也不会错过答案。
public class Main05 {
    public static void main(String[] args) {
        int[] a = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,
                9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,
                3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(minNumberInRotateArray(a));
    }
    public static int minNumberInRotateArray(int [] array) {
        /*int start=0;
        int end=array.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(end-start==1)
                return array[end];
            if(array[mid]>=array[start])
                start=mid;
            if(array[mid]<=array[end])
                end=mid;
        }
        return -1;*/

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
            //因为原数组是非递减的，旋转后如果第一个元素<=最后一个元素，则第一个元素一定是最小的
            if (array[start] <= array[last]) {
                return array[start];
            }else if (array[mid] < array[last]) {
                last = mid;
            }else if (array[mid] > array[last]) {
                start = mid+1;
            }else {
                --last;
            }
       }
        return array[last];
    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

// push操作就直接往stack1中push，
// pop操作需要分类一下：如果stack2为空，那么需要将stack1中的数据全部转移到stack2中，然后在对stack2进行pop，如果stack2不为空，直接pop就ok。
public class Main04 {
    //模拟入队列的栈
    Stack<Integer> stack1 = new Stack<Integer>();
    //模拟出队列的栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
    }

    public int pop() {
        //如果stack2为空，那么需要将stack1中的数据全部转移到stack2中，然后在对stack2栈顶元素弹出
        if (stack2.empty()) {
            while (!stack1.empty()) {
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }
        //如果stack2不为空，直接将stack2的栈顶元素弹出
        return stack2.pop();
    }
}





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
变态跳台阶
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

//每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(JumpFloorII(n));
        }
    }
    public static int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
青蛙跳台阶
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

 */
public class Main02 {
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





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
斐波那契数列
 */
public class Main01 {
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



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
简单错误记录

思路：此题中，对于两个文件，如果文件名相同（不用管目录，只看最后的文件名），行号相同，就认为使用一个文件
     如果输入的文件中，有这样相同的文件，就在出现的次数那里加一，如果输入的文件之前没有输入过，则添加新文件

     首先，先定义一个类，用来表示错误信息，其中包括文件名，行号，次数，具体结构
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ErrorFile> list = new ArrayList<>();
        while (sc.hasNext()) {
            ErrorFile errorFile = new ErrorFile();
            String[] lines = sc.nextLine().split(" ");//将输入的每一行按空格拆分，0号下标存储的文件路径/文件名，1号下标存储的是行号
            String name = lines[0];//取得文件名
            int index = name.lastIndexOf('\\');//扎到最后一个\的下标位置，从而获取文件名
            errorFile.fileName = index<0 ? name : name.substring(index+1);//获取文件名,如果index<0，说明name中没有\，则name就是文件名，否则文件名是name的子串
            errorFile.lineNum = Integer.parseInt(lines[1]);//获取行号

            boolean flag = true;//设置一个标志位

            //遍历list，如果文件名和行号都相同的话，count加一次，flag置为false
            for (ErrorFile ef : list) {
                if (ef.fileName.equals(errorFile.fileName) && ef.lineNum == errorFile.lineNum) {
                    errorFile.count++;
                    flag = false;
                }
            }
            //如果flag还是true，说明list中没有这个错误信息，则将该错误信息添加到list内
            if (flag) {
                list.add(errorFile);
            }
        }
        sc.close();//输入结束之后，关闭
        //传入一个比较器，对其进行排序
        Collections.sort(list, new Comparator<ErrorFile>() {
            @Override
            public int compare(ErrorFile o1, ErrorFile o2) {
                //return (o1.count-o2.count)*(-1); //降序输出，所以乘-1
                return (o2.count-o1.count);
            }
        });

        //遍历排好序的list，如果错误信息不够八个，全部输出，如果超出八个，输出前八个
        for (int i = 0;i < (list.size()>8 ? 8 : list.size());i++) {
            ErrorFile er = list.get(i);//获取错误信息
            String name = er.fileName;//获取文件名
            String fileName = name.length()>16 ? name.substring(name.length()-16) : name;//如果文件名大于16输出后16为，如果小于等于16，全部输出
            int lineNum = er.lineNum;//获取行号
            int count = er.count; //获取错误信息出现次数
            System.out.println(name+" "+lineNum+" "+count);
        }

    }
}

//定义一个类，来描述错误文件的信息
class  ErrorFile {
    //文件名
    String fileName;
    //行号
    int lineNum;
    //一个错误出现的次数计数 ：次数默认是1，因为一旦输入一个文件，他就出现了一次，当有重复文件出现的时候，给次数加1
    int count = 1;
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
说反话
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        reverse(s);
    }
    public static void reverse(String[] strings) {
        List<String> list = new ArrayList<String>();
        for (int i = 0;i < strings.length;i++) {
            list.add(strings[i]);
        }

        int e = list.size()-1;
        int b = 0;
        for (int i = e;i >= 0;i--) {
            strings[b++] = list.get(i);
        }

        for (String s : strings) {
            System.out.print(s+" ");
        }

    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Test08 {
    public static void main(String[] args) throws InterruptedException {
        final Object obj = new Object();
        Thread t1 = new Thread() {
            public void run() {
                synchronized (obj) {
                    try {
                        obj.wait();
                        System.out.println("Thread 1 wake up.");
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread() {
            public void run() {
                synchronized (obj) {
                    obj.notifyAll();
                    System.out.println("Thread 2 sent notify");
                }
            }
        };
        t2.start();
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
大整数排序 TODO ：IDEA可以跑，牛客不通过
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0;i < n;i++) {
                String s = sc.nextLine();
                list.add(s);
            }
            //对list内容进行大小排序
            sort(list);
            //输出list
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static void sort(List<String> list) {
        for (int i = 0;i < list.size()-1;i++) {
            String s1 = list.get(i);
            for (int j = i+1;j < list.size();j++) {
                String s2 = list.get(j);
                if (s1.length()>s2.length()) {
                    //交换list的i下标和j下标的内容
                    swap(list,i,j);
                }else if (s1.length()==s2.length()) {
                    for (int k = 0;k < s1.length();k++) {
                        if (s1.charAt(k) > s2.charAt(k)) {
                            swap(list,i,j);
                        }
                    }
                }
            }
        }
        //System.out.println(list);
    }

    public static List<String> swap(List<String> list,int i,int j) {
        String s1 = list.get(i);
        String s2 = list.get(j);
        String temp = s1;
        list.set(i,s2);
        list.set(j,temp);
        return list;
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
年会抽奖
 */
    //TODO
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            if (n==1){
                System.out.println("100.00%");
            }
            if (n==2) {
                System.out.println("50.00%");
            }
            if (n>2) {
                 double noPrize = Math.pow(n-1,n-2);
                 int sum = 1;
                 for (int i =1;i <= n;i++) {
                     sum*=i;
                 }
                 double ret = (noPrize/sum)*100;
                System.out.println(String.format("%.2f",ret)+"%");
            }
        }
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
密码验证合格程序
 */

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            boolean ret = CodeIsOk(s);
            if (ret) {
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }

    //判断密码是否合格
    public static boolean CodeIsOk(String s) {
        boolean b = true;
        //先判断长度
        if (s.length() <= 8) {
            b = false;
            return b;
        }
        //在判断符号数
        boolean b1 = CodeIsOk2(s);
        if (!b1) {
            b = false;
            return b;
        }
        //最后判断不能有相同长度超过2的子串重复
        boolean b2 = CodeIsOk3(s);
        if (!b2) {
            b = false;
            return b;
        }
        return b;
    }

    //判断是否存在三种以上的符号
    public static boolean CodeIsOk2(String s) {
        int len = s.length();
        int[] ints = new int[4];
        for (int i = 0;i < len;i++) {
            char c = s.charAt(i);
            if (c>='0' && c<='9') {
                ints[0]++;
            }else if (c>='a' && c<='z') {
                ints[1]++;
            }else if (c>='A' && c<='Z') {
                ints[2]++;
            }else {
                ints[3]++;
            }
        }
        int count = 0;
        for (int i : ints) {
            if (i == 0){
                count++;
            }
        }
        return count <= 1;
    }

    //不能有相同长度超过2的子串重复，最小的为长度为3的重复子串，
    // 若长度为4的重复子串，则长度为3的子串也包含在里面，所以只需要找长度为3的子串即可
    private static boolean CodeIsOk3(String s) {
        //遍历整个密码串
        for (int i = 0;i < s.length()-3;i++) {
            //从前向后找子串
            String s1 = s.substring(i,i+3);
            String otherString = s.substring(i+3,s.length()-1);
            if (otherString.contains(s1)) {
                return false;
            }
        }
        return true;
    }
}





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
守形数
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int len = s.length();
            int n = Integer.parseInt(s);
            int n2 = n*n;
            String s1 = String.valueOf(n2);
            String ret = "";
            for (int i=s1.length()-len;i < s1.length();i++) {
                ret = ret + s1.charAt(i);
            }
            //System.out.println(ret);
            if (s.equals(ret)) {
                System.out.println("YES!");
            }else {
                System.out.println("NO!");
            }
        }
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
整数与IP地址间的转换
 */
    //TODO 存在数组越界问题待解决
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            //输入的是IP地址
            if (s.contains(".")) {
                IPToInt(s);
            }else {//输入的是整数
                IntToIP(s);
            }
       }
    }

    public static void IPToInt(String s) {
        String[] strings = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < strings.length;i++) {
            int e = Integer.parseInt(strings[i]);
            String str = Integer.toBinaryString(e);
            //所有二进制补全成八位
            while (str.length() < 8) {
                str="0"+str;
            }
            sb.append(str);
        }
        System.out.println(Integer.parseInt(sb.toString(),2));
    }

    public static void IntToIP(String s) {
        //1.先将十进制转换为二进制
        String s1 = Integer.toBinaryString(Integer.parseInt(s));
        //2.补0
        while (s1.length() < 32) {
            s1="0"+s1;
        }
        //3.存进数组
        String[] strings = new String[4];
        int [] ints = new int[4];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 4;i++) {
            strings[i] = s1.substring(count,count+8);
            ints[i] = Integer.parseInt(strings[i],2);
            sb.append(ints[i]+".");
            count+=8;
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
找x
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");
        int x = Integer.parseInt(sc.nextLine());
        for (int i =0;i < strings.length;i++) {
            int e = Integer.parseInt(strings[i]);
            if (e == x) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
记票统计
 */
public class Main02 {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        Scanner scanner = new Scanner(System.in);
        //int votePerson = Integer.parseInt(scanner.nextLine());
        while (scanner.hasNext()) {
            //候选人人数
            int votePerson = scanner.nextInt();
            scanner.nextLine();
            //候选人名字
            char[] chars1 = scanner.nextLine().toCharArray();
            //投票人人数
            int candidatePerson = scanner.nextInt();
            scanner.nextLine();
            //投票人投的票
            char[] chars2 = scanner.nextLine().toCharArray();

            //将候选人名字放入map,i=i+2,因为每两个候选人名字中间有空格字符
            for (int i = 0;i < chars1.length;i=i+2) {
                map.put(chars1[i],0);
            }

            int Invalid = 0;

            //读取投票人的投票
            for (int i = 0;i < chars2.length;i=i+2) {
                if (map.containsKey(chars2[i])) {
                    map.put(chars2[i],map.get(chars2[i])+1);
                }else {
                    Invalid++;
                }
            }
            //输出
            for (Map.Entry<Character,Integer> me : map.entrySet()) {
                System.out.println(me.getKey()+" : "+me.getValue());
            }
            System.out.println("Invalid : "+Invalid);
        }

    }
}




/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
数字之和
 */
public class Main {

  /*  public static void main(String[] args) {
        String s = "123";
        String[] strings = s.split("");
        System.out.println(strings.length);
        System.out.println(Arrays.toString(strings));
        char c = 'a';
        System.out.println(s.charAt(0));
    }*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = Integer.parseInt(sc.nextLine());
            int ret1 = count(n);
            long n2 = n*n;
            int ret2 = count(n2);
            System.out.println(ret1+" "+ret2);
        }
    }

    //计算n的各位数字之和
    public static int count(long n) {
        String s = String.valueOf(n);
        int sum = 0;
        String[] strings = s.split("");
        for (int i = 0;i < strings.length;i++) {
            sum += Integer.parseInt(strings[i]);
        }
        return sum;
    }


}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
学分绩点

输入：
5
4 3 4 2 3
91 88 72 69 56

输出：
2.52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strings1 = sc.nextLine().split(" ");
        String[] strings2 = sc.nextLine().split(" ");
        //所有课程学分之和
        double scoreSum = 0;
        //所有学科绩点之和
        double scorePointSum = 0;
        for (int i = 0;i < n;i++) {
            scoreSum += Integer.parseInt(strings1[i]);
            scorePointSum += scorePoint(Integer.parseInt(strings2[i])) * Integer.parseInt(strings1[i]);
        }
        double ret = scorePointSum/scoreSum;
        System.out.println(String.format("%.2f",ret));
    }

    public static double scorePoint(int i) {
        if (i>=90 && i<=100) {
            return 4.0;
        }else if (i>=85 && i<=89) {
            return 3.7;
        }else if (i>=82 && i<=84) {
            return 3.3;
        }else if (i>=78 && i<=81) {
            return 3.0;
        }else if (i>=75 && i<=77) {
            return 2.7;
        }else if (i>=72 && i<=74) {
            return 2.3;
        }else if (i>=68 && i<=71) {
            return 2.0;
        }else if (i>=64 && i<=67) {
            return 1.5;
        }else if (i>=60 && i<=63) {
            return 1.0;
        }
        return 0;
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
最高分是多少

输入：
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出：
5
6
5
9

 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int M = Integer.parseInt(strings[1]);
            String[] strings2 = scanner.nextLine().split(" ");
            int[] ints = new int[N];
            for (int i = 0;i < N;i++) {
                ints[i] = Integer.parseInt(strings2[i]);
            }
            List<Integer> list = new ArrayList<>();

            for (int i = 0;i < M;i++) {
                String[] strings1 = scanner.nextLine().split(" ");
                if (strings1[0].charAt(0)=='Q') {
                    int index1 = Integer.parseInt(strings1[1]);
                    int index2 = Integer.parseInt(strings1[2]);
                    Arrays.sort(ints,index1-1,index2-1);
                    //query(ints,index1-1,index2-1);
                    list.add(ints[index2-1]);
                }else if (strings1[0].charAt(0)=='U') {
                    int index = Integer.parseInt(strings1[1]);
                    int num = Integer.parseInt(strings1[2]);
                    ints[index] = num;
                    if (i==M-2) {
                        Arrays.sort(ints);
                    }
                

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
小乐乐计算求和
小乐乐想计算一下1!+2!+3!+...+n!。
 */
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //n=1的时候，不满足第一个循环条件，返回1
        //n>1的时候，开始加阶乘
        int sum = 1;
        for(int i = 2; i <= n;i++) {
            int e = 1;
            for(int j = 1; j <= i;j++) {
                e*=j;
            }
            sum+=e;
        }
        System.out.println(sum);
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
题目描述
KiKi现在得到一个包含n*m个数的整数序列，现在他需要把这n*m个数按顺序规划成一个n行m列的矩阵并输出，请你帮他完成这个任务。
输入描述:
一行，输入两个整数n和m，用空格分隔，第二行包含n*m个整数（范围-231~231-1）。(1≤n≤10, 1≤m≤10)
输出描述:
输出规划后n行m列的矩阵，每个数的后面有一个空格。

输入：
2 3
1 2 3 4 5 6

输出：
1 2 3
4 5 6

 */

public class Main01 {
    //法二：
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        strings = reader.readLine().split(" ");
        int index = 0;//定义一维数组的下标

        //开辟一个n*m的二维数组，将一维数组内的元素按顺序放入二维数组
        String[][] str = new String[n][m];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                str[i][j] = strings[index];
                System.out.print(str[i][j]+" ");
                index++;
            }
            System.out.println();
        }
    }

    //法一
    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        //int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        String[] strings1 = reader.readLine().split(" ");
        for (int j = 1;j <= strings1.length;j++) {
            if (j % m == 0) {
                System.out.print(strings1[j-1]+" ");
                System.out.println();
            }else {
                System.out.print(strings1[j-1]+" ");
            }
        }

    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
从n行m列的方阵队列中找到身高最高的人的位置

输入：
2 2
175 180
176 185

输出：
2 2

 */
public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        //先创建一个list按顺序存放所有人的身高值
        List<String> list = new ArrayList<>();
        for (int i = 0;i < n;i++) {
            strings = reader.readLine().split(" ");
            for (int j = 0;j < strings.length;j++) {
                list.add(strings[j]);
            }
        }


        int[] max = new int[2];
        int maxNum = 0;

        //ArrayList底层数组的下标
        int index = 0;
        //将list内的值按顺序存入二维数组，随后进行比较，找出最大值，最大值的下标存入一维数组
        int[][] a = new int[n][m];
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                a[i][j] = Integer.parseInt(list.get(index));
                if (a[i][j] > maxNum) {
                    maxNum = a[i][j];
                    max[0] = i+1;
                    max[1] = j+1;
                }
                index++;
            }
        }
        System.out.println(max[0]+" "+max[1]);

    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
两个n行m列的矩阵，他想知道两个矩阵是否相等

输入：
2 2
1 2
3 4
1 2
3 4

输出：
Yes
 */
public class Main03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < 2*n;i++) {
            strings = reader.readLine().split(" ");
            for (int j = 0;j < m;j++) {
                list.add(Integer.parseInt(strings[j]));
            }
        }
        //用两个指针遍历list并比较
        int pre = 0;
        int last = m*n;
        //判断的标志
        boolean flag = true;

        for (int i = 0;i < m*n;i++) {
            if (list.get(pre++) != list.get(last++)) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
KiKi想知道一个n阶方矩是否为上三角矩阵，请帮他编程判定。上三角矩阵即主对角线以下的元素都为0的矩阵，主对角线为从矩阵的左上角至右下角的连线。

输入：
3
1 2 3
0 4 5
0 0 6

输出：
YES

 */

public class Main04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[][] strings1 = new String[n][n];
        for (int i = 0;i < n;i++) {
            String[] strings = reader.readLine().split(" ");
            for (int j = 0;j < n;j++) {
                strings1[i][j] = strings[j];
                if (i > j && !"0".equals(strings1[i][j])) {
                    System.out.println("NO");
                    break;
                }
            }
        }
        System.out.println("YES");
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
矩阵的转置

输入：
2 3
1 2 3
4 5 6

输出：
1 4
2 5
3 6

 */
public class Main05 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

         String[][] str = new String[n][m];
        for (int i = 0;i < n;i++) {
            String[] strings1 = reader.readLine().split(" ");
            for (int j = 0;j < m;j++) {
                str[i][j] = strings1[j];
            }
        }

        for (int i = 0;i < m;i++) {
            for (int j = 0;j<n;j++) {
                System.out.print(str[j][i] + " ");
            }
            System.out.println();
        }
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
第一行包含两个整数n和m，表示一个矩阵包含n行m列
从2到n+1行，每行输入m个整数
接下来一行输入k，表示要执行k次操作
接下来有k行，每行包括一个字符t和两个数a和b，t代表需要执行的操作，当t为字符'r'时代表进行行变换，当t为字符'c'时代表进行列变换，a和b为需要互换的行或列

输入：
2 2
1 2
3 4
1
r 1 2

输出:
3 4
1 2

 */

public class Main06 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        String[][] strings1 = new String[n][m];

        //给二维数组赋值
        for (int i = 0;i < n;i++) {
            strings = reader.readLine().split(" ");
            strings1[i] = strings;
        }

        int k = Integer.parseInt(reader.readLine());
        while (k > 0) {
            strings = reader.readLine().split(" ");
            String t = strings[0];
            int a = Integer.parseInt(strings[1]);
            int b = Integer.parseInt(strings[2]);

            //如果t为"r"，交换a行和b行
            if ("r".equals(t)) {
                //交换行的值
                for (int i = 0;i < m;i++) {
                    String temp = strings1[a-1][i];
                    strings1[a-1][i] = strings1[b-1][i];
                    strings1[b-1][i] = temp;
                }
            }

            //如果twe"c"，交换a列和b列
            if ("c".equals(t)) {
                //交换列的值
                for (int i = 0;i < n;i++) {
                    String temp = strings1[i][a-1];
                    strings1[i][a-1] = strings1[i][b-1];
                    strings1[i][b-1] = temp;
                }
            }
            k--;
        }

        //打印
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                System.out.print(strings1[i][j]+" ");
            }
            System.out.println();
        }

    }
}

