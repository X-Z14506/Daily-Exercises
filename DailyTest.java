



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

