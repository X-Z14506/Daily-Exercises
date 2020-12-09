


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class IsHuiWen {
    //先写一个方法来判断是否是回文串的方法
    public static boolean isHuiWen(String string) {
        int i = 0;
        int j = string.length()-1;
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String stringA = input.nextLine();
        String stringB = input.nextLine();
        //记录回文串的个数
        int count = 0;

        //注意：此处的判断条件万万不可是i<stringA.length(),这样会少计算字符串最后一个字符的后面位置
        for (int i = 0;i <= stringA.length();i++) {
            //保证循环每次进来stringA值不变
            StringBuilder sb = new StringBuilder(stringA);
            //向stringA的分别不同位置插入stringB
            sb.insert(i,stringB);
            if (isHuiWen(stringA.toString())) {
                count++;
            }
        }
        System.out.println(count);
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*有一组数，对于其中任意两个数组，若前面一个大于后面一个数字，
 则这两个数字组成一个逆序对，请设计一个高效的算法，计算给定数组中的逆序对个数。*/

public class Code01 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,0};
        int n = 8;
        System.out.println(count(A, n));//7
    }
    public static int count(int[] A, int n) {
        int count = 0;
        for (int i = 0; i < n;i++) {
            for (int j = i+1;j < n;j++) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶
 她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
 喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水
 喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？

输入描述:
输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），
 表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。

输出描述:
对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。

输入例子:

3
10
81
0
输出例子:
1
5
40
*/

public class Code02 {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        while (input.hasNext()) {
            int num = input.nextInt();
            if (num!=0) {
                int ret = maxDrinks(num);
                System.out.println(ret);
            }
        }
    }

    private static int maxDrinks(int num) {
        //先将手上的空瓶子三个一组分好，
        int k = 0;
        while (num >= 3) {
            //1.空瓶子为三的倍数时，k为可以换回饮料的个数
            if (num % 3 == 0) {
                k = k + num/3;
                num = num/3;
            }
            //2.空瓶子不为三的个数时，num为空瓶子数
            if (num % 3 != 0) {
                k= k + num/3;
                int i = num%3;
                num = num/3 + i;
            }
        }
        //3.空瓶子数为2时，还可以换一瓶饮料，所以k+1；
        if (num == 2) {
            k = k+1;
        }
        return k;
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * 题目：读入一个字符串str，输出字符串str中的连续最长的数字串
 * 输入描述:
 * 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
 *
 * 输出描述:
 * 在一行内输出str中里连续最长的数字串。
 * 示例1
 * 输入
 *
 * abcd12345ed125ss123456789
 * 输出
 *
 * 123456789
 *
 * 思路：用两个循环判断，一个判断是否为数字开始，第二个计算长度，最后将最长的从原字符串中截取出来
 */
public class Code1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String ret = "";
        int count = 0;
        int index = 0;
        for (int i = 0; i < str.length();i++) {
            //出现第一个数字
            if (str.charAt(i) >= '0'&& str.charAt(i) <= '9') {
                count = 1;//先给计数器加1
                index = i;//定位第一个数字出现的下标
                for (int j = i ; j < str.length();j++) {
                    if (str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                        count++;
                        index = j;
                    }else {
                        break;
                    }
                }
                if (count > ret.length()) {
                    ret = str.substring(i,index+1);//substring(0,5)左闭右开，表示包含0号下标，不包含5号下标
                }
            }else {
                continue;
            }
        }
        System.out.println(ret);
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
合法括号串表示字符串中全是括号,并且左右括号数量相等*/
public class Code2 {
    public static void main(String[] args) {
        String a = "(()())";
        int n = a.length();
        System.out.println(chkParenthesis(a, n));
    }
    public static boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for (int i = 0; i < n;i++) {
            //如果字符即不为左括号又不为右括号，输出false
            if (A.charAt(i) != '(' && A.charAt(i) != ')') {
                return false;
                //如果为左括号，压栈
            }else if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
                //如果为右括号，判断栈内是否为空，若不为空，弹出栈内左括号，若为空，说明右括号对应不上左括号，输出false
            }else {
                if (!stack.empty()) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        //遍历完成字符串，如果栈为空，说明为合法的括号串，不为空，说明左括号多了
        if (stack.empty()) {
            return true;
        }else {
            return false;
        }
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。*/
    
public class Code1  {
    public static void main(String[] args) {
        System.out.println(method());
    }
    public static int method() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        //1.如果n小于6，或者n为奇数或者n为10，则没法购买n个苹果，return -1；
        if (n < 6 || n%2!=0 ||n==10) {
            return -1;
            //2.如果n为8的整数倍，可以买n/8个苹果
        }else if (n % 8==0) {
            return n/8;
            //3.如果n不是8的整数倍，又是偶数且不满足1，即可买n/8+1个苹果
        }else {
            return n/8 + 1;
        }
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
输入两个字符串，从第一个字符串中删除第二个字符串中的所有字符
比如输入“They are students."
删除之后的第一个字符串变成"The r stdnts."*/
    
public class Code2 {
    //方法一：用list
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        String str1 = "They are students";
        String str2 = "aeiou";
        for (int i = 0; i < str1.length();i++ ) {
            if (!str2.contains(str1.charAt(i) +"")) {//此处要加""，因为需要的是CharSequence类型，而不是char类型
                list.add(str1.charAt(i));
            }
        }
        for (int i = 0; i < list.size();i++) {
            System.out.print(list.get(i));
        }

    }

    //方法二：用String
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String str2 = input.nextLine();
//        String str1 = "They are students";
//        String str2 = "aeiou";
        String ret = null;
        for (int i = 0; i < str2.length(); i++) {
            ret = str1.replaceAll(String.valueOf(str2.charAt(i)), "");
            str1 = ret;
        }
        System.out.println(str1);
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
标题：神奇的口袋 | 时间限制：1秒 | 内存限制：65536K
有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。John现在
有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，如果选出的
物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。现在的问题是，John有多少种不
同的选择物品的方式。
输入描述：
输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正
整数，分别给出a1，a2……an的值。
输出描述：
输出不同的选择物品的方式的数目。
示例1:
输入
3
20
20
20
输出
3
 */
public class Code1 {
    /**
     * 本题采用的是递归的思想：
     * 1.物品有n个，将物品逐一放入weight[]中；2.递归函数count(int s,int n):s表示物品剩余重量，n表示可选择物品个数
     * 递归分为两步：
     * a.从后往前装，选择后使用s-weight[n],n-1进行递归，如果有解count++；无解则返回
     * b.当选择当前物品无解时就选择忽略当前物品，从n-1个物品进行删除递归；
     *
     * 总结：这道题其实是和高中的排列组合有关思想，从这道题中可以得出如果是排列组合思想
     * 使用递归进行解题时就需要分两步，因为会有回退现象出现，所以需要在回退之后再一次进行另一条路的递归；
     * @param s
     * @param n
     */
    public static void count(int s,int n){
        //如果刚好装满
        if (s == 0){
            count++;
            return;
        }
        //如果s<0或者n<1则表示不成立
        if (s < 0 || (s > 0 && n < 1)){
            return;
        }

        //减去当前的物品用剩余的s，进行递归
        count(s - weight[n],n - 1);

        //如果当前物品这条路走不通，则跳过当前物品，直接n -1递归
        count(s,n - 1);
    }
    //Right solution
    static int[] weight;
    static int N;
    static int count = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            N = input.nextInt();
            weight = new int[N + 1];
            for (int i = 1; i <= N;i++){
                weight[i] = input.nextInt();
            }

            count(40,N);
            System.out.println(count);
        }
    }
}
    

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
//用两个栈实现一个队列，栈为先进后出，队列为先进先出
public class Code2 {
    Stack<Integer> stack1 = new Stack<Integer>();//压入栈
    Stack<Integer> stack2 = new Stack<Integer>();//弹出栈

    //压栈往stack1内压
    public void push(int node) {
        stack1.push(node);
    }

    /*弹栈先判断2内是否为空，如果不为空，直接弹出2内栈顶元素，
    如果为空，将1内所有元素压入2，直到1为空，最后弹出内2栈顶元素，保证队列的先进先出
    如果栈1和栈2都为空，返回-1*/
    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.empty() ? -1 : stack2.pop();
    }
}

    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    //由题意知任意两块蛋糕的欧几里得距离不能等于2，也即有两组关系：
// （1）x1 - x2 = 2(或-2)，y1 - y2 = 0；
// （2）y1 - y2 = 2(或-2)，x1 - x2 = 0；
// 可理解为若开始放蛋糕的位置为（x,y）；则对于每一行来说（x + 2, y）处不能放蛋糕；
// 对于每一列来说（x, y + 2）处不能放蛋糕。
public class Code1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int w = input.nextInt();
        int h = input.nextInt();
        //创建的未初始化的二维数组，则其值默认为0；
        //将不能放蛋糕的地方置为1，最后剩几个0就意味着可以放几块蛋糕
        int[][] arr = new int[w][h];
        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (arr[i][j] == 0) {
                    count++;
                    //每一行不能放蛋糕的地方
                    if ((i + 2) < w) {
                        arr[i + 2][j] = 1;
                    }
                    //每一列不能放蛋糕的位置
                    if ((j + 2) < h) {
                        arr[i][j + 2] = 1;
                    }
                }
            }
        }
        System.out.println(count);//这个2*2的盒子最多放4个也能跑
    }
    //方法二：不管是行还是列，只要有一个能够被4整除，蛋糕数就为网格总数的一半；
    // 如果行跟列都不能被4整除，蛋糕数等于网格总数除以2，再加上1。
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int count = 0;
        if(num1%4==0||num2%4==0) {
            count = num1*num2/2;
        }else{
            count = num1*num2/2+1;
        }
        System.out.println(count);//这个2*2的盒子最多放三个也能跑，咋回事
    }
}
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    //求a和b最小公倍数
public class Code2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int ret =getRet(a,b);
        System.out.println(ret);
    }
    private static int getRet(int a,int b) {
        int max = Math.max(a,b);
        int x = max;
        while (x % a != 0 || x % b != 0) {
            x++;
        }
        System.out.println(x);
        return x;
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    
  /*
输入描述:
每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
输出描述:
一行输出最后一个被删掉的数的原始下标位置。

思路：
这道题使用ArrayList能够很轻松的解决，每隔两个数删除，就是删除顺序表中i=i+2的数，
又由于循环所以要%顺序表的长度。 然后利用顺序表的特性，达到目的
 */
public class code01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (in.hasNext()) {
            n = in.nextInt();
            if (n > 1000) {
                n = 999;
            }
            //        int n = 3;
            int i = 0;
            List<Integer> list = new ArrayList<>();
            for (; i < n; i++) {
                list.add(i);
            }
            while (list.size() > 1) {
                i = (i + 2) % list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//输入一个正整数n，求n！末尾有多少个0？比如：n=10;n!=32628800,输出为2
public class code {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Long n = input.nextLong();
        Long ret = 1l;
        for (int i = 1; i<=n;i++) {
             ret *= i;
        }
//        System.out.println(ret);
        int count = 0;
        while (ret%10 == 0){
            ret /= 10;
            count++;
        }
        System.out.println(count);
    }
}

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//输入一个整数，将这个整数以字符串的形式逆序输出，程序不考虑负数的情况
//若数字含有0，则逆序形式也含有0，如输入10，则输出为001
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        //整型数据转换为字符串类型
        String str = String.valueOf(i);

        //创建一个和字符串长度一样的字符数组
        char[] data = new char[str.length()];
        int k = 0;
        //将字符串中的内容逆置
        for (int j = str.length()-1;j>=0;j--) {
            data[k++] = str.charAt(j);
        }
        System.out.println(new String(data));
    }
}

    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
