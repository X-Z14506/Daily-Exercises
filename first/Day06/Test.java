package first.Day06;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-28
 * Time:9:22
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person("小明");
        System.out.println("小明" + person.age );
        person.setName("张三");
//        System.out.println(person.getName());
        person.eat();

        Student student = new Student("李四");
        student.setName("李四");
//        System.out.println(student.getName());

        student.eat();
        Person person1 = new Student("王五");
        person1.setName("王五");
        person1.eat();
    }
}
class Person{
    public String name;
    public int age;
    public boolean sex;
    public Person(int age) {
        this.age = age;
    }
    public Person(String name){
        this(6);
    }
    public Person() {
        this(5);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void eat() {
        System.out.println(getName()+"在吃早餐！");
    }
}
class Student extends Person {
    public Student() {

    }
    public Student(String name) {

    }
    public void eat() {
        System.out.println(getName() + "在吃学生餐");
    }
//   Student student = new Student("李四");

}
