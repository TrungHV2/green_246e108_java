import java.util.Arrays;

public class ComputerService {
    private Computer[] computers;
    private int initSize = 2;
    private int index = 0;

    public ComputerService() {
        computers = new Computer[initSize];
    }
    public ComputerService(Computer[] computers) {
        this.computers = computers;
    }

    public void add(Computer computer) {
        if (index == computers.length) {
            computers = Arrays.copyOf(computers, computers.length + initSize);
        }
        computers[index++] = computer;
    }

    public boolean remove(String model) {
        int delIndex = -1;
        for (int i = 0; i < index; i++) {
            if (computers[i].getModel().equals(model)) {
                delIndex = i;
            }
        }
        if (delIndex != -1) {
            index--;
            //System.arraycopy(computers, delIndex + 1, computers, delIndex, index - delIndex);
            for (int j = delIndex + 1; j <= index; j++) {
                computers[j-1] = computers[j];
            }
            computers[index] = null;
            return true;
        } else {
            return false;
        }
    }
    // Trả về tất cả các computer đã lưu
    public Computer[] findAll() {
        return null;
    }

    public void display() {
        System.out.println("Danh sách máy tính");
        for (int i = 0; i < index; i++) {
            System.out.println("Model: " + computers[i].getModel());
            System.out.println("Brand: " + computers[i].getBrand());
            System.out.println("Price: " + computers[i].getPrice());
            System.out.println("__________");
        }
    }
}
