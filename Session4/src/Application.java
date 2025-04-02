public class Application {
    public static void main(String[] args) {
        int a = 5, b = 8;
        // Truyền tham trị
        swap(a, b);
        System.out.println("Sau khi gọi swap()");
        System.out.println("a = " + a + " | b = " + b);

        SwapRef sr = new SwapRef(5, 8);
        swapRef(sr);
        System.out.println("Sau khi gọi swapRef()");
        System.out.println("a = " + sr.getA() + " | b = " + sr.getB());
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Trong hàm");
        System.out.println("a = " + a + " | b = " + b);
    }

    public static void swapRef(SwapRef swapRef) {
        int temp = swapRef.getA();
        swapRef.setA(swapRef.getB());
        swapRef.setB(temp);
        System.out.println("Trong hàm");
        System.out.println("a = " + swapRef.getA() + " | b = " + swapRef.getB());
    }
}
