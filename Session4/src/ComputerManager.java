import java.util.Scanner;

public class ComputerManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComputerService computerService = new ComputerService();
        while (true) {
            System.out.println("1. Nhập máy tính");
            System.out.println("2. Danh sách máy tính");
            System.out.println("3. Xóa máy tính");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập thông tin máy tính");
                    Computer computer = new Computer();
                    System.out.print("Model: ");
                    computer.setModel(sc.nextLine());
                    System.out.print("Brand: ");
                    computer.setBrand(sc.nextLine());
                    System.out.print("Price: ");
                    computer.setPrice(Double.parseDouble(sc.nextLine()));
                    computerService.add(computer);
                    break;
                case 2:
                    computerService.display();
                    break;
                case 3:
                    // Xóa máy tính đã được thêm trong mảng dựa vào model
                    System.out.print("Nhập vào PC Model: ");
                    String model = sc.nextLine();
                    if (computerService.remove(model)) {
                        System.out.println("Đã xóa model=" + model);
                    } else {
                        System.out.println("Không tìm thấy model=" + model);
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn chọn sai chức năng!");
                    break;
            }
        }
    }
}
