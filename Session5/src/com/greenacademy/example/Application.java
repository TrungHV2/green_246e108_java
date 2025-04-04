package com.greenacademy.example;

import com.greenacademy.example.model.Category;
import com.greenacademy.example.service.CategoryService;
import com.greenacademy.example.service.impl.CategoryServiceImpl;

import java.util.Scanner;

public class Application {
    static CategoryService categoryService;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        categoryService = new CategoryServiceImpl();
        while (true) {
            System.out.println("______SHOP______");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    categoryManager(sc);
                    break;
                case 2:
                    productManager(sc);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bạn chọn sai chức năng. Vui lòng thử lại!");
                    break;
            }
        }
    }
    public static void  categoryManager(Scanner sc) {
        int id;
        while (true) {
            System.out.println("______QUẢN LÝ DANH MỤC______");
            System.out.println("1. Thêm danh mục");
            System.out.println("2. Hiển thị danh mục");
            System.out.println("3. Xóa danh mục");
            System.out.println("4. Sửa danh mục");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Category category = new Category();
                    category.input(sc);
                    categoryService.add(category);
                    break;
                case 2:
                    for (Category item : categoryService.findAll()) {
                        item.output();
                    }
                    break;
                case 3:
                    System.out.print("Nhập id danh mục: ");
                    id = Integer.parseInt(sc.nextLine());
                    categoryService.delete(id);
                    break;
                case 4:
                    System.out.print("Nhập id danh mục: ");
                    id = Integer.parseInt(sc.nextLine());
                    Category catUpdate = categoryService.findById(id);
                    System.out.print("Nhập tên danh mục ("+catUpdate.getName()+"): ");
                    catUpdate.setName(sc.nextLine());
                    categoryService.update(catUpdate);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Bạn chọn sai chức năng. Vui lòng thử lại!");
                    break;
            }
        }
    }

    /**
     * BTVN: Tạo thêm interface ProductService và class thực thi ProductServiceImpl
     * Thực hiện các chức năng thêm, sửa, xóa, tìm kiếm, hiển thị sản phẩm.
     * Sau đó sử dụng ProductService giải quyết các yêu cầu chức năng trong menu QLSP
     * @param sc
     */
    public static void  productManager(Scanner sc) {
        while (true) {
            System.out.println("______QUẢN LÝ SẢN PHẨM______");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    // Tìm kiếm sản phẩm có tên sp hoặc tên danh mục chứa từ khóa tìm kiếm
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Bạn chọn sai chức năng. Vui lòng thử lại!");
                    break;
            }
        }
    }
}
