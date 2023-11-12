package Nhom8.repositories;

import Nhom8.models.Product;
import Nhom8.models.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    ProductDetail findByProduct(Product product);

    void deleteProductDetailById(int id);
}
