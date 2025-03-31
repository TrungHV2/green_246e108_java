import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Asgn3 {
    public static void main(String[] args) {
        /**
         * Viết chương trình Java nhập vào mảng họ và tên (Họ, tên đệm, tên) của N sinh viên.
         * Xử lý các yêu cầu sau:
         * ***************************MENU*****************************
         * 1. Hiển thị danh sách sinh viên vừa nhập
         * 2. Sắp xếp danh sách sinh viên theo tên A-Z
         * 3. Tìm kiếm sinh viên với từ khóa truyền vào
         * 4. Thoát
         */

        String[] names = new String[] {"Phan Duy Phương", "Nguyễn Quốc Đạt", "Trần Đức Thành", "Nguyễn Minh Tuyên", "Phan Hoàng Sử", "Nguyễn Văn Khánh", "Đàm Nhật Tuấn Anh"};

        for (int i = 0; i < names.length; i++) {
            for (int j = i+1; j < names.length; j++) {
                String[] name_i = names[i].split(" ");
                String[] name_j = names[j].split(" ");
                String str_i = covertToString(name_i[name_i.length-1]).toUpperCase();
                String str_j = covertToString(name_j[name_j.length-1]).toUpperCase();


                if (str_i.compareTo(str_j) > 0) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        System.out.println("Danh sách sinh viên đã sắp xếp A-Z");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i]+ ", ");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nNhập từ khóa tìm kiếm: ");
        String key = scanner.nextLine();
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(key.toLowerCase())) {
                System.out.print(names[i]+ ", ");
            }
        }
    }

    public static String covertToString(String value) {
        try {
            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
