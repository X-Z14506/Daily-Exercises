package first.Day07;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-28
 * Time:12:48
 */

/**
 * ==优先级大于?:
 * ?:计算方向：从右到左
 */
public class Boolean {
    public static void main(String[] args) {
        boolean b=true ? false:true == true ?false:true;
        System.out.println(b);//false
    }

}
