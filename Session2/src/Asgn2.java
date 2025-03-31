import java.sql.SQLOutput;

public class Asgn2 {
    public static void main(String[] args) {
        /**
         * Khởi tạo mảng số nguyên 2 chiều nxm phần tử (n, m nhập từ bàn phím). Thực hiện
         * các chức năng theo menu sau
         *       ***************************MENU*****************************
         * 1. Nhập giá trị các phần tử mảng
         * 2. Hiển thị mảng vừa nhập theo ma trận
         * 3. In giá trị các phần từ nằm trên đường biên
         * 4. In giá trị và tổng các phần tử nằm trên đường chéo chính và đường chéo phụ
         * 5. Sắp xếp các cột trong mảng tăng dần
         * 6. Thoát
         */
        int[][] nums = new int[3][];
        nums[0] = new int[] { 7, 8, 9 };
        nums[1] = new int[] { 4, 5, 6 };
        nums[2] = new int[] { 1, 2, 3 };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //nums[j][i]
                for (int k = j+1; k < 3; k++) {
                    if (nums[j][i] > nums[k][i]) {
                        int tmp = nums[j][i];
                        nums[j][i] = nums[k][i];
                        nums[k][i] = tmp;
                    }
                }
            }
        }
        System.out.println("Mảng tăng dần");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