//输入一个正整数n，求n！末尾有多少个0？比如：n=10;n!=32628800,输出为2
public class code {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Long n = input.nextLong();
        Long ret = 1l;
        for (int i = 1; i<=n;i++) {
             ret *= i;
        }
//        System.out.println(ret);
        int count = 0;
        while (ret%10 == 0){
            ret /= 10;
            count++;
        }
        System.out.println(count);
    }
}
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
//输入一个整数，将这个整数以字符串的形式逆序输出，程序不考虑负数的情况
//若数字含有0，则逆序形式也含有0，如输入10，则输出为001
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        //整型数据转换为字符串类型
        String str = String.valueOf(i);

        //创建一个和字符串长度一样的字符数组
        char[] data = new char[str.length()];
        int k = 0;
        //将字符串中的内容逆置
        for (int j = str.length()-1;j>=0;j--) {
            data[k++] = str.charAt(j);
        }
        System.out.println(new String(data));
    }
}

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /*
Fibonacci数列是这样定义的：
F[0] = 0
F[1] = 1
for each i ≥ 2: F[i] = F[i-1] + F[i-2]
因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，
在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，
现在给你一个数N求最少需要多少步可以变为Fibonacci数。

输入描述:

输入为一个正整数N(1 ≤ N ≤ 1,000,000)
输出描述:

输出一个最小的步数变为Fibonacci数"

思路：
如果斐波那契数列中的一个数比当前数要大，则开始计算数列中的当前数和前一个数，哪一个数更近，则算出步数。
循环生成斐波那契数，当生成第一个比n大的斐波那契数时(所以,需要和f2进行比较)，
此时离n最近的两个斐波那契数为最新生成的两个斐波那契数，测试它们，返回与n之间的最小距离
 */
