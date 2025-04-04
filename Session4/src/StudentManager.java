public class StudentManager {
    public static void main(String[] args) {
        /** BTVN
         * Viết chương trình quản lý sinh viên với các chức năng sau
         * 1. Thêm mới sinh viên
         * 2. Hiển thị danh sách sinh viên
         * 3. Hiển thị danh sách sinh viên theo điểm TB giảm dần
         * 4. Tìm kiếm sinh viên theo tên
         * 5. Cập nhật thông tin sinh viên
         * 6. Xóa sinh viên
         * 0. Thoát
         */

        Student[] studentsSorted = new Student[10];
        for (int i = 0; i < studentsSorted.length; i++) {
            System.out.println("Id: " + studentsSorted[i].getId());
            System.out.println("Avg: " + studentsSorted[i].getAvg());
        }
    }
}
