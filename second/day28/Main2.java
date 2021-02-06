package second.day28;

import javax.print.DocFlavor;
import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-05
 * Time:19:56
 */

/*
简单错误记录
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        Map<String,String> map = new HashMap<>();
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(" ");
            //正则表达式中的反斜杠"\\\\"
            String[] dirName = s[0].split("\\\\");
            int n = dirName.length;
            String fileName = dirName[n-1];
            //System.out.println(Arrays.toString(fileName));
            //没有这个错误，直接放入map
            if (!map.containsKey(fileName)) {
                map.put(fileName,s[1]);
                count++;
            }else if(!map.containsValue(s[1])) {//有这个错误，但是行号不一样，也放入
                map.put(fileName,s[1]);
                count++;
            }else {
                count++;
            }
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String,String> m : entries) {
                System.out.println(m.getKey()+" "+m.getValue()+" "+count);
            }
        }
    }
}
