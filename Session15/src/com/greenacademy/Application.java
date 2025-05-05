package com.greenacademy;

import com.greenacademy.entity.CategoryEntity;
import com.greenacademy.repository.Repository;
import com.greenacademy.repository.impl.CategoryRepository;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Repository<CategoryEntity, Integer> categoryRepository = new CategoryRepository();

        while (true) {
            System.out.println("1. Danh sách danh mục");
            System.out.print("Chọn chức năng: ");
            int chose = Integer.parseInt(sc.nextLine());
            switch (chose) {
                case 1:
                    int page = 1;
                    do {
                        List<CategoryEntity> data = categoryRepository.pagination(page, 3);
                        for (CategoryEntity category : data) {
                            System.out.println(category.getCategoryId() + ". " +category.getCategoryName());
                        }
                        System.out.print("Nhập trang: ");
                        page = Integer.parseInt(sc.nextLine());
                    } while (page > 0);
                    break;
                default:
                    System.out.println("Sai chức năng!");
                    break;
            }
        }
    }
}
