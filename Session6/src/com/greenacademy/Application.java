package com.greenacademy;

import com.greenacademy.model.Booking;
import com.greenacademy.model.Room;
import com.greenacademy.service.BookingService;
import com.greenacademy.service.RoomService;
import com.greenacademy.service.impl.BookingServiceImpl;
import com.greenacademy.service.impl.RoomServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Application {
    static RoomService roomService;
    static BookingService bookingService;

    public static void main(String[] args) {
        /**
         * Tạo các class
         * Room (
         *      roomId, mã phòng
         *      roomNumber, số phòng
         *      roomType, loại phòng
         *      price giá phòng
         *  ) Thông tin về phòng
         * Book (
         *      bookId, mã đặt lịch
         *      roomId, mã phòng
         *      phoneNumber, số điện thoại khách đặt
         *      startDate, ngày đến
         *      endDate, ngày đi
         *      price giá tại thời điểm đặt
         * ) Thông tin đặt phòng
         *
         * Viết chương trình đặt phòng khách sạn. Thực hiện các chức năng sau
         * _________QUẢN LÝ KHÁCH SẠN_________
         * 1. Quản lý phòng
         * 2. Đặt phòng
         * 0. Thoát
         *
         * _________QUẢN LÝ PHÒNG_________
         * 1. Thêm phòng
         * 2. Danh sách phòng
         * 3. Cập nhật thông tin phòng
         * 0. Quay lại
         *
         * _________ĐẶT PHÒNG_________
         * 1.Tìm kiếm phòng theo khoảng giá
         * 2. Đặt phòng
         * 3. Hiển thị danh sách các lịch đã đặt (Mã đặt phòng, Số phòng, SĐT, Ngày đến, Ngày đi, Giá phòng)
         * 4. Xóa lịch
         * 0. Quay lại
         *
         *
         * BTVN: Yêu cầu bổ sung thêm các logic validate dữ liệu
         * - Khi thêm phòng, roomNumber không được trùng nhau
         * - Khi đặt phòng,
         *      + mã đặt phòng không được trùng nhau
         *      + một phòng không được đặt bởi 2 KH tại cùng một thời điểm
         *      + ngày đến, ngày đi không được nhập ngày trong quá khứ
         * - Quản lý phòng thêm chức năng cập nhật lịch đặt phòng (chỉ sửa ngày đến - ngày đi)
         */
        Scanner sc = new Scanner(System.in);
        roomService = RoomServiceImpl.getInstance();
        bookingService = BookingServiceImpl.getInstance();

        while (true) {
            System.out.println("_____GREEN HOTEL_____");
            System.out.println("1. Quản lý phòng");
            System.out.println("2. Đặt phòng");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    roomManagement(sc);
                    break;
                case 2:
                    bookingManagement(sc);
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

    public static void roomManagement(Scanner sc) {
        while (true) {
            System.out.println("_____ROOM_____");
            System.out.println("1. Thêm phòng");
            System.out.println("2. Danh sách phòng");
            System.out.println("3. Cập nhật thông tin phòng");
            System.out.println("0. Quay lại");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Room room = new Room();
                    System.out.print("Mã phòng: ");
                    room.setRoomId(Integer.parseInt(sc.nextLine()));
                    while (true) {
                        System.out.print("Số phòng: ");
                        room.setRoomNumber(sc.nextLine());
                        if (roomService.roomNumberExists(room.getRoomNumber())) {
                            System.out.println("Số phòng đã tồn tại!");
                        } else {
                            break;
                        }
                    }
                    System.out.print("Loại phòng: ");
                    room.setRoomType(sc.nextLine());
                    System.out.print("Giá phòng: ");
                    room.setPrice(Double.parseDouble(sc.nextLine()));
                    roomService.save(room);
                    break;
                case 2:
                    System.out.println("=== Danh sách phòng ===");
                    for (Room r : roomService.findAll())
                        System.out.println(r);
                    break;
                case 3:
                    System.out.print("Nhập mã phòng: ");
                    int roomId = Integer.parseInt(sc.nextLine());
                    Room roomUpdate = roomService.findById(roomId);
                    if (roomUpdate != null) {
                        System.out.print("Số phòng("+roomUpdate.getRoomNumber()+"): ");
                        roomUpdate.setRoomNumber(sc.nextLine());
                        System.out.print("Loại phòng("+roomUpdate.getRoomType()+"): ");
                        roomUpdate.setRoomType(sc.nextLine());
                        System.out.print("Giá phòng("+roomUpdate.getPrice()+"): ");
                        roomUpdate.setPrice(Double.parseDouble(sc.nextLine()));
                        roomService.edit(roomUpdate);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Bạn chọn sai chức năng!");
                    break;
            }
        }
    }

    public static void bookingManagement(Scanner sc) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            System.out.println("_____BOOKING_____");
            System.out.println("1. Tìm kiếm phòng theo khoảng giá");
            System.out.println("2. Đặt phòng");
            System.out.println("3. Danh sách đặt phòng");
            System.out.println("4. Xóa lịch đặt phòng");
            System.out.println("0. Quay lại");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Tìm kiếm phòng theo khoảng giá");
                    System.out.print("Từ: ");
                    double price1 = Double.parseDouble(sc.nextLine());
                    System.out.print("Đến: ");
                    double price2 = Double.parseDouble(sc.nextLine());
                    for (Room item : roomService.findByPrice(price1, price2))
                        System.out.println(item);
                    break;
                case 2:
                    System.out.println("Đặt phòng");
                    Booking booking = new Booking();
                    Room room = null;
                    while (true) {
                        System.out.print("Mã phòng: ");
                        int roomId = Integer.parseInt(sc.nextLine());
                        room = roomService.findById(roomId);
                        if (room != null) {
                            booking.setRoomId(roomId);
                            booking.setPrice(room.getPrice());
                            break;
                        }
                        System.out.println("Mã phòng không tồn tại!");
                    }
                    System.out.print("Mã đặt phòng: ");
                    booking.setBookId(sc.nextLine());
                    System.out.print("Số điện thoại: ");
                    booking.setPhoneNumber(sc.nextLine());
                    try {
                        while (true) {
                            System.out.print("Ngày đến: ");
                            booking.setStartDate(dateFormat.parse(sc.nextLine()));
                            System.out.print("Ngày đi: ");
                            booking.setEndDate(dateFormat.parse(sc.nextLine()));
                            if (bookingService.validateDate(booking.getRoomId(), booking.getStartDate(), booking.getEndDate())) {
                                System.out.println("Phòng đã được đặt");
                            } else {
                                break;
                            }
                        }
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    bookingService.add(booking);
                    break;
                case 3:
                    System.out.println("=== Danh sách đặt phòng ===");
                    for (Booking item : bookingService.findAll()) {
                        Room _room = roomService.findById(item.getRoomId());
                        System.out.printf("Booking[bookId=%s, roomNumber=%s, phoneNumber=%s, price=%f, startDate=%s, endDate=%s]\n]",
                                item.getBookId(),_room.getRoomNumber(), item.getPhoneNumber(),item.getPrice(),
                                dateFormat.format(item.getStartDate()), dateFormat.format(item.getEndDate()));
                    }
                    break;
                case 4:
                    System.out.print("Mã đặt phòng: ");
                    String bookId = sc.nextLine();
                    bookingService.delete(bookId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Bạn chọn sai chức năng!");
                    break;
            }
        }
    }
}
