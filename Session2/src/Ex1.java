import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        /**
         * Viết chương trình Java khởi tạo mảng một chiều số nguyên n phần tử (n
         * nhập từ bàn phím). Thực hiện các yêu cầu sau:
         *
         * 1. Nhập giá trị các phần tử của mảng
         * 2. In ra các phần tử của mảng
         * 3. Tính tổng các phần tử của mảng
         * 4. In giá trị các phần tử là chẵn
         * 5. Sắp xếp mảng tăng dần
         * 6. Thoát
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("numbers["+i+"]=");
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Các phần tử của mảng");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i]+" ");
        }

        // Tính tổng
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += numbers[i];
        }
        System.out.println("Tổng giá trị các phần tử của maảng là: " + total);

        //In các ptu chẵn
        System.out.println("Các phần tử chẵn");
        for (int i = 0; i < n; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.print(numbers[i]+" ");
            }
        }

        // Sắp xếp
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i]+" ");
        }
    }
}
