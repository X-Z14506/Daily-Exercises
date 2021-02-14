package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:21:48
 */

/*
    KiKi开始学习英文字母，BoBo老师告诉他，有五个字母A(a), E(e), I(i), O(o),U(u)称为元音，其他所有字母称为辅音，请帮他编写程序判断输入的字母是元音（Vowel）还是辅音（Consonant）。
    输入描述:
    多组输入，每行输入一个字母。
    输出描述:
    针对每组输入，输出为一行，如果输入字母是元音（包括大小写），输出“Vowel”，如果输入字母是非元音，输出“Consonant”。

 */

public class Main35 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            if(isWhat(s)){
                System.out.println("Vowel");
            }else{
                System.out.println("Consonant");
            }
        }
    }
    public static boolean isWhat(String x){
        String a[]={"A","a","E","e","I","i","O","o","U","u"};
        for(int i=0;i<a.length;i++){
            if(x.equals(a[i]))
                return true;
        }
        return false;
    }
}
