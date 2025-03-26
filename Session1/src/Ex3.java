import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số (0 -> 6): ");
        int a = Integer.parseInt(input.nextLine());
        String thu = null;
        switch (a) {
            case 0:
                thu = "Chủ nhật";
                break;
            case 1:
                thu = "Thứ 2";
                break;
            case 2:
                thu = "Thứ 3";
                break;
            case 3:
                thu = "Thứ 4";
                break;
            case 4:
                thu = "Thứ 5";
                break;
            case 5:
                thu = "Thứ 6";
                break;
            case 6:
                thu = "Thứ 7";
                break;
            default:
                System.out.println("Bạn phải nhập các giá trị từ 0 -> 6!");
        }

        System.out.println("Hôm nay là " + thu);
    }
}
