



/*
            题目描述：

            一个百万富翁遇到一个陌生人，陌生人找他谈了一个换钱的计划。该计划如下：我每天给你10 万元，你第一天给我1 分钱，第二天2 分钱，
            第三天4 分钱……这样交换 30 天后，百万富翁交出了多少钱？陌生人交出了多少钱？（注意一个是万元，一个是分）

            输入：

            该题没有输入

            输出：

            输出两个整数，分别代表百万富翁交出的钱和陌生人交出的钱，富翁交出的钱以万元作单位，陌生人交出的钱以分作单位。


            分析：
            题目要求输出富翁用万元作单位，陌生人用分作单位，但判断正好是相反的！！
            pow函数返回的是double类型的，需要进行强制类型转换
            (int)pow(2, 30);
 */
public class Main2 {
    public static void main(String[] args) {
        long money1 = 0;
        long money2 = 0;
        for (int i = 1; i <= 30; i++) {
            money1 += 10;
            money2 += (long)Math.pow(2,i-1);
        }
        System.out.println(money1+"万元"+ " " + money2+"分");//300万元 1073741823分
    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
    题目描述：
        一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
        在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。

        给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
        输入描述：
        输入一个string型基因序列，和int型子串的长度。
        输出描述：
        找出GC比例最高的子串，如果有多个输出第一个的子串。

        示例：输入AACTGTGCGACCTGA
                5，
             输出GCACG

        思路：
        由题可知，A+C+G+T=n。因此，求G:C最高，即求在长度为n的字符串里出现G和C次数最多的子串。
        从输入字符串下标为0的位置开始，依次遍历n个字符，记录出现C或G的次数，
        如果高于之前记录的最大值，则更新最大出现次数和最大子串开始的下标(i)。
 */

public class Main {

    //方法一
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = in.nextInt();
        List<String> list = new ArrayList<>();

        //StringBuilder sb = new StringBuilder(str);
        //遍历基因序列，找出所有子序列
        for (int i = 0; i < str.length() - n + 1; i++) {
            if (str.charAt(i) == 'G' || str.charAt(i) == 'C') {
                String s = str.substring(i, i + n);
                list.add(s);
            }
        }
        System.out.println(list);//[CTGTG, GTGCA, GCACG, CACGA, CGACC, GACCT, CCTGA]
        int preMax = 0;
        int preMaxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int max = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'G' || s.charAt(j) == 'C') {
                    max++;
                }
            }
            if (max > preMax) {
                preMax = max;
                preMaxIndex = i;
            }
        }
        System.out.println(str.substring(preMaxIndex, preMaxIndex + n));//CTGTG
        System.out.println(list.get(preMaxIndex));//GCACG
    }

       /* Map<String,Integer> map = new HashMap<>(list.size());
        //遍历List，将list存的东西放入map
        for (int i = 0; i < list.size();i++) {
            String s = list.get(i);
            int count = 0;
            for (int j = 0;j < s.length();j++) {
                if (s.charAt(j) == 'G' || s.charAt(j)=='C'){
                    count++;
                }
            }
            map.put(s,count);
        }
        System.out.println(map);*/

        //方法二：优化后
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            String str=sc.next();
            int n=sc.nextInt();
            int max=0;
            int maxIndex=0;
            //String res="";
            for(int i=0;i<=str.length()-n;i++){
                //String sub=str.substring(i,i+n);//截取子串
                int count=0;
                for(int j=i;j<i+n;j++){
                    if(str.charAt(j)=='C'||str.charAt(j)=='G'){
                        count++;
                    }
                    if(count>max){
                        max=count;
                        maxIndex=i;
                    }
                }
            }
            System.out.println(str.substring(maxIndex,maxIndex+n));
        }


}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
        题目描述
        操作给定的二叉树，将其变换为源二叉树的镜像。
        二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5

    	解题思路：
        1、找到不为空的节点。
        2、然后交换左右节点。
        3、递归调用此函数。
 */

public class Code2 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void Mirror(TreeNode root) {
        //1.如果根节点不为空并且左右子树节点不全为空，交换左右子树节点的值
        if (root!=null&&(root.left!=null||root.right!=null)) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            //2.在分别递归左右子树，交换其左右子节点的值
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
           问题描述：
            给定一个正整数N代表火车数量，0 <N <10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。序列号。

            输入描述：