public class Code01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int f1 = 0;
        int f2 = 1;
        int f3 = 0;//初始化f3为0
        while (f2 < n) {
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        if (Math.abs(f1-n) > Math.abs(f2-n)) {
            System.out.println(Math.abs(f2-n));
        }else {
            System.out.println(Math.abs(f1-n));
        }
    }

}

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
 /*
题目：
有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。

测试样例：2,2
返回：2

 */
public class Code02 {
    public int countWays(int x, int y) {
        // write code here
        int dp[][] = new int[x][y];
        for(int i = 0; i < x; i++){
            dp[i][0] = 1;
        }
        for(int j =0; j< y; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i< x;i++){
            for(int j =1;j<y;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[x-1][y-1];
    }
    public static void main(String[] args) {
        Code02 robaot = new Code02();
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        if (x+y < 12) {
            System.out.println(robaot.countWays(x,y));
        }else {
            System.out.println("输入不合法");
        }
    }

}

    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
/*
给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，
请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。

输入格式：

每个输入包含1个测试用例，即一个不超过1000位的正整数N。

输出格式：

对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。

输入样例：
100311
输出样例：
0:2
1:3
3:1
 */

public class Code1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        //此处用TreeMap因为TreeMap是自动排好序的，而HashMap是无序的
        TreeMap<Character,Integer> tree = new TreeMap<>();


        for (int i = 0;i<str.length();i++) {
            char ch = str.charAt(i);
            if (ch <= '9'&& ch >= '0') {
                if (!tree.containsKey(ch)) {

                    //new Integer和Integer.valueOf区别：
                    //new Integer(127)：每次调用得到一个新对象
                    //Integer.valueOf：每次调用先看缓存池里有没有该值，有的话返回该缓存池里的内容，没有的话返回的是一个新的Integer对象，
                    tree.put(ch,new Integer(1));
                }else {
                    tree.put(ch,(Integer)tree.get(ch)+1);
                }
            }
        }

        String string = "0123456789";
        char[] ch1 = string.toCharArray();
        for (char e : ch1) {
            if (tree.containsKey(e)) {
                System.out.println(e +":"+ tree.get(e));
            }
        }
    }

}

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 */
public class Code2 {
    public static int[] multiply(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0;i < A.length;i++) {
            int sum = 1;
            for (int j = 0 ;j < A.length;j++) {
                if (j == i) {
                    continue;
                }else {
                    sum*=A[j];
                }
            }
            System.out.println(sum);
            b[i]=sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] ret = multiply(a);
        System.out.println(Arrays.toString(ret));
    }
}

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
输入：nums = [2,0,1]
输出：[0,1,2]
输入：nums = [0]
输出：[0]
输入：nums = [1]
输出：[1]

 */

    public class SortColor {

    //方法一：先计算出个数字出现的次数，然后在按0,1,2的顺序给数组重新赋值
    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(a));
        sortColors1(a);
        System.out.println(Arrays.toString(a));
    }
    public static void sortColors(int[] nums) {
        // 记录0,1,2的个数
        int num0 = 0, num1 = 0, num2 = 0;
        // 计算各个数字出现的次数
        for (int i : nums) {
            switch(i) {
                case 0:
                    num0++;
                    break;
                case 1:
                    num1++;
                    break;
                case 2:
                    num2++;
                    break;
            }
        }
        System.out.println(num0);
        System.out.println(num1);
        System.out.println(num2);
        // 重新赋值
        for (int i = 0; i < nums.length; i++) {
            if (i < num0) {
                nums[i] = 0;
            } else if (i < num0+num1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }


    //方法二：单指针
    // 思路与算法
    // 我们可以考虑对数组进行两次遍历。在第一次遍历中，我们将数组中所有的 0 交换到数组的头部。
    // 在第二次遍历中，我们将数组中所有的 1 交换到头部的 0 之后。此时，所有的 2 都出现在数组的尾部，这样我们就完成了排序。
    //
    public static void sortColors1(int[] nums) {
        int n = nums.length;
        int p = 0;//指针

        //我们将数组中所有的 0 交换到数组的头部。
        for (int i = 0; i < n;i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }//这个for循环走完之后，p指针前面的数组内元素已经全变成0了，下个循环直接从p指针开始交换就行


        //将数组中所有的 1 交换到头部的 0 之后。此时，所有的 2 都出现在数组的尾部，这样我们就完成了排序
        for (int j = p;j < n;j++) {
            if (nums[j] == 1){
            int temp = nums[j];
            nums[j] = nums[p];
            nums[p] = temp;
            p++;
           }
         }
    }

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //冒泡排序
public class Main {
    public static void main(String[] args) {
        int[] arr = {45,554,54,52,47,49,7,5};
        System.out.println("==================排序前==================");
        print(arr);

        bubblesort(arr);

        System.out.println("==================排序后===================");
        print(arr);
    }
   
    /*
    
    排序结果：
    ==================排序前==================
    45 554 54 52 47 49 7 5 
    第1趟：45 54 52 47 49 7 5 554 
    第2趟：45 52 47 49 7 5 54 554 
    第3趟：45 47 49 7 5 52 54 554 
    第4趟：45 47 7 5 49 52 54 554 
    第5趟：45 7 5 47 49 52 54 554 
    第6趟：7 5 45 47 49 52 54 554 
    第7趟：5 7 45 47 49 52 54 554 
    ==================排序后===================
    5 7 45 47 49 52 54 554 

 */

    private static void bubblesort(int[] arr) {
        //如果为空数组或者数组元素只有一个，无需排序
        if (arr == null || arr.length == 1) {
            return;
        }

        //外层循环表示趟数
        for (int i = 0 ; i < arr.length-1;i++) {

            //每一趟进来都默认有序，如果交换说明无序
            boolean isSorted = true;

            //j表示要比较的元素对的第一个元素，i为几说明最后几个元素已经排序好，
            // 因此判断要减去i，无需再对已经排序好的元素进行重复比较
            for (int j = 0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    isSorted = false;
                }
            }
            //如果走到这里，说明结束了第i趟排序，但是未发生交换，则说明已经有序，
            // 不用在进行下一趟结束趟数的循环
            if (isSorted) {
                break;
            }

            //把每一趟排序都打印一遍
            System.out.print("第"+(i+1)+"趟：");
            print(arr);
        }
    }

    //交换
    private static void swap(int[]arr,int i,int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }
    // 打印数组
    public static void print(int[] arr) {
        if (arr == null) {
            return;
        }

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /*
     交换数组0号下标和1号下标的值
 */
public class Code1 {
    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(Arrays.toString(a));
        int[] b = exchangeAB(a);
        System.out.println(Arrays.toString(b));
    }
    /*
    交换前 [1, 2]
    交换后 [2, 1]
    */
    public static int[] exchangeAB(int[] AB) {
        int temp = AB[0];
        AB[0] = AB[1];
        AB[1] = temp;
        return AB;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
    格雷码：任意两个相邻的代码只有一位二进制数不同
        要求：编写一个函数
             以递归的方式生成N位格雷码
             给定一个整数n，返回n位的格雷码

       测试案例：输入 1       返回["0","1"]

     解题思路：任意两个相邻的代码只有一位二进制数不同，即：
    当 n == 1 的时候，格雷码为：["0", "1"]
    当 n == 2 的时候，格雷码为：["00", "01", "11", "10"]
    当 n == 3 的时候，格雷码为：["000", "001", "011", "010", "110", "111", "101", "100"]
    发现：n每次增加一，格雷码的数量就多一倍
    要知道n=2时的格雷码，只需要知道n=1的格雷码
    然后将1的格雷码正序一下，再倒序一下
    然后在前面一半第一个数字前加上0
    后面一半的第一个数字前面加上1

*/

public class Code2 {
    public static void main(String[] args) {
        for (int i = 1;i<6;i++) {
            String[] a = getGray(i);
            System.out.println(Arrays.toString(a));
        }

        //数组逆序法一：
        int[] i = {1,25,78,9};
        System.out.println(Arrays.toString(i));
        System.out.println("===========================逆序前===================================");
        int[] j = new int[i.length];
        for (int a = 0;a < i.length;a++) {
            j[a] = i[i.length-1-a];
        }
        System.out.println(Arrays.toString(j));
        System.out.println("===========================逆序后=====================================");
        
        /*
            [1, 25, 78, 9]
            ===========================逆序前===================================
            [9, 78, 25, 1]
            ===========================逆序后=====================================
            
        */

        //数组逆序法二：
        int[] x = {1,25,9978,9};
        System.out.println(Arrays.toString(x));
        System.out.println("===========================逆序前===================================");
        int[] y = new int[x.length * 2];
        for (int a = 0;a < x.length;a++) {
            y[a] = x[a];
            y[y.length-1-a] = x[a];
        }
        System.out.println(Arrays.toString(y));
        System.out.println("============================逆序后====================================");
        
        /*
          [1, 25, 9978, 9]
          ===========================逆序前===================================
          [1, 25, 9978, 9, 9, 9978, 25, 1]
          ============================逆序后====================================
        */
    }
    

    //暴力解法的优化
    public static String[] getGray(int n) {
        if (n ==1 ){
            return new String[] {"0","1"};
        }
        else{
            String[] preArr = getGray(n-1);
            //要算n个格雷码，先算上一个格雷码
            String[] curArr = new String[2*preArr.length];
            //需要上一个的二倍的长度来存当前的格雷码
            for(int i =0; i<preArr.length; i++){
                curArr[i] = "0"+preArr[i];
                //在前面的一半之前加零
                curArr[curArr.length-1-i] = "1"+preArr[i];
                //在后面的一半之后加1
            }
            return curArr;
        }
    }
    
    //   暴力解法一：
     public static String[] getGray(int n) {
        if (n==1) {
            return new String[]{"0","1"};
        }else {
            //要求第n个格雷码，先求出第n-1个格雷码
            String[] preArr = getGray(n-1);

            //当前保存格雷码数组的长度为上一个格雷码数组长度的2倍
            String[] curArr = new String[preArr.length * 2];

            //前面一半第一个数字前加上0
            for (int i = 0 ;i < preArr.length;i++) {
                curArr[i] = "0" + preArr[i];
            }

            //先将preArr逆序一遍
            String[] newArr = new String[preArr.length];
            for (int i= 0 ; i < preArr.length ;i++) {
                newArr[i] = preArr[preArr.length-1-i];
            }
            //后面一半的第一个数字前面加上1
            int j = 0;
            for (int i = preArr.length;i < curArr.length;i++) {
                curArr[i] = "1" + newArr[j++];
            }
           return curArr;
        }
  }

    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
/*
   题目描述
        美国总统奥巴马不仅呼吁所有人都学习编程，甚至以身作则编写代码，成为美国历史上首位编写计算机代码的总统。
        2014年底，为庆祝“计算机科学教育周”正式启动，奥巴马编写了很简单的计算机代码：在屏幕上画一个正方形。现在你也跟他一起画吧！

        输入
        多组输入，每组数据一行，每行给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。

        输出
        输出由给定字符C画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%（四舍五入取整）。
        每组数据后空一行

        样例输入
        10 a
        样例输出
         aaaaaaaaaa
         a        a
         a        a
         a        a
         aaaaaaaaaa
 */
public class Main {
    //方法一：
    //每种方法的输入输出是一样的，然后这种方法需要分输入的是奇数还是偶数。若偶数要输出行数为列数的一半；
    //而若输入的是奇数，那么由于50%并且四舍五入，所以行数永远是列数的一半抹去小数加一，即int类型的除法
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNext()) {
            n = sc.nextInt();
            String str = sc.next();
            char c = str.charAt(0);
            //输入为偶数的情况下
            if(n%2==0) {
                //行数
                for(int i=0;i<n/2;i++) {
                    //如果是第一行或者最后一行，要打印n个字符
                    if(i==0||i==n/2-1) {
                        for(int j=0;j<n;j++)
                            System.out.print(c);
                     //如果不是第一行或者最后一行，第一列和最后一列输出字符，中间全部是空格
                    }else {
                        for(int j=0;j<n;j++) {
                            if(j==0||j==n-1)
                                System.out.print(c);
                            else
                                System.out.print(" ");
                        }
                    }
                    //每行打印完了要换到下一行
                    System.out.println();
                }

             //输入为奇数的情况下
            }else {
                for(int i=0;i<n/2+1;i++) {
                    if(i==0||i==n/2) {
                        for(int j=0;j<n;j++)
                            System.out.print(c);
                    }else {
                        for(int j=0;j<n;j++) {
                            if(j==0||j==n-1)
                                System.out.print(c);
                            else
                                System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println();
        }
        sc.close();
    }

    //方法2：
    //这种方法由于四舍五入，按照int类型的计算，就不用区分奇偶数。
    // 就可以直接得到行数，行数为列数n加1然后除以2，不用分类，减少代码长度。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNext()) {
            n = sc.nextInt();
            //单个字符的输入好像不符合语法
            //先定义字符串输入
            //然后将第一个字符放入字符型数据拿到
            String str = sc.next();
            char c = str.charAt(0);
            //表示输出行数
            //例如 由于四舍五入，则偶数：n=10,行数就为11/2=5， 奇数：n=9时，行数为10/2=5
            for(int i=0;i<(n+1)/2;i++) {
                //第一行和最后一行输出
                if(i==0||i==(n+1)/2-1) {
                    for(int j=0;j<n;j++)
                        System.out.print(c);
                    //每行的换行
                    System.out.println();
                }
                else {
                    //中间行数的输出
                    for(int j=0;j<n;j++) {
                        if(j==0||j==n-1)
                            System.out.print(c);
                        else
                            System.out.print(" ");
                    }
                    //每行的换行
                    System.out.println();
                }
            }
            //每组之间的换行
            System.out.println();
        }
    }
}

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
/*
        请设计一个算法完成两个超长正整数的加法。
        输入参数：
        String addend：加数
        String augend：被加数
        返回值：加法结果
               public String AddLongInteger(String addend, String augend)
                {
                /在这里实现功能/
                return null;
                }
                输入描述:
                输入两个字符串数字
                123456789123456789 123456789123456789

                输出描述:
                246913578246913578
                输出相加后的结果，string型

 */

public class Code2 {

    //法一：
    //Java语言处理该问题，优势比较大，参考BigInteger类就可以处理。核心API考察，
    //如果API限制，可以考虑采用字符串解析处理。
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String addend = in.nextLine();
        String augend = in.nextLine();
        BigInteger a = new BigInteger(addend);
        BigInteger b = new BigInteger(augend);
        System.out.println(a.add(b));
    }


    //法二：
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String addend = in.nextLine();
        String augend = in.nextLine();
        String s = add(addend,augend);
        System.out.println(s);
    }

    private static String add(String addend, String augend) {
        int len1 = addend.length();
        int len2 = augend.length();
        int[] a = new int[1000];
        int[] b = new int[1000];
        //因为两个数相加字符串后面的位数小，应该先加，所以讲字符串逆序存入数组
        //将字符串1的字符逆序取出减去0字符就是该字符对应的数字，存入a数组
        for (int i = 0;i < len1;i++) {
            a[i] = addend.charAt(len1-1-i)-'0';
        }
        //将字符串1的字符逆序取出减去0字符就是该字符对应的数字，存入a数组
        for (int i = 0; i < len2;i++) {
            b[i] = addend.charAt(len2-1-i)-'0';
        }

        //取串1和串2长度的最大值，将两个字符串各位上的字符相加，和超过十的向前进一位，本位存取余10的值
        int len = Math.max(len1,len2);
        for (int i =0; i<len;i++) {
            a[i] = a[i] + b[i];
            if (a[i]>=10) {
                a[i] = a[i]%10;
                a[i+1] = a[i+1]+1;
            }
        }

        //如果a[len]>0,说明第len位进了一位，字符串长度变成了len+1，应该拼接上len+1位的数
        StringBuffer sb = new StringBuffer();
        if (a[len] > 0) {
            sb.append(a[len]);
        }
        //此时在将得到的数逆序存入sb，即得到相加的结果
        for (int i = len-1;i>=0;i--) {
            sb.append(a[i]);
        }

        return sb.toString();


    }

}
   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /*
           给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。
        目标是使得最后得到的数尽可能小（注意0不能做首位）。
        
        例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
        
        现给定数字，请编写程序输出能够组成的最小的数。
        输入描述:
        每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，
        顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
        格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
        
        输出描述:
        在一行中输出能够组成的最小的数。
        
        输入：2200030010：即两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558
        输出：10015558
 */


//思路 ：找到所给数字中非零并且最小的数，让它为数字最高位，，
//然后将剩余元素从小到大依次添加
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            //用数组存，数组内元素值代表数字0-9的个数
            int[] nums = new int[10];
            for(int i = 0;i<10;i++){
                nums[i] = in.nextInt();
            }
            System.out.println(GetNum(nums));
        }
    }
        public static String GetNum( int[] nums) {
            //找到所给数字中非零并且最小的数，让它为数字最高位
            //因为是顺序表示我们拥有数字0、数字1、……数字9的个数，所以数组中下标1代表的就是数字1的个数，
            // 从1开始找，找到直接break并且数组i下标减一
            String s = "";
            for(int i = 1; i<10;i++){
                if(nums[i] != 0){
                    s += i;
                    nums[i] --;
                    break;
                }
            }
            //找到最小值放在最高位后，然后将剩余元素从小到大依次添加，外层循环代表数字0-9，内层循环数字0-9分别的个数
            for(int i = 0;i<10;i++){
                while(nums[i] != 0){
                    s += i;
                    nums[i] --;
                }
            }
            return s;
        }
}
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
    例如：
    1^3=1
    2^3=3+5
    3^3=7+9+11
    4^3=13+15+17+19
    输入描述:
    输入一个int整数
    输出描述:
    输出分解后的string
 */

