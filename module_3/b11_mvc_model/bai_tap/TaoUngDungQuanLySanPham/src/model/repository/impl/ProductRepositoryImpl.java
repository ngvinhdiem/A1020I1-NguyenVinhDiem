package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap =new TreeMap<>();

    static {
        productMap.put(10,new Product(10,"ao",
                50000,"ao tay dai","lv"));
        productMap.put(20,new Product(20,"quan",
                100000,"quan dui","hoa tho"));
        productMap.put(30,new Product(30,"tat",
                30000,"tat co cao","gucci"));
        productMap.put(40,new Product(40,"ca vat",
                60000,"ca vat caro","dolce"));
    }

    @Override
    public List<Product> showAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public boolean addNewProduct(Product product){
        productMap.put(product.getId(),product);
        return true;
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }
}
