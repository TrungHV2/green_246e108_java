package com.greenacademy;

public class Application {
    public static void main(String[] args) {
        // Sinh viên 1
        // Khởi tạo đối tượng
        // Constructor ko tham số khởi tạo đối tượng rỗng (chưa có thông tin)
        Student st1 = new Student();
        // Sử dụng hàm setter để gán giá trị cho các fields
        st1.setId("SV01");
        st1.setName("Nguyễn Văn A");
        st1.setAge(25);
        st1.setEmail("anv@gmail.com");
        // Sử dụng getter để đọc thông tin từ fields
        System.out.println("Thông tin sinh viên 1");
        System.out.println("Mã sinh viên: " + st1.getId());
        System.out.println("Tên sinh viên: " + st1.getName());
        st1.hello();

        // Sinh viên 2
        // Constructor có tham số khởi tạo đối tượng với các thông tin có sẵn
        Student st2 = new Student("SV02", "Nguyễn Văn B", 20, "anv@gmail.com", "0987654321", "HN");
        st2.hello();

        // Sinh viên 3
        Student st3 = new Student("SV03", "Nguyễn Văn C");

        System.out.println("Thông tin sinh viên 3");
        System.out.println("Mã sinh viên: " + st3.getId());
        System.out.println("Tên sinh viên: " + st3.getName());
        st3.hello();
    }
}
