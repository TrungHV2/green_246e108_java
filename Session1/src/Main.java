import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Khai báo biến
        // data_type var_name;
        int number;
        // Gán giá trị
        number = 5;
        // Khai báo và gán giá trị
        int num2 = 6, num3 = 7;
        String name = "Hoàng Văn Trung";
        char gender = 'M';
        // Khai báo hằng số
        final float PI = 3.14534634364f;

        // Nhập dữ liệu
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        name = input.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(input.nextLine());
        // Chuyển đổi kiểu dữ liệu string từ input.nextLine() sang các KDL double,float,boolean
//        Double.parseDouble(input.nextLine());
//        Float.parseFloat(input.nextLine());
//        Boolean.parseBoolean(input.nextLine());


        // Nhập/xuất
        // %s: chuỗi
        // %d: số nguyên
        // %f: số thực
        System.out.println(name); // In xong xuống dòng
        System.out.printf("%-20s %s\n", "Họ và tên:", name); // In với định dạng
        System.out.printf("%-20s %d\n", "Tuổi:", age);
        System.out.print(name); // In và không xuống dòng, giá trị in ra tiếp theo sẽ tếp tục trên dòng hiện tại
        System.out.printf("\nPI = %5.2f\n", PI);



    }
}