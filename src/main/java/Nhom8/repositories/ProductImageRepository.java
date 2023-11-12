package Nhom8.repositories;

import Nhom8.models.Product;
import Nhom8.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

    List<ProductImage> findAll();

    List<ProductImage> findAllByProduct(Product product);

    void deleteProductImageById(int id);
}
