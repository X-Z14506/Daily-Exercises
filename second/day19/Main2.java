package second.day19;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-26
 * Time:13:14
 */

/*
地下迷宫
 */
public class Main2 {
    static int n = 0,m=0,maxEnergy=0;
    static int[][] map;
    static boolean flag = false;
    static String path = "";
    static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) {
        int p;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            p = sc.nextInt();
            map = new int[n][m];

            for (int i = 0;i < n;i++) {
                for (int j = 0;j<m;j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            runMap(0,0,p);
            if (flag) {
                System.out.println(path);
            }else {
                System.out.println("Can not escape");
            }
        }
    }

    /**
     * 走迷宫
     * @param x 行
     * @param y 列
     * @param energy 能量
     */
    private static void runMap(int x, int y, int energy) {
        //递归出口，如果边界越界或者能量消耗完或者此路不通
        if (x<0 || y<0 || x>=n || y>=m || energy<0 || map[x][y]!=1) {
            return;
        }
        //此路可行
        else {
            map[x][y] = 2;
            list.add("["+x+","+y+"]");
            if (x==0 && y==m-1) {//到达出口

                /*
                    到出口判断是不是最省能量的路径，如果不是，更新路径，如果是，退出递归，打印路径
                 */
                if (energy>=maxEnergy){//如果该路径剩下了更多的能量，说明该路径消耗更少的能量，更新路径
                    maxEnergy=energy;
                    updatePath();
                }
                //更新完之后，将此处之前改过的值改回去，再沿着之前的路径朝回走
                map[x][y] = 1;
                list.removeLast();
                flag = true;
                return;
            }

            //上行
            runMap(x-1,y,energy-3);
            //右行
            runMap(x,y+1,energy-1);
            //下行
            runMap(x+1,y,energy);
            //左行
            runMap(x,y-1,energy-1);
            //如果上下左右都行不通，则返回上一步
            map[x][y] = 1;
            list.removeLast();
        }
    }

    /**
     * 更新路径
     */
    private static void updatePath() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()+',');
        }
        if (sb.length()>0) {
            sb.deleteCharAt(sb.length()-1);
        }
        path = sb.toString();
    }
}
