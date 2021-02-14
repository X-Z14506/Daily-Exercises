package firstStage01;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-29
 * Time:22:02
 */
    public class Main37{
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in) ;
            while(s.hasNext()) {
                String s1 = s.next();
                if (s1.matches("[A-Z]")){
                    System.out.println(s1.toLowerCase());
                }else {
                    System.out.println(s1.toUpperCase());
                }
            }
        }
    }