public class Main2 {

    //思路1：每一行第一个数都为 n*n-n+1

    public static void main1(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num[] = new int[n];
        int i = n * n - n + 1;
        num[0] = i;
        System.out.println(Arrays.toString(num));//n=6时：[31, 0, 0, 0, 0, 0]
        for (int j = 1; j < n; j++) {
            i += 2;
            num[j] = i;
        }
        System.out.println(Arrays.toString(num));//n=6时：[31, 33, 35, 37, 39, 41]
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < n - 1; j++) {
            sb.append(num[j]);
            sb.append("+");
        }
        sb.append(num[n - 1]);
        System.out.println(sb.toString());//n=6时：31+33+35+37+39+41
    }

   //方法2：
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            StringBuffer sb = new StringBuffer();
            int mid = n * n;
            if (mid % 2 == 1) {
                int count = (n - 1) / 2;
                for (int i = count; i >= 0; i--) {
                    sb.append(mid - i * 2);
                    sb.append("+");
                }
                for (int i = 1; i < count; i++) {
                    sb.append(mid + i * 2);
                    sb.append("+");
                }
                sb.append(mid + count * 2);
            }
            else {
                int count = n / 2;
                for (int i = count - 1; i >= 0; i--) {
                    sb.append(mid - i * 2 - 1);
                    sb.append("+");
                }
                for (int i = 0; i < count - 1; i++) {
                    sb.append(mid + i * 2 + 1);
                    sb.append("+");
                }
                sb.append(mid + (count - 1) * 2 + 1);
            }
            System.out.println(String.valueOf(sb));
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //编写一个函数，将两个数字相加，不得使用+或者其他数字运算符
//给定两个int A 和 B,返回A+B的值
//测试样例 1,2   返回 3

