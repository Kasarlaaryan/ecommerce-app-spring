package com.stschool.ecommerce.repository;
import com.stschool.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Optional<Product>findByName(String name);


//    private final List<Product> products;
//
//    public ProductRepository (){
//        this.products = new ArrayList<>();
//    }
//
//    public Product save(Product product) {
//        this.products.add(product);
//        return product;
//    }
//
//    public Optional<Product> findById(int id) {
//        return products.stream()
//                .filter(product -> product.getId() == id)
//                .findFirst();
//    }
//
//    public List<Product> findAll(){
//        return this.products;
//    }
//
//    public Product update(int id, Product product) {
//        products.replaceAll(p -> p.getId() == id ? product : p);
//        return product;
//    }
//
//    public boolean delete(int id) {
//        return products.removeIf(product -> product.getId() == id);
//    }
//
//    public boolean delete(Product product){
//        return products.remove(product);
//    }
}
