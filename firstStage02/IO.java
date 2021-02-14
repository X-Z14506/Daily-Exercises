package firstStage02;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-30
 * Time:23:22
 */
public class IO {

        /**从字节流中获得字符数据：
         * 1. 直接通过字节方式读，然后程序进行字符编码(buffer 大小 < 数据长度/精确控制字符都比较麻烦)
         * 2. 把 Stream 转化为 Reader，进行字符形式读取
         *      2.1 直接读
         *      2.2 BufferedReader      readLine
         * 3. Scanner 也可以
         */
        private static String 从字节流中获得字符数据(InputStream is) throws IOException {

            byte[] buffer=new byte[1024];
            int len=is.read(buffer);
            String message=new String(buffer,0,len,"UTF-8");
            return message;


        /* 第二种：
        Reader reader=new InputStreamReader(is,"UTF-8"); //这里已经转换为字符流了
        char[] buffer=new char[13];
        int len=reader.read(buffer);
        String message=new String(buffer,0,len);
        return message;
               返回的这个message的长度：
                   （1）若缓冲区大小小于文件的长度，那么就读缓冲区大小的字符流
                   （2）若缓冲区大小大于文件的长度，那么就读取文件的大小的字符流
                   （3）字符流包括\r\n，算两个字符
        */

        /* 第三种：
        Scanner sc=new Scanner(is,"UTF-8");
        return sc.nextLine();
        */

        /* 第四种：
        StringBuilder sb=new StringBuilder();
        Reader reader=new InputStreamReader(is,"UTF-8");  //将字节流转换为字符流
             //Reader里面没有readLine()方法
        int len;
        char[] buffer=new char[10];
        while((len=reader.read(buffer))!=-1){
            sb.append(buffer,0,len);
        }
        return sb.toString();
        */

        /* 第五种：
        StringBuilder sb=new StringBuilder();
        Reader reader=new InputStreamReader(is,"UTF-8");
        BufferedReader bufferedReader=new BufferedReader(reader);
              //BufferedReader里面有readLine()方法
        String line;
        while((line=bufferedReader.readLine())!=null){
            sb.append(line+"\r\n");
        }
        return sb.toString();
        */

        }

        /*获取一个输入流():
         *      1. 可以从文件中读（获取输入流）
         *      2. 可以从网络中读（获取输入流）
         *      3. 可以从内存中读（内存中的一段空间当成输入流）
         *      4. 可以从标准输入读（System.in）
         */
        private static InputStream 获取一个输入流() throws IOException {
        /* 第一种：（从本地文件获取输入流）
        InputStream inputStream;
        inputStream=new FileInputStream("本地文件.txt");
        return inputStream;
        */

        /* 第二种：（从缓冲区获得输入流）
        InputStream inputStream;
        byte[] bytes="我是第一行\r\n我是第二行\r\n".getBytes("UTF-8");
        inputStream=new ByteArrayInputStream(bytes);
        return inputStream;
        */

        /* 第三种：（从键盘获得输入流）
        InputStream inputStream;
        inputStream=System.in;   //从键盘输入数据
        return inputStream;
        */

            Socket cilentSocket=new Socket("www.baidu.com",80);

            OutputStream os=cilentSocket.getOutputStream();
            Writer writer=new OutputStreamWriter(os,"UTF-8");
            PrintWriter out=new PrintWriter(os,false);

            out.println("GET / HTTP/1.0\r\n\r\n");
            out.flush();

            InputStream is=cilentSocket.getInputStream();
            return is;
        }

        private static OutputStream 获取一个输出流() throws IOException{
            OutputStream os=new FileOutputStream("本地输出文件.txt");
            return os;
        }

        private static void 输出一段字符(OutputStream os, String message) throws IOException{
        /* 第一种：
        Writer writer=new OutputStreamWriter(os,"UTF-8");
        PrintWriter out=new PrintWriter(writer,false);
        out.println(message);
        out.flush();
        */

        /* 第二种：
        byte[] bytes=message.getBytes("UTF-8");
        os.write(bytes);
        */

            Writer writer=new OutputStreamWriter(os,"UTF-8");
            writer.append(message);
            writer.flush();
        }
        public static void main(String[] args) throws IOException {
        /*
        InputStream is=获取一个输入流();
        String message=从字节流中获得字符数据(is);
        System.out.println(message);
        */

            OutputStream os=获取一个输出流();
            输出一段字符(os,"我是中国人\r\n最喜欢过年了\r\n");
        }
}
