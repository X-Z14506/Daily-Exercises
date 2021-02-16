package firstStage03;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-05
 * Time:23:19
 */
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
