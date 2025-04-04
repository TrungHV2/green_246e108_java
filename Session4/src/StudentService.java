public class StudentService {
    private Student[] students;
    private int index;

    // Constructor

    /**
     * Thêm một sinh viên vào mảng
     * @param student đối tượng {@link Student} cần thêm
     */
    public void add(Student student) {

    }

    /**
     * Cập nhật thông tin sinh viên đã lưu
     * @param student đối tượng {@link Student} mang thông tin thay đổi
     * @return trả về {@code true} nếu thực hiện thành công ngược lại trả về {@code false}
     */
    public boolean update(Student student) {
        return false;
    }

    /**
     * Xóa sinh viên đã lưu
     * @param id mã sinh viên cần xóa
     * @return trả về {@code true} nếu thực hiện thành công ngược lại trả về {@code false}
     */
    public boolean remove(String id) {
        return false;
    }

    /**
     * Trả về danh sách sinh viên đã lưu
     * @return trả về mảng {@link Student} đã lưu
     */
    public Student[] findAll() {
        return null;
    }

    /**
     * Tìm kếm danh sách sinh viên theo tên
     * @param name tên sinh viên cần tìm
     * @return trả về mảng {@link Student} đã lưu
     */
    public Student[] findByName(String name) {
        return null;
    }

    /**
     * Sắp sếp danh sách sinh viên theo điểm trung bình các môn
     * @return trả về mảng {@link Student} đã được sắp xếp
     */
    public Student[] sortByAvgScoreDesc() {
        for (int i = 0; i < this.students.length; i++) {
            for (int j = i+1; j < this.students.length - 1; j++) {
                double avgI = students[i].getAvg();
                double avgJ = students[j].getAvg();
                if (avgI < avgJ) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        return null;
    }
}
