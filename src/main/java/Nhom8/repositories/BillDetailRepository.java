package Nhom8.repositories;

import Nhom8.models.BillDetail;
import Nhom8.models.keys.BillDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDetailRepository extends JpaRepository<BillDetail, BillDetailKey> {
}
