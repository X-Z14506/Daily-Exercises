








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
                }
            }
            for (int i : list) {
                System.out.println(i);
            }
        }
    }

}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
小易的升级之路
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(strings1[0]);
            int init = Integer.parseInt(strings1[1]);
            String[] strings2 = sc.nextLine().split(" ");
            for (int i = 0;i < n;i++) {
                int e = Integer.parseInt(strings2[i]);
                if (e <= init) {
                    init+=e;
                }
                if (e > init) {
                    //求最大公约数
                    int temp = init;
                    while (temp>1) {
                        //找到两个数最小值，如果能同时被两个数整除，这个即为最大公约数
                        if (init%temp==0 && e%temp==0) {
                            init+=temp;
                            break;
                        }
                        //如果不能，往下递减，直到找到为止
                        temp--;
                    }
                }
            }
            System.out.println(init);
        }
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
数字分类
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int sum1 = 0;
        List<Integer> A2 = new ArrayList<>();
        int sum2 = 0;
        List<Integer> A3 = new ArrayList<>();
        List<Integer> A4 = new ArrayList<>();
        double sum4 = 0;
        List<Integer> A5 = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        for (int i = 1;i < n;i++){
            int e = Integer.parseInt(strings[i]);
            if (e%5==0 && e%2==0) {
                sum1+=e;

            }else if (e%5==1) {
                A2.add(e);
                if (A2.size()%2!=0) {
                    sum2+=e;
                }else {
                    sum2-=e;
                }

            }else if (e%5==2) {
                A3.add(e);

            }else if (e%5==3) {
                A4.add(e);
                sum4+=e;
            }else if (e%5==4) {
                A5.add(e);
            }
        }
        list.add(0,sum1);
        list.add(1,sum2);
        list.add(2,A3.size());
        double avg4 = sum4/A4.size();
        Collections.sort(A5);
        list.add(3,avg4);
        list.add(4,A5.get(A5.size()-1));
        for (int i = 0;i < 3;i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.print(String.format("%.1f",list.get(3))+" ");
        System.out.print(list.get(4));
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
平衡二叉树

现一个函数，检查二叉树是否平衡，平衡二叉树的定义如下，对于树中的任意 一个结点，
其两颗子树的高度差不超过1。
给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */
public class Main01 {
    
    //判断是不是平衡二叉树
    public boolean isBalance(TreeNode root) {
        if (root==null) {
            return true;
        }
        //左子树高度
        int left = getHeight(root.left);
        //右子树高度
        int right = getHeight(root.right);
        //如果左右子树高度相差<=1，说明为平衡树，接着判断左右子树是否为平衡树
        if (Math.abs(left-right) <= 1) {
            return isBalance(root.left) && isBalance(root.right);
        }else {
            //若左右子树高度相差>1,或者左右子树的高度相差>1，说明不是平衡树
            return false;
        }

    }

    //计算二叉树的高度
    private int getHeight(TreeNode root) {
        if (root==null) {
            return 0;
        }
        //计算左子树的高度
        int leftHeight = getHeight(root.left);
        //计算右子树的高度
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
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





////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
链式A+B（牛客）
 */
public class Main02 {
    public ListNode plusAB(ListNode a, ListNode b) {
         if (a==null) {
             return b;
         }
         if (b==null) {
             return a;
         }
         ListNode head = new ListNode(-1);
         ListNode cur = head;
         ListNode p1 = a;
         ListNode p2 = b;
         int sum = 0;
         while (p1 != null || p2 != null || sum!=0) {
             if (p1!=null) {
                 sum+=p1.val;
                 p1 = p1.next;
             }
             if (p2!=null) {
                 sum+=p2.val;
                 p2 = p2.next;
             }
             cur.next = new ListNode(sum%10);
             sum = sum/10;
             cur = cur.next;
         }
         return head.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
最难的问题（牛客）
 */
    public class Main02 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                char[] chars = s.toCharArray();
                for (int i = 0;i < chars.length;i++) {
                    if ('A' <= chars[i]) {
                        chars[i] = (char) ('E' < chars[i] ? (chars[i]-5) : (chars[i]+21));
                    }
                }
                System.out.println(new String(chars));
            }
        }
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
统计每个月兔子的总数(牛客)
 */
public class Main01 {
    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(reader.readLine());
        int totalCount = getTotalCount(month);
        System.out.println(totalCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int month = sc.nextInt();
            int totalCount = getTotalCount(month);
            System.out.println(totalCount);
        }


    }
    public static int getTotalCount(int monthCount) {
        if (monthCount < 3){
            return 1;
        }else {
           return getTotalCount(monthCount-1)+getTotalCount(monthCount-2);
        }
    }
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*

给定一个string数组p及其大小n，同时给定长字符串string s，请返回一个bool数组，
元素为true或false对应p中的对应字符串是否为s的子串。要求p中的串长度小于等于8，
且p中的串的个数小于等于500，同时要求s的长度小于等于1000。

输入：["a","b","c","d"],4,"abc"
输出：[true,true,true,false]
 */
public class Main1 {
    public static void main(String[] args) {
        String[] p = {"a","b","c","d"};
        int n = 4;
        String s = "abc";
        System.out.println(s.contains("bc"));
        /*System.out.println(s.substring(0,s.length()-1));
        System.out.println(s.subSequence(0,s.length()));
        System.out.println(s.subSequence(0,s.length()-1).equals(p[1]));
        System.out.println(s.subSequence(0,s.length()-1).equals(p[0]));
        System.out.println(s.subSequence(0,s.length()-1).equals(p[2]));
        System.out.println(s.subSequence(0,s.length()-1).equals(p[3]));*/
        Main1 main1 = new Main1();
        boolean[] ret  = main1.chkSubStr(p,n,s);
        System.out.println(Arrays.toString(ret));

    }
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] ret = new boolean[p.length];
        for (int i = 0;i < n;i++) {
            ret[i] = s.contains(p[i]);
        }
        return ret;
    }
}


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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
/*
    题目描述
    洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。
    首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，
    接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，直到最后放下左手的第一张牌。接着把牌合并起来就可以了。 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。
    首先分成两组，左手拿着1,2,3；右手拿着4,5,6。在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，
    就变成了序列1,4,2,5,3,6。 现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。

    输入描述:
    第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，
    接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。表示原始牌组从上到下的序列。

    输出描述:
    对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。
    示例1：
    输入：3（数据组数为3组）
         //第一组
         3 1      1 2 3 4 5 6
         //第二组
         3 2      1 2 3 4 5 6
         //第三组
         2 2      1 1 1 1
    输出：//第一组
         1 4 2 5 3 6
         //第二组
         1 5 4 3 2 6
         //第三组
         1 1 1 1


    思路：
    解法一：模拟洗牌法 * 例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。 * 新建一个ArrayList,
    先加入1，然后4，接着依次加入 2 ， 5 ， 3 ， 6 * 于是1,4,2,5,3,6，这就完成了一次洗牌的过程 * k次洗牌，就把上述过程重复k次

    优点： 直观易懂，模拟题中的洗牌过程。
    缺点： 大量运用arrayList 和数组的数字转移，且for循环次数过多，繁琐

    解法二：预测位置法 * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出 * 根据当前数的位置，可以算出经过一次洗牌后的位置 * 如果当前数小于等于n（即在左手），
    则他下次出现的位置是 1 + (当前位置 - 1) * 2 也就是 2*当前位置-1 * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）

 */
    
public class Main {
    public static void main(String[] args) {
        Main test=new Main();

        //第一种方法
        test.sys();

        //第二种方法
        test.sys1();
    }

    private void sys1() {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int []arr=new int[2*n];
            int i,j;
            for (i=1;i<=2*n;i++){
                int index=i;
                //翻转k次
                for (j=0;j<k;j++){
                    if (index<=n){
                        index=2*index-1;
                    }else {
                        index=(index-n)*2;
                    }
                }
                arr[index-1]=sc.nextInt();
            }

            for (i=0;i<2*n-1;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println(arr[i]);
        }
    }

    private void sys() {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i ++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[2 * n];
            for (int j = 0; j < 2 * n; j ++) {
                arr[j] = sc.nextInt();
            }
            //
            // 翻转k次
            for (int times = 0; times < k; times ++) {
                getRes(arr, arr.length);
            }
            for (int a = 0; a < n * 2 - 1; a ++) {
                System.out.print(arr[a] + " ");
            }
            System.out.println(arr[n * 2 - 1]);
        }
    }

    private void getRes(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n / 2; i ++) {
            list.add(arr[i]);
            list.add(arr[i + n / 2]);
        }
        for (int i = 0; i < n; i ++) {
            arr[i] = list.get(i);
        }
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


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
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

    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
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

    
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
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
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /*
      如何取出Map中的key和value
 */
public class T {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "zhangsan1");
        map.put(6, "zhangsan2");
        map.put(3, "zhangsan3");
        map.put(4, "zhangsan4");
        Set<Integer> keySet = map.keySet();
        //  方法1：
        for (int key : keySet) {
            System.out.println(key + "--->" + map.get(key));
        }
        /*
                1--->zhangsan1
                3--->zhangsan3
                4--->zhangsan4
                6--->zhangsan2
         */

        //方法2：
        for (int key : map.keySet()) {
            System.out.println(key + "-------" + map.get(key));
        }

        /*
        1-------zhangsan1
        3-------zhangsan3
        4-------zhangsan4
        6-------zhangsan2
         */

        //方法3：
        Iterator<Integer> it = keySet.iterator();
        while (it.hasNext()) {
            int key = it.next();
            String value = map.get(key);
            System.out.println(key + "   " + value);
        }

        /*
        1   zhangsan1
        3   zhangsan3
        4   zhangsan4
        6   zhangsan2
         */
    }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

