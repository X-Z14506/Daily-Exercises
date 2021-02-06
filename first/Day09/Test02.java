package first.Day09;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-01
 * Time:20:27
 */
public class Test02 {
    public static void main(String[] args) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}
class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";

    public Employee(String id) {
        //这里要调用super（）方法，不然编译报错
        super(id);
        empID = id;
    }
}
