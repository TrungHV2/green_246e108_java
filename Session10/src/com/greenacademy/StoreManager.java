package com.greenacademy;

import com.greenacademy.model.Product;
import com.greenacademy.model.Provider;
import com.greenacademy.service.GenericService;
import com.greenacademy.service.impl.ProductServiceImpl;
import com.greenacademy.service.impl.ProviderServiceImpl;

import java.util.Scanner;

public class StoreManager {
    private static GenericService<Provider> providerService;
    private static GenericService<Product> productService;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        providerService = new ProviderServiceImpl();
        productService = new ProductServiceImpl();
        while (true) {
            System.out.println("1. Quản lý nhà cung cấp");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Nhập kho");
            System.out.println("4. Xuất kho");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    providerManager(sc);
                    break;
                case 2:
                    productManager(sc);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chọn sai chức năng");
                    break;
            }
        }
    }

    public static void providerManager(Scanner sc) {
        while (true) {
            System.out.println("1. Thêm nhà cung cấp");
            System.out.println("2. Danh sách nhà cung cấp");
            System.out.println("3. Sửa nhà cung cấp");
            System.out.println("4. Xóa nhà cung cấp");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Provider provider = new Provider();
                    while (true) {
                        System.out.print("Mã NCC: ");
                        provider.setProviderId(sc.nextLine());
                        if (providerService.findId(provider.getProviderId()) == null) {
                            break;
                        }
                        System.out.println("Mã NCC \""+provider.getProviderId()+"\" đã tồn tại!");
                    }
                    System.out.print("Tên NCC: ");
                    provider.setProviderName(sc.nextLine());
                    System.out.print("Địa chỉ: ");
                    provider.setAddress(sc.nextLine());
                    System.out.print("SĐT: ");
                    provider.setPhone(sc.nextLine());
                    providerService.save(provider);
                    break;
                case 2:
                    for (Provider p : providerService.findAll()) {
                        System.out.println("Mã NCC: " + p.getProviderId());
                        System.out.println("Tên NCC: " + p.getProviderName());
                        System.out.println("Địa chỉ: " + p.getAddress());
                        System.out.println("SĐT: " + p.getPhone());
                        System.out.println("_____");
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã ncc: ");
                    String editId = sc.nextLine();
                    Provider initUpdate = providerService.findId(editId);
                    if (initUpdate != null) {
                        System.out.print("Tên NCC("+initUpdate.getProviderName()+"): ");
                        initUpdate.setProviderName(sc.nextLine());
                        System.out.print("Địa chỉ("+initUpdate.getAddress()+"): ");
                        initUpdate.setAddress(sc.nextLine());
                        System.out.print("SĐT("+initUpdate.getPhone()+"): ");
                        initUpdate.setPhone(sc.nextLine());
                        providerService.edit(initUpdate);
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã ncc: ");
                    String deleteId = sc.nextLine();
                    Provider initDelete = providerService.findId(deleteId);
                    if (initDelete != null) {
                        providerService.delete(initDelete);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chọn sai chức năng");
                    break;
            }
        }
    }

    public static void productManager(Scanner sc) {
        while (true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Danh sách sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chọn sai chức năng");
                    break;
            }
        }
    }
}