            有多组测试用例，每一组第一行输入一个正整数N（0 <N <10），第二行包括N个正整数，范围为1到9。

            输出描述：

            输出以字典序从小到大排序的火车出站序列号，每个编号以空格替换，每个输出序列换行，具体见sample。
            示例1
            输入
            3
            1 2 3
            输出
            1 2 3
            1 3 2
            2 1 3
            2 3 1
            3 2 1

            分析：
            思路为用三个变量分别存储：
            待进站火车
            站中火车（用 Stack 存储）
            已出站火车

            具体实现思路：

            第一种：
            采用递归的方法，递归函数的参数为当前待进站火车、站中火车、已出站火车的值所组成的三元组，递归结束条件 是，未进站火车和站中火车均为空 ，
            此时输出已出站火车即为所有出站的一种可能，递推关系为对于当前情况有让下 一辆火车进站或让站中的一辆火车出站两种可能，对于两种可能分别调用递归函数，即可得出问题的解。

            第二种：
            采用先对火车编号进行排列组合，计算出所有可能的出站情况。但是火车出站的情况需要满足栈的出栈顺序，所以通
            过 火车编号的顺序 ， 排列组合的顺序 进行出栈和入栈来比较排列组合中的
            一组顺序是否满足条件，如果满足，则该排 序就是有效的出栈顺序。
 */
public class Code1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //输入火车数量
            int n = in.nextInt();
            //输入火车编号
            int[] A = new int[n];
            for(int i=0;i<n;i++){
                A[i] = in.nextInt();
            }
            int start = 0;
            //计算n个火车的出站的编号的排列组合
            ArrayList<int[]> result = new ArrayList<int[]>();
            Permutation(A,start,n,result);
            //出栈的结果，一个元素一个记录，例如：1 2 3 ； 1 3 2
            Set<String> sortResult = new TreeSet<String>();
            //循环排列组合
            for(int[] out : result){
                //判断是否满足出栈要求（后进先出）
                if(isLegal(A,out,n)){
                    //满足的组合，输入结果，每一个编号用空格分隔
                    StringBuilder sb = new StringBuilder();
                    for(int i=0;i<n-1;i++){
                        sb.append(out[i]+" ");
                    }
                    sb.append(out[n-1]);
                    sortResult.add(sb.toString());
                }
            }
            //最后输出所有的符合出栈要求的组合
            for(String list:sortResult){
                System.out. println(list);
            }
        }
        in.close();
    }
    /*in : 火车编号数组
    out : 火车出站顺序
    n : 火 车 数 量
    */
    private static boolean isLegal(int[] in,int[] out,int n){
        //栈：存储进站的火车编号
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int i=0; int j=0;
        while(i<n){
            // in 还有元素的时候都需要判断
            if(in[i] == out[j]){
                //相等时候就不用入栈，直接后移
                i++;
                j++;
            }else{
                if(stack.isEmpty()){
                    //空stack 就只有入栈了
                    stack.push(in[i]);
                    i++;
                }else{
                    int top = stack.peek();
                    // 栈顶元素相等，进行出栈
                    if(top==out[j]){
                        j++;
                        stack.pop();
                    }else if(i<n){
                        //不相等时候入栈，说明还有待进站的车
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        while(!stack.isEmpty() && j<n){
            // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素相同
            int top = stack.pop();
            if(top == out[j]){
                j++;
            }else{
                return false;
            }
        }
        return true;
    }

    private static void Permutation(int[] A,int start,int n,ArrayList<int[]> result){
        if(start == n){
            return;
        }
        if(start == n-1){
            int[] B = A.clone();
            result.add(B);
            return;
        }
        for(int i=start;i<n;i++){
            swap(A,start,i) ;
            Permutation(A,start+1,n,result);
            swap(A,start,i);
        }
    }
    private static void swap(int[] A,int i,int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
    问题描述：
    本题要求读入 N 名学生的成绩，将获得某一给定分数的学生人数输出。

    输入格式：
    输入在第 1 行给出不超过 10​5​​ 的正整数 N，即学生总人数。随后一行给出 N 名学生的百分制整数成绩，中间以空格分隔。最后一行给出要查询的分数个数 K（不超过 N 的正整数），随后是 K 个分数，中间以空格分隔。

    输出格式：
    在一行中按查询顺序给出得分等于指定分数的学生人数，中间以空格分隔，但行末不得有多余空格。

    输入样例：
    10
    60 75 90 55 75 99 82 90 75 50
    3 75 90 88

    输出样例：
    3 2 0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        List list = new ArrayList();
        while (n!=0&&in.hasNext()) {
            for (int i=0;i<n;i++) {
                int score = in.nextInt();
                list.add(score);
//                list.add(" ");
            }
            int size = list.size();
            int setScore = in.nextInt();
            for (int i = 0;i < size;i++) {
                if (list.get(i).equals(setScore)) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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


    //非递归版：

    /*
     *两个数异或：相当于每一位相加，而不考虑进位；
     *两个数相与，并左移一位：相当于求得进位；
     *将两个新得到的数进行add操作，得到的结果和原本两个数相加相同，
     *这样会把num2变得越来越小，知道为0是，则两个数的和直接就变成num1.
     */

    int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;

    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
    public static int[] exchangeAB(int[] AB) {
        int temp = AB[0];
        AB[0] = AB[1];
        AB[1] = temp;
        return AB;
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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

        //当f2大于n时，这说明n左右两个最近的斐波那契数即为f1和f2,求得f1到n的距离和f2到n的距离，二者谁最小谁就是最小步数
        //若循环终止条件变成f1<n，则n右边的斐波那契数为f1，n左边的斐波那契数无从得知
        //若循环终止条件变成f3<n, 则多计算了
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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




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




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



//TopK问题：找出n个数里最小的k个
public class code02 {
    public static void main1(String[] args) {
        int[] arr = {3,9,6,8,-10,7,-11,19,30,12,23};
        int k = 5;
        int[] ret = new int[100];
        ret = smallestK(arr,k);
        System.out.println(Arrays.toString(ret));
    }

    private static int[] smallestK(int[] arr , int k) {
        //检查数组是否为空，或者k是否小于等于0
        if (arr == null||k <= 0 ) {
            return null;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length);
        //将数组中的元素放到优先级队列里面
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        //检查优先级队列里面的顺序
//        for (int i = 0; i < arr.length;i++) {
//            System.out.println(priorityQueue.poll()+" ");
//        }
        //将优先级队列里面的前k个数弹出存到一个结果数组中
        int[] ret = new int[k];
        for (int i = 0 ; i < priorityQueue.size();i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }

    public static void main2(String[] args) {
        Scanner in  = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while (in.hasNextInt()) {
            String str = in.nextLine();
            String[] strings = str.split(" ");
            int k = Integer.parseInt(strings[strings.length-1]);
            for (int i = 0; i<strings.length-1;i++) {
                int e = Integer.parseInt(strings[i]);
                priorityQueue.add(e);
            }
            int[] ret = new int[k];
            for (int i = 0 ;i < k; i++){
                ret[i] = priorityQueue.poll();
            }
            System.out.println(Arrays.toString(ret));
        }
    }

    public static void main11(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        while(scanner.hasNextInt()) {
            String str = scanner.nextLine();
            String[] string = str.split(" ");
            for (int i = 0; i < string.length; i++) {
                int tmp = Integer.parseInt(string[i]);
                list.add(tmp);
            }
            int ans = list.remove(list.size()-1);
            list.sort(Integer::compareTo);
            for (int i = 0; i < ans ; i++) {
                System.out.print(list.get(i));
                if(i < ans-1) {
                    System.out.print(" ");
                }
            }
        }
    }
    public static void main5(String[] args){
        int ARRAYLENGTH = 8;  //指定数组长度
        int a[] = new int[ARRAYLENGTH];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组，并以回车结束：");
        for(int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        //直接打印数组a出来的是数组的首地址，必须用toString方法
        System.out.println("数组a为:" + Arrays.toString(a));
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextInt());
            if (scanner.nextInt()==-1) {
                break;
            }
        }
        int k=list.get(list.size()-1);
        list.remove(list.size()-1);
        int [] array=new int[list.size()];
        for(int i=0;i<list.size();i++){
            array[i]=list.get(i);
        }
        Arrays.sort(array);
        for(int i=0;i<k-1;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(array[k-1]);
    }

}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
    题目描述
        KiKi想知道已经给出的三条边a，b，c能否构成三角形，如果能构成三角形，判断三角形的类型（等边三角形、等腰三角形或普通三角形）。
        输入描述:
        题目有多组输入数据，每一行输入三个a，b，c(0<a,b,c<1000)，作为三角形的三个边，用空格分隔。
        输出描述:
        针对每组输入数据，输出占一行，如果能构成三角形，等边三角形则输出“Equilateral triangle!”，等腰三角形则输出“Isosceles triangle!”，
        其余的三角形则输出“Ordinary triangle!”，反之输出“Not a triangle!”。

        输入：2 3 2
             3 3 3
        输出：Isosceles triangle!
             Equilateral triangle!
 */
public class Main38 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] strings = s.nextLine().split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            int c = Integer.parseInt(strings[2]);
            if (a+b>c && a+c>b && b+c>a) {
                if (a==b && b==c) {
                    System.out.println("Equilateral triangle!");
                }else if (a==b || a==c || b==c) {
                    System.out.println("Isosceles triangle!");
                }else {
                    System.out.println("Ordinary triangle!");
                }
            }else {
                System.out.println("Not a triangle!");
            }
        }

    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
        变种水仙花数 - Lily Number：把任意的数字，从中间拆分成两个数字，比如1461 可以拆分成（1和461）,（14和61）,（146和1),
        如果所有拆分后的乘积之和等于自身，则是一个Lily Number。
        例如：
        655 = 6 * 55 + 65 * 5
        1461 = 1*461 + 14*61 + 146*1

        求出 5位数中的所有 Lily Number。

        输入描述:
        无
        输出描述:
        一行，5位数中的所有 Lily Number，每两个数之间间隔一个空格。
 */
public class Main31 {
    public static void main1(String[] args) {
        for (int i = 10000;i <= 99999; i++) {
            //将整数转换为字符串
            String s = Integer.toString(i);
            //求出4种乘法的乘积
            //第一个数字*后四位数字
            int first = Integer.parseInt(s.substring(0,1)) * Integer.parseInt(s.substring(1,5));
            //前两位数字*后三位数字
            int second = Integer.parseInt(s.substring(0,2)) * Integer.parseInt(s.substring(2,5));
            //前三位数字*后两位数字
            int third = Integer.parseInt(s.substring(0,3)) * Integer.parseInt(s.substring(3,5));
            //前四位数字*最后一个数字
            int fourth = Integer.parseInt(s.substring(0,4)) * Integer.parseInt(s.substring(4,5));

            //判断是否为Lily Number
            if (first+second+third+fourth == i) {
                System.out.print(i+" ");//14610 16420 23610 34420 65500
            }
        }
    }

    public static void main(String[] args) {
        int a, b, c, d, e;
        int r1, r2, r3, r4;

        for (int i = 10000; i < 99999; i++) {
            r1 = (i / 10000) * (i % 10000);
            r2 = (i / 1000) * (i % 1000);
            r3 = (i / 100) * (i % 100);
            r4 = (i / 10) * (i % 10);

            if (i == (r1 + r2 + r3 + r4)) {
                System.out.print(i);
                System.out.print(" ");
            }

        }
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
    题目描述
        KiKi非常喜欢网购，在一家店铺他看中了一件衣服，他了解到，如果今天是“双11”（11月11日）则这件衣服打7折，“双12” （12月12日）则这件衣服打8折，
        如果有优惠券可以额外减50元（优惠券只能在双11或双12使用），求KiKi最终所花的钱数。
        输入描述:
        一行，四个数字，第一个数表示小明看中的衣服价格，第二和第三个整数分别表示当天的月份、当天的日期、第四个整数表示是否有优惠券（有优惠券用1表示，无优惠券用0表示）。
        输出描述:
        一行，小明实际花的钱数（保留两位小数）。（提示：不要指望商家倒找你钱）

        输入：1000.0 11 11 1
        输出：650.00
        输入：999.8 12 12 0
        输出：799.84
        输入：66.6 11 11 1
        输出：0.00
 */
public class Main30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        double price = Double.parseDouble(s[0]);
        int month = Integer.parseInt(s[1]);
        int day = Integer.parseInt(s[2]);
        int i = Integer.parseInt(s[3]);

        //当今天是双11时
        if (month==11 && day==11) {
            //有优惠券
            if (i == 1) {
                //如果需要花费的钱减去50小于0即为0.00
                double pay = price*0.7-50 > 0 ? price*0.7-50 : 0.00;
                System.out.println(String.format("%.2f",pay));
            }
            //无优惠券
            if (i == 0) {
                double pay = price*0.7;
                System.out.println(String.format("%.2f",pay));
            }
        }else if (month==12 && day==12) {
            if (i==1) {
                double pay = price*0.8-50 > 0 ? price*0.8-50 : 0.00;
                System.out.println(String.format("%.2f",pay));
            }
            if (i==0) {
                double pay = price*0.8;
                System.out.println(String.format("%.2f",pay));
            }
        }else {
            System.out.println(String.format("%.2f",price));
        }
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
    题目描述
        不使用累计乘法的基础上，通过移位运算（<<）实现2的n次方的计算。

        输入描述:
        多组输入，每一行输入整数n（0 <= n < 31）。
        输出描述:
        针对每组输入输出对应的2的n次方的结果

        输入：2
             10
        输出：4
             1024
 */
    //  <<左移是乘2
//      >>右移是除2


public class Main24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(1<<Integer.parseInt(s));
        }
    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
        题目描述
            根据给出的三角形3条边a, b, c（0 < a, b, c < 100,000），计算三角形的周长和面积。
            输入描述:
            一行，三角形3条边（能构成三角形），中间用一个空格隔开。
            输出描述:
            一行，三角形周长和面积（保留两位小数），中间用一个空格隔开，输出具体格式详见输出样例。

            输入：3 3 3
            输出：circumference=9.00 area=3.90
 */
public class Main21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        double circumference = 0;
        double area = 1;
        for (int i = 0; i < s.length;i++) {
            circumference+=Double.parseDouble(s[i]);
        }
        double p = circumference/2;
        double ret = 1;
        for (int i = 0;i<s.length;i++) {
            ret *= ( p - Double.parseDouble(s[i]));
        }
        ret*=p;
        area = Math.sqrt(ret);
        System.out.println("circumference="+String.format("%.2f",circumference)+" area="+String.format("%.2f",area));

    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
输出一个图形
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *

Process finished with exit code 0

 */
public class Main7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //总共9行
        int lay = input.nextInt();
        //输出前5行
        for (int m = 1; m <= (lay + 1) / 2; m++){
            //每一行先输出空格
            for (int b = 1; b <= (lay + 1) / 2 - m; b++){
                System.out.print(" ");
            }
            //在输出*号
            for (int c = 1; c <= m * 2 - 1; c++){
                System.out.print("*");
            }
            //一行打印完了需要换行
            System.out.println();
        }
        //打印后4行
        for (int d = (lay + 1) / 2 - 1; d >= 1; d--){
            //先打印后四行的空格
            for (int b = 1; b <= (lay + 1) / 2 - d; b++){
                System.out.print(" ");
            }
            //在打印后四行的*号
            for (int c = (lay + 1) / 2 - d; c <= (lay + 1) / 2 - 2 + d; c++){
                System.out.print("*");
            }
            //每行打印完换行
            System.out.println();
        }
    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
        输入一个字符，用它构造一个三角形金字塔。
        输入描述:
        输入只有一行，一个字符。
        输出描述:
        该字符构成的三角形金字塔

        输入：1
        输出：
            1
           1 1
          1 1 1
         1 1 1 1
        1 1 1 1 1
 */
public class Main6 {
    public static void main  (String[] args) throws IOException {
        char c=(char)System.in.read();
        int n = 5;
        for(int i = 1; i <= n; i++){   // 控制行数
            for (int m = 1; m <= n-i; m++) { // 左侧空格
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                if ((j+1)%2 == 0){  // 基数输出1，偶数输出空格
                    System.out.print(c);
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
        BoBo写了一个十六进制整数ABCDEF，他问KiKi对应的十进制整数是多少。
 */
public class Main2 {
    public static void main1(String[] args) {
        String s = "ABCDEF";
        String str = new BigInteger(s,16).toString(10);
        System.out.printf("%15s",str);//       11259375
    }

    public static void main2(String[] args) {
        String s = Integer.valueOf("ABCDEF", 16).toString();
        StringBuilder sb = new StringBuilder(15);
        for (int i = 0; i < 15 - s.length(); i++) {
            sb.append(" ");
        }
        sb.append(s);
        System.out.println(sb);//       11259375
    }

    public static void main3(String[] args) {
        //       11259375
        System.out.println("       "+Integer.parseInt("ABCDEF",16));
    }

    public static void main(String[] args) {
        //       11259375
        System.out.printf("%15s",Integer.parseInt("ABCDEF",16));
    }
}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



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




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
KiKi得到了一个n行m列的矩阵，现在他想知道第x行第y列的值是多少，请你帮助他完成这个任务。

输入描述:
第一行包含两个数n和m，表示这个矩阵包含n行m列。从2到n+1行，每行输入m个整数（范围-231~231-1），
用空格分隔，共输入n*m个数，表示矩阵中的元素。接下来一行输入x和y，用空格分隔，表示KiKi想得到的元素的位置。(1≤x≤n≤10，1≤y≤m≤10)

输出描述:
一行，输出一个整数值，为KiKi想知道的值。

输入：
2 3
1 2 3
4 5 6
1 2

输出：2
 */
public class Main32 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int[][] a = new int[n][m];
        //将n行m列的数全部放入n*m的二维数组中
        for (int i = 0 ;i < n;i++) {
            //每进一次外层循环，读取一行数
            String[] strings1 = reader.readLine().split(" ");
            for (int j = 0;j < strings1.length;j++) {
                a[i][j] = Integer.parseInt(strings1[j]);
            }
        }
       /* System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.toString(a[1]));*/
        String[] strings2 = reader.readLine().split(" ");
        int i = Integer.parseInt(strings2[0]);
        int j = Integer.parseInt(strings2[1]);
        System.out.println(a[i-1][j-1]);
    }
}



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
输入一个班级5个学生各5科成绩，输出5个学生各5科成绩及总分。
输出描述：五行，按照输入顺序每行输出一个学生的5科成绩及总分（小数点保留1位），用空格分隔。


输入：
98.5 96.0 100 99 88
60.5 77 88.5 99 60
80 80.5 89 91 92
93 94 95.5 96 97.5
100 98 88.5 88 78.5

输出：
98.5 96.0 100.0 99.0 88.0 481.5
60.5 77.0 88.5 99.0 60.0 385.0
80.0 80.5 89.0 91.0 92.0 432.5
93.0 94.0 95.5 96.0 97.5 476.0
100.0 98.0 88.5 88.0 78.5 453.0

 */
public class Main31 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        int[] score = new int[5];
        //循环5次，只要读到的不为空，就执行while循环
        while ((string = reader.readLine()) != null) {
            //每进一次循环，给一次sum
            int sum = 0;
            String[] strings = string.split(" ");
            for (int i = 0;i < strings.length;i++) {
                 int score1 = (int)(Double.parseDouble(strings[i])*10);
                System.out.print(score1/10+"."+score1%10+" ");
                sum += score1;
            }
            System.out.println(sum/10+"."+sum%10);
        }
    }
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
输入两个升序排列的序列，将两个序列合并为一个有序序列并输出。

 输入：   5 6
         1 3 7 9 22
         2 8 10 17 33 44

输出：1 2 3 7 8 9 10 17 22 33 44
 */
public class Main30 {

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            //把合并后的数组都放到第一个数组里
            int[] arr1 = new int[n+m];
            int[] arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }
            mergeSort(arr1,arr2,n-1,m-1);
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < arr1.length; i++) {
                res.append(arr1[i]);
                if (i!=arr1.length-1)res.append(" ");
            }
            System.out.println(res.toString());
        }
    }
    //归并排序，合并数组1和数组2
    public static void mergeSort(int[] arr1,int[] arr2,int a,int b){
        if (arr2 == null || arr2.length == 0){
            return;
        }
        int tail = arr1.length-1;
        while(a>=0 && b >=0){
            if (arr1[a]>arr2[b]){
                arr1[tail--] = arr1[a--];
            }else{
                arr1[tail--] = arr2[b--];
            }
        }
        while(a>=0){
            arr1[tail--] = arr1[a--];
        }
        while(b>=0){
            arr1[tail--] = arr2[b--];
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings1 = reader.readLine().split(" ");
        String[] strings2 = reader.readLine().split(" ");
        String[] strings3 = reader.readLine().split(" ");
        int n = Integer.parseInt(strings1[0]);
        int m = Integer.parseInt(strings1[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < strings2.length;i++) {
            list.add(Integer.parseInt(strings2[i]));
        }
        for (int i = 0;i < strings3.length;i++) {
            list.add(Integer.parseInt(strings3[i]));
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.print(i+" ");
        }
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



/*
序列中整数去重
保证按照输入的顺序输出
输入：5
     10 12 93 12 75

输出：10 12 93 75

 */

public class Main29 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = reader.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < strings.length;i++) {
            if (!list.contains(Integer.parseInt(strings[i]))) {
                list.add(Integer.parseInt(strings[i]));
            }
        }
        for (int i : list) {
            System.out.print(i+" ");
        }

       /* //不能用HashSet 或者 TreeSet，因为要按照输入的顺序输出
        Set<Integer> set = new HashSet<>();
        for (int i=0 ;i < strings.length;i++) {
            set.add(Integer.parseInt(strings[i]));
        }
        System.out.println(set);*/
    }
}




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
序列中删除指定数字（所有）

输入：6
     1 2 3 4 5 9
     4

输出：1 2 3 5 9

输入：10
     1 1 2 3 4 4 5 4 9 4
     4
输出：1 1 2 3 5 9
 */

public class Main28 {
    //遍历数组，不需要删除的直接输出，需要删除的元素，continue，跳过输出语句
    public static void main2(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] ns = new int[n];
        String[] str = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            ns[i] = Integer.parseInt(str[i]);
        }

        int s = Integer.parseInt(bf.readLine());//要删除的整数
        for(int i = 0; i < ns.length; i++){
            if(ns[i] == s){
                continue;
                //当条件 ns[i]==s 的时候执行 continue 语句，
                //continue 语句会终止本次循环，循环体中 continue 之后的语句将不再执行，
                //接着进行下次循环，所以输出结果中没有 s。
                //也就相当于删除指定数字
            }
            System.out.print(ns[i] + " ");
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = reader.readLine().split(" ");
        int m = Integer.parseInt(reader.readLine());
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0;i < strings.length;i++) {
            int k = Integer.parseInt(strings[i]);
            //如果k不为要删除的数，放入ints数组
            if ( k != m) {
                list.add(k);
            }
        }
        for (int i : list) {
            System.out.print(i+" ");
        }
    }
}




////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
输入：5
     1 6 9 22 30
     8

输出：1 6 8 9 22 30

 */
public class Main27 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        String[] strings = reader.readLine().split(" ");
        int[] ints = new int[n+1];
        for (int i = 0;i < strings.length;i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int m = Integer.parseInt(reader.readLine());
        ints[n] = m;
        Arrays.sort(ints);
        for (int i = 0;i < ints.length;i++) {
            System.out.print(ints[i]+" ");
        }
    }
}





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*

题目描述
输入一个整数序列，判断是否是有序序列，有序，指序列中的整数从小到大排序或者从大到小排序。
输入描述:
第一行输入一个整数N(3≤N≤50)。
第二行输入N个整数，用空格分隔N个整数。
输出描述:
输出为一行，如果序列有序输出sorted，否则输出unsorted。


输入：5
     1 6 9 22 30
输出：sorted

输入：5
     3 4 7 2 10
输出：unsorted

 */

    //注：升序降序都是有序输出，两种情况都要考虑，不能只考虑一种
public class Main26 {
        public static void main1(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int n = sc.nextInt();
                int pre = sc.nextInt();
                int flag = 0;
                boolean judge = true;
                for (int i = 1; i < n; i++) {
                    int cur = sc.nextInt();
                    //判断是否全部是升序的
                    if (cur - pre >= 0 && flag>=0){
                        flag = 1;
                     //判断是否全部是降序
                    }else if(cur - pre <= 0 && flag<=0){
                        flag = -1;
                    //不是全部升或者降，将判断标志改为false
                    }else{
                        judge = false;
                    }
                    pre = cur;
                }
                if (judge){
                    System.out.println("sorted");
                }else {
                    System.out.println("unsorted");
                }
            }
        }
    //如果一个数比两边的数都大，或者比两边的数都小，则不是有序的，利用数学单调性的思想
    public static void main3(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] str=br.readLine().split(" ");
        int []a = new int[n];
        for(int i = 0; i < str.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        int flag = 0;
        for(int i=1;i<str.length-1;i++) {
            if((a[i]>a[i-1]&&a[i]>a[i+1])||(a[i]<a[i-1]&&a[i]<a[i+1])) {
                flag = 1;
            }
        }
        if(flag == 1) {
            System.out.println("unsorted");
        }
        else {
            System.out.println("sorted");
        }
    }

}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
        root
