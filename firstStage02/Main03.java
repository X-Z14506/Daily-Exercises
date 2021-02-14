package firstStage02;

import java.util.Scanner;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:18:05
 */

/*

 */

public class Main03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str = s.nextLine();
            String[] strings = str.split("[+\\-*/]");
           if (strings.length!=2) {
                System.out.println("Invalid operation!");
            }else {
                double a = Double.parseDouble(strings[0]);
                double b = Double.parseDouble(strings[1]);
                double ret = 0;
                if ("+".equals(str.substring(strings[0].length(),strings[0].length()+1))) {
                    ret = a + b;
                    System.out.println(String.format("%.4f",a)+"+"+String.format("%.4f",b)+"="+String.format("%.4f",ret));
                }
                if ("-".equals(str.substring(strings[0].length(),strings[0].length()+1))) {
                    ret = a - b;
                    System.out.println(String.format("%.4f",a)+"-"+String.format("%.4f",b)+"="+String.format("%.4f",ret));
                }
                if ("*".equals(str.substring(strings[0].length(),strings[0].length()+1))) {
                    ret = a * b;
                    System.out.println(String.format("%.4f",a)+"*"+String.format("%.4f",b)+"="+String.format("%.4f",ret));
                }
                if ("/".equals(str.substring(strings[0].length(),strings[0].length()+1))) {
                    if (b==0.0) {
                        System.out.println("Wrong!Division by zero!");
                    }else {
                        ret = a / b;
                        System.out.println(String.format("%.4f",a)+"/"+String.format("%.4f",b)+"="+String.format("%.4f",ret));
                    }
                }
            }
        }
    }
}

//public class Main03{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s = sc.nextLine();
////正则切割
//            String[] str = s.split("[+\\-*/]");
//            if (str.length<2){
////题目已交代了格式是“操作数 运算符 操作数”，所以不需要判断奇葩的不合法情况，例如"1+2:333"”
//                System.out.println("Invalid operation!");
//            }else {
//                double a = Double.parseDouble(str[0]);
//                double b = Double.parseDouble(str[1]);
//                String opt = s.substring(str[0].length(),str[0].length()+1);
//                switch (opt){
//                    case "+":
//                        System.out.printf("%.4f"+opt+"%.4f=%.4f",a,b,a+b);;break;
//                    case "-":
//                        System.out.printf("%.4f"+opt+"%.4f=%.4f",a,b,a-b);;break;
//                    case "*":
//                        System.out.printf("%.4f"+opt+"%.4f=%.4f",a,b,a*b);;break;
//                    default:
//                        if (b==0){
//                            System.out.printf("Wrong!Division by zero!");
//                        }else {
//                            System.out.printf("%.4f"+opt+"%.4f=%.4f",a,b,a/b);
//                        };
//                }
//                System.out.println();
//            }
//        }
//    }
//}