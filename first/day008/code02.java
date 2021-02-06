package first.day008;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-01
 * Time:11:00
 */

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
