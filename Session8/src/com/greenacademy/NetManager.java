package com.greenacademy;

import com.greenacademy.model.Computer;
import com.greenacademy.model.Service;
import com.greenacademy.service.NetGenericService;
import com.greenacademy.service.impl.NetGenericServiceImpl;

import java.util.Scanner;

public class NetManager {
    public static void main(String[] args) {
        /**
         * Cho model class sau
         * Computer
         *      String computerId; // Tên máy (vd: PC1)
         *      double price; // Đơn giá chơi theo giờ
         *      Date start; // Thời gian bắt đầu chơi
         *      boolean status; // Trạng thái của máy (true: ON | false: OFF)
         * Service
         *      int serviceId; // mã dịch vụ
         *      String serviceName; // Tên dịch vụ
         *      double price; // Đơn giá
         * Viết chương trình Java quản lý phòng Net. Gồm các chức năng sau
         * 1. Quản lý dịch vụ
         * 2. Quản lý máy
         * 0. Thoát
         *
         * ________QUẢN LÝ DỊCH VỤ________
         * 1. Thêm dịch vụ
         * 2. Hiển thị dịch vụ
         * 0. Quay lại
         *
         * ________QUẢN LÝ MÁY________
         * 1. Thêm máy tính
         * 2. Hiển thị danh sách các máy đang có (Hiển thị tên máy, trạng thái ON/OFF)
         * 3. Bật máy (Không bật các máy đang ON)
         * 5. Gọi dịch vụ (mỳ, nước, thuốc, ...)
         * 4. Tính tiền (Không tính tiền các máy đang OFF)
         * 0. Quay lại
         */

        Scanner sc = new Scanner(System.in);
        NetGenericService<Computer> computerService = new NetGenericServiceImpl<>();
        NetGenericService<Service> serviceService = new NetGenericServiceImpl<>();

        while (true) {
            System.out.println("1. Thêm máy tính");
            System.out.println("2. Hển thị");
            System.out.println("3. Sửa");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Computer computer = new Computer();
                    System.out.print("Tên máy: ");
                    computer.setId(sc.nextLine());
                    System.out.print("Đơn giá: ");
                    computer.setPrice(Double.parseDouble(sc.nextLine()));
                    computerService.add(computer);
                    break;
                case 2:
                    for (Computer com : computerService.findAll()) {
                        System.out.println(com);
                    }
                    break;
                case 3:
                    System.out.print("Nhập tên máy: ");
                    String updateId = sc.nextLine();
                    Computer updateComputer = computerService.findById(updateId);
                    if (updateComputer != null) {
                        System.out.print("Tên máy: ");
                        updateComputer.setId(sc.nextLine());
                        System.out.print("Đơn giá: ");
                        updateComputer.setPrice(Double.parseDouble(sc.nextLine()));
                        computerService.update(updateComputer);
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên máy: ");
                    String delId = sc.nextLine();
                    Computer delComputer = computerService.findById(delId);
                    if (delComputer != null) {
                        computerService.delete(delId);
                    }
                    break;
                case 5:
                    System.out.print("Tên máy: ");
                    String key = sc.nextLine();
                    for (Computer com : computerService.where(c -> c.getId().contains(key))) {
                        System.out.println(com);
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
