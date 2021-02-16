package firstStage03;

import javax.security.sasl.SaslClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-05
 * Time:21:51
 */

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