/*
           分析：这又是一道考察发散思维的很有意思的题目。当我们习以为常的东西被限制使用的时候，如何突破常规去思考，就是解决这个问题的关键所在。
        看到的这个题目，首先我们可以分析人们是如何做十进制的加法的，比如是如何得出5+17=22这个结果的。
        实际上，我们可以分成三步的：
        第一步只做各位相加不进位，此时相加的结果是12（个位数5和7相加不要进位是2，十位数0和1相加结果是1）；
        第二步做进位，5+7中有进位，进位的值是10；第三步把前面两个结果加起来，12+10的结果是22，刚好5+17=22。
        对数字做运算，除了四则运算之外，也就只剩下位运算了。位运算是针对二进制的，我们也就以二进制再来分析一下前面的三步走策略对二进制是不是也管用。

        5的二进制是101，17的二进制10001。还是试着把计算分成三步：
        第一步各位相加但不计进位，得到的结果是10100（最后一位两个数都是1，相加的结果是二进制的10。这一步不计进位，因此结果仍然是0）；
        第二步记下进位。在这个例子中只在最后一位相加时产生一个进位，结果是二进制的10；
        第三步把前两步的结果相加，得到的结果是10110，正好是22。由此可见三步走的策略对二进制也是管用的。

        接下来我们试着把二进制上的加法用位运算来替代。
        第一步不考虑进位，对每一位相加。0加0与 1加1的结果都0，0加1与1加0的结果都是1。我们可以注意到，这和异或的结果是一样的。
        接着考虑第二步进位，对0加0、0加1、1加0而言，都不会产生进位，只有1加1时，会向前产生一个进位。此时我们可以想象成是两个数先做位与运算，然后再向左移动一位。只有两个数都是1的时候，位与得到的结果是1，其余都是0。
        第三步把前两个步骤的结果相加。如果我们定义一个函数Add（），第三步就相当于输入前两步骤的结果来递归调用自己。
 */
public class Main {
    public static void main(String[] args) {
        int i = 20;
        int j = 98;
        int ret = addAB(i, j);
        System.out.println(ret);
    }

    static int sum = 0;
    static int tmp = 0;

    public static int addAB(int A, int B) {

        if (B == 0) {
            return A;
        } else {
            //第一步，相加不进位
            sum = A ^ B;
            //第二步，求得进位的值
            tmp = (A & B) << 1;
            //第三步，sum和tmp相加
            return addAB(sum, tmp);
        }
    }

