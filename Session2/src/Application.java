import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // MẢNG 1 CHIỀU
        // Khai báo mảng và khởi tạo
        String[] names = new String[5];
        // Duyệt và Gán giá trị
        for (int i = 0; i < names.length; i++) {
            System.out.print("names["+i+"]=");
            names[i] = sc.nextLine();
        }
        // Duyệt mảng, hiển thị giá trị
        System.out.println("Danh sách sinh viên");
        for (String name : names) {
            System.out.println(name);
        }

        // MẢNG ĐA CHIỀU
        int[][] numbers = new int[3][3];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print("numbers["+i+"]["+j+"]=");
                numbers[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println("Mảng đa chiều");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j]+" ");
            }
            System.out.println();
        }
    }
}
