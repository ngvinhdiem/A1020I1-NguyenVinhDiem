package b12_java_collection_framework.baitap;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class Product {
    private int id;
    private String name;
    private int price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                '}';
    }
}

class ProductManager {
    void add(int id, String name, int price) {
        Product product = new Product(id, name, price);
        for (Product subProduct : productLists) {
            if (id == subProduct.getId()) {
                System.out.println("Duplicate ID!!!");
                return;
            }
        }
        productLists.add(product);
    }

    void edit(int id, String name, int price) {
        for (Product product : productLists) {
            if (id == product.getId()) {
                product.setName(name);
                product.setPrice(price);
            }
        }
    }

    void delete(int id) {
        productLists.removeIf(product -> id == product.getId());
    }

    void display() {
        for (Product product : productLists) {
            System.out.println(product.toString());
        }
    }

    void search(String name) {
        for (Product product : productLists) {
            if (name.equals(product.getName())) {
                System.out.println(product.toString());
            }
        }
    }

    void sortLowToHigh() {
        PriceComparatorLowToHigh priceComparatorLowToHigh = new PriceComparatorLowToHigh();
        Collections.sort(productLists, priceComparatorLowToHigh);
    }

    void sortHighToLow() {
        PriceComparatorHighToLow priceComparatorHighToLow = new PriceComparatorHighToLow();
        Collections.sort(productLists, priceComparatorHighToLow);
    }

    ArrayList<Product> productLists = new ArrayList<>();

}

class PriceComparatorLowToHigh implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() == o2.getPrice()) {
            return 0;
        } else {
            return -1;
        }
    }
}

class PriceComparatorHighToLow implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() == o2.getPrice()) {
            return 0;
        } else {
            return 1;
        }
    }
}


public class LuyenTapSuDungCollectionFramework {
    public static void main(String[] args) {
        LuyenTapSuDungCollectionFramework luyenTapSuDungCollectionFramework = new LuyenTapSuDungCollectionFramework();
        luyenTapSuDungCollectionFramework.displayMainMenu();
    }
    public static ProductManager productManager = new ProductManager();
    public static void displayMainMenu() {
        System.out.println("Menu \n1. Thêm sản phẩm\n" +
                "2. Sửa thông tin sản phẩm theo id\n" +
                "3. Xoá sản phẩm theo id\n" +
                "4. Hiển thị danh sách sản phẩm\n" +
                "5. Tìm kiếm sản phẩm theo tên\n" +
                "6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá \n" +
                "Lựa chọn của bạn là: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                System.out.println("Nhap ID:");
                int id = scanner.nextInt();
                System.out.println("Nhap ten san pham:");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Nhap gia san pham:");
                int price = scanner.nextInt();
                productManager.add(id, name, price);
                scanner.nextLine();
                displayMainMenu();
                break;
            case 2:
                System.out.println("Nhap ID san pham can sua:");
                id = scanner.nextInt();
                for (Product product : productManager.productLists) {
                    if (id == product.getId()) System.out.println(product.toString());
                }
                System.out.println("Sua ten san pham: ");
                scanner.nextLine();
                name = scanner.nextLine();

                System.out.println("Sua gia san pham: ");
                price = scanner.nextInt();
                scanner.nextLine();
                productManager.edit(id, name, price);
                displayMainMenu();
                break;
            case 3:
                System.out.println("Nhap ID san pham can xoa: ");
                id = scanner.nextInt();
                productManager.delete(id);
                displayMainMenu();
                break;
            case 4:
                productManager.display();
                scanner.nextLine();
                scanner.nextLine();
                displayMainMenu();
                break;
            case 5:
                System.out.println("Nhap ten san pham can tim kiem: ");
                scanner.nextLine();
                name = scanner.nextLine();
                productManager.search(name);
                scanner.nextLine();
                displayMainMenu();
                break;
            case 6:
                System.out.println("Ban muon sap xep san pham theo gia: \n 1. Tang dan \n 2. Giam dan");
                input = scanner.nextInt();
                switch (input) {
                    case 1:
                        productManager.sortLowToHigh();
                        break;
                    case 2:
                        productManager.sortHighToLow();
                        break;
                }
                scanner.nextLine();
                displayMainMenu();
                break;
        }

    }
}