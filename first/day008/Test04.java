package first.day008;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2020-12-01
 * Time:10:08
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A(int v) {
            setValue(v);
        }
        private void setValue(int value) {
            this.value = value;
        }
        public int getValue() {
            try {
                value++;
                return value;
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A{
        public B(){
            super(5);
            setValue(getValue()-3);
        }
        public void setValue(int value) {
            super.setValue(2*value);
        }
    }
}
