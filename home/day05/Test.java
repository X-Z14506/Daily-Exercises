package home.day05;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-14
 * Time:20:33
 */
public class Test {
    String str=new String("hello");
    char[]ch={'a','b'};
    public static void main(String args[]){
        Test ex=new Test();
        ex.change(ex.str,ex.ch); 
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[]) {
        str="test ok"; ch[0]='c';
    }
}
