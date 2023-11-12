package Nhom8.repositories;
import Nhom8.models.Bill;
import Nhom8.models.BillDetail;
import Nhom8.models.Product;
import Nhom8.models.keys.BillDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillDetailsRepository extends JpaRepository<BillDetail, BillDetailKey> {
    Optional<BillDetail> findBillDetailsByProductIdAndBillId(Product productId, Bill billId);

    List<BillDetail> findAllByBillId(Bill billId);

    List<BillDetail> findAll();

    void deleteBillDetailByBillIdAndProductId(Bill bill, Product product);
}