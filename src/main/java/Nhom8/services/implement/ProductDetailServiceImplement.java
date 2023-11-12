package Nhom8.services.implement;

import Nhom8.models.Product;
import Nhom8.models.ProductDetail;
import Nhom8.repositories.ProductDetailRepository;
import Nhom8.services.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ProductDetailServiceImplement implements ProductDetailService {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetail findByProduct(Product product) {
        return productDetailRepository.findByProduct(product);
    }

    @Override
    public List<ProductDetail> findAll() {
        return productDetailRepository.findAll();
    }

    @Override
    public Page<ProductDetail> PagingAllProductDetail(int offset, int pageSize) {
        return productDetailRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by("id").descending()));
    }

    @Override
    public void save(ProductDetail productDetail) {
        productDetailRepository.save(productDetail);
    }

    @Override
    public ProductDetail getProductDetailById(Integer id) {
        return productDetailRepository.getById(id);
    }

    @Override
    public void deleteProductDetail(int id) {
        productDetailRepository.deleteProductDetailById(id);
    }
}
