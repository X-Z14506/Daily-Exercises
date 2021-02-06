package second.Day01;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-01-04
 * Time:19:38
 */

/*
题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
都按先录入排列在前的规则处理。

示例：
jack      70
peter     96
Tom       70
smith     67

从高到低  成绩
peter     96
jack      70
Tom       70
smith     67

从低到高
smith     67
jack      70
Tom      70
peter     96


输入描述:
输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）
        再分别输入他们的名字和成绩，以一个空格隔开。
输出描述:
按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

解题思路：
    定义类，表示姓名和成绩实现方法中：
    先输入人数，再输入排序策略（0或者1），
    输入多组人名和成绩按照排序策略进行排序输出
 */
//TODO



/*

//方法一：传入一个比较器
public class Main2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //输入人数
            int numPeople = scanner.nextInt();
            //排序策略
            int option = scanner.nextInt();

            //输入人员的姓名和成绩
            List<Student> list = new ArrayList<>();
            for (int i = 0;i < numPeople;i++) {
                list.add(new Student(scanner.next(),scanner.nextInt()));
            }

            //降序
            if (option == 0) {
                list.sort(((o1, o2) -> o2.score - o1.score));
            }else if (option == 1) {//升序
                list.sort(((o1, o2) -> o1.score - o2.score));
            }
            for (Student student : list) {
                System.out.println(student.name+" "+student.score);
            }
        }
    }
}

class Student {
    public String name;
    public int score;

    public Student(String name,int score) {
        this.name = name;
        this.score = score;
    }
}*/





//方法二：冲写Comparable接口的compareTo方法
public class Main2 {
    public static void main(String[] args) {

        //TreeMap<String,Integer> treeMap = new TreeMap<>();
        TreeSet<Student> treeSet = new TreeSet<>();
        Student student = new Student("张",100);
        Student student2 = new Student("李",50);
        Student student3 = new Student("赵",70);
        treeSet.add(student);
        treeSet.add(student2);
        treeSet.add(student3);
       /* List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student2);
        list.add(student3);*/
        for (Student student1 : treeSet) {
            System.out.println(student1);
        }
    }
}

class Student implements Comparable<Student>{
    //输入人数
    int numPeople = 3;
    //排序策略
    int option = 0;
    public int score;
    public String name;

    public Student(){

    }
    public Student(String name,int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Student o) {
        //Student student = o;
        if (option==1) {
            return this.score-o.score;
        }else {
            return o.score-this.score;
        }
    }

    @Override
    public String toString() {
        return this.name+" "+this.score;
    }
}
