package repository;
import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "A", 11, "aa", "AAA"));
        productMap.put(2, new Product(2, "B", 22, "bb", "BBB"));
        productMap.put(3, new Product(3, "C", 33, "cc", "CCC"));
        productMap.put(4, new Product(4, "D", 44, "dd", "BBB"));
        productMap.put(5, new Product(5, "E", 55, "ee", "CCC"));
        productMap.put(6, new Product(6, "F", 66, "ff", "AAA"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
