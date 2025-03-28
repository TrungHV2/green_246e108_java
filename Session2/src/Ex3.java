import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("names[" + i + "] = ");
            names[i] = sc.nextLine();
        }
        // Sắp xếp
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        // Hiển thị kết quả
        for (int i = 0; i < 5; i++) {
            System.out.println(names[i]+ ", ");
        }
        // Tìm hiểu về REGEX: https://viblo.asia/p/hoc-regular-expression-va-cuoc-doi-ban-se-bot-kho-Az45bnoO5xY
        // validate email ^[\w\.\-]+@[a-z]+\.[a-z]{2,5}$
        // Nhập vào một chuỗi bất kỳ từ bàn phím, xử lý IN HOA các chữ cái đầu của các từ trong chuỗi và in ra.
        // VD: Input "hôm nay là thứ sáu" => "Hôm Nay Là Thứ Sáu"

        System.out.print("Nhập chuỗi: ");
        String str = sc.nextLine();

        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String firstChar = strs[i].charAt(0)+"";
            strs[i] = firstChar.toUpperCase() + strs[i].substring(1, strs[i].length());
        }
        for (String item :strs) {
            System.out.print(item + " ");
        }
    }
}
