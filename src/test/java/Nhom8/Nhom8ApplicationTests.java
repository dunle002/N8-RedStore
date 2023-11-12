package Nhom8;

import Nhom8.repositories.*;
import Nhom8.services.BillDetailService;
import Nhom8.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Nhom8ApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductService productService;

	@Autowired
	public static CategoryRepository categoryRepository;

	@Autowired
	ProductDetailRepository productDetailRepository;

	@Autowired
	BillRepository billRepository;

	@Autowired
	BillDetailService billDetailService;

	@Test
	void contextLoads() {

	}

}
