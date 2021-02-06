package second.day13;

import com.sun.jmx.snmp.SnmpStringFixed;

import javax.swing.plaf.IconUIResource;
import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-17
 * Time:20:07
 */

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