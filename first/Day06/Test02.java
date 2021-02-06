package first.Day06;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-11-28
 * Time:10:08
 */

//在Java中，如果参数是简单类型，那么传递的就是值，比如int、char等等；如果参数是对象类型（引用类型），那么传递的就是地址（引用）。
public class Test02 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a,b);
        System.out.println(a+","+b);//AB,B
    }

    private static void operate(StringBuffer a, StringBuffer b) {
        a.append(b);
        b = a;
        System.out.println(a+","+b);//AB,AB
    }
}
/*由于这里函数的参数是2个StringBuffer对象，是对象类型，因此应该传递的是地址(引用)。但是应该注意x指向a所指向的内存(可以理解为都指向A)，
y指向b所指向的内存(可以理解为都指向B),x.append(y);把 y 指向的值追加给x指向的值，这个时候x和a所指向内存的内容都是AB，y指向的内存仍然是B。
y=x;把 x 的值赋值给y，赋的是地址，从而导致y、x和a所指向内存的内容都是AB(y原来指向的，也就是b指向内存中的内容并没有发生变化)。因此,a、y、x同时指向AB，而b仍然指向B。
System.out.println(x+","+y);这里所以打印AB，AB，打印的实际上都是a指向内存的内容。
System.out.println(a+","+b);这里所以打印AB，B，由于是引用传递，所以a指向内存的内容在函数中被修改，而b指向内存中的内容没有发生变化。
引用传递是把原来的地址(实参)传递给新的变量(形参)，原来引用的仍然在那里。
*/

/*
String和StringBuffer的区别。
String和StringBuffer都可以存储和操作字符串，即包含多个字符的字符串数据。String类是不可变类，其对象是不可更改的常量。而StringBuffer是可变类，它的对象是可以扩充和修改的。具体区别如下：
String是对象不是原始类型。为不可变对象,一旦被创建,就不能修改它的值。对于已经存在的String对象的修改都是重新创建一个新的对象,然后把新对象的地址赋给原引用。比如String str="1";str="2";
，在这个过程中，jvm新建了一个对象存储"2"，然后将其地址赋给了str，原来的"1"对象等着jvm作为垃圾回收。此外，String 是final类,即不能被继承。
StringBuffer是一个可变对象，当对他进行修改的时候不会像String那样重新建立对象。它只能通过构造函数来建立，如StringBuffer sb = new StringBuffer();
(不能通过付值符号对他进行付值，sb = "welcome to here!";//error)。对象被建立以后,在内存中就会分配内存空间,
并初始保存一个null.向StringBuffer中赋值的时候可以通过它的append方法(sb.append("hello");)。
字符串连接操作中StringBuffer的效率要比String高。String str=new String("welcome to ");str += "here";的处理步骤实际上是通过建立一个StringBuffer,
让侯调用append(),最后再调用StringBuffer的toSting()并将结果赋值给str。这样，String的连接操作就比StringBuffer多一些附加操作，效率上要打折扣。
而且由于String 对象是不可变对象,每次操作Sting 都会重新建立新的对象来保存新的值，原来的对象就等着被jvm垃圾回收，这也是要影响性能的。
 */