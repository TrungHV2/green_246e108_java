import java.util.Scanner;

public class MyInfo {
    public static void main(String[] args) {
        // Khai báo đối tượng nhập
        Scanner input = new Scanner(System.in);
        // Viết chương trình nhập và hiển thị thông tin cá nhân (Tên,tuổi, SĐT, email)
        // In thông báo
        System.out.print("Nhập tên: ");
        // Khai báo biến và nhập liệu từ bàn phím
        String name = input.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(input.nextLine());
        System.out.print("Nhập SĐT: ");
        String phone = input.nextLine();
        System.out.print("Nhập email: ");
        String email = input.nextLine();

        // Hiển thị dữ liệu vừa nhập
        System.out.println("Họ tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("SĐT: " + phone);
        System.out.println("Email: " + email);
    }
}
