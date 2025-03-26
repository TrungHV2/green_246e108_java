public class Ex5 {
    // global variable
    static int b = 0;

    public static void main(String[] args) {
        // local variable
        int a = 5;
        b = ++a + 6;
        test();
        System.out.println("a = " + a);
    }

    public static void test() {
        System.out.println("b = " + b);
    }
}
