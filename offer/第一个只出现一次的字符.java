/*
题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）

输入："google"
输出：4
 */
public class Main09 {

    public static void main(String[] args) {
        String s = "google";
        System.out.println(FirstNotRepeatingChar(s));
        System.out.println(solution(s));
        System.out.println(FirstNotRepeatingChar3(s));
    }
    public static int FirstNotRepeatingChar(String str) {

        for (int i = 0;i < str.length();i++) {
           char temp = str.charAt(i);
            int count = 0;
           for (int j = 0;j <str.length();j++) {
               if (str.charAt(j) == temp) {
                   count++;
               }
           }
           if (count == 1) {
               return i;
           }
        }
        return -1;
    }

    //方法二：其实主要还是hash，利用每个字母的ASCII码作hash来作为数组的index。
    // 首先用一个58长度的数组来存储每个字母出现的次数，
    // 为什么是58呢，主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，
    // 而每个字母的index=int(word)-65，比如g=103-65=38，
    // 而数组中具体记录的内容是该字母出现的次数，最终遍历一遍字符串，
    // 找出第一个数组内容为1的字母就可以了，时间复杂度为O(n)
    public static int solution(String str){
        int[] words = new int[58];
        for(int i = 0;i<str.length();i++){
            //此处可以不用加强转，因为英文字符可以自动转换为int
            words[(str.charAt(i))-65] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }

    //方法三：
    public static int FirstNotRepeatingChar3(String str) {
        if(str==null)return -1;
        if(str.length()==0)return -1;
        char[] ch=str.toCharArray();
        int pos=-1;
        int i=0,j=0;
        for(i=0;i<ch.length;i++){
            for(j=0;j<ch.length;j++){
                if((ch[i]==ch[j])&&(i!=j))break;
            }
            if(j==ch.length){
                pos=i;
                break;
            }
        }
        return pos;
    }
}
