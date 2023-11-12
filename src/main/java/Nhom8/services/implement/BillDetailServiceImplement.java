package Nhom8.services.implement;

import Nhom8.models.Bill;
import Nhom8.models.BillDetail;
import Nhom8.models.Product;
import Nhom8.models.keys.BillDetailKey;
import Nhom8.services.BillDetailService;
import Nhom8.repositories.BillDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BillDetailServiceImplement implements BillDetailService {

    @Autowired
    BillDetailsRepository billDetailsRepository;
    @Override
    public Optional<BillDetail> findBillDetailsByProductIdAndBillId(Product productId, Bill billId) {
        return billDetailsRepository.findBillDetailsByProductIdAndBillId(productId, billId);
    }

    @Override
    public List<BillDetail> findAllByBillId(Bill billId) {
        return billDetailsRepository.findAllByBillId(billId);
    }

    @Override
    public void saveBillDetail(BillDetail billDetail) {
        billDetailsRepository.save(billDetail);
    }

    @Override
    public void removeBillDetail(BillDetailKey billDetailKey) {
        billDetailsRepository.deleteById(billDetailKey);
    }

    @Override
    public List<BillDetail> findAll() {
        return billDetailsRepository.findAll();
    }

    @Override
    public Page<BillDetail> PagingAllBillDetail(int offset, int pageSize) {
        return billDetailsRepository.findAll(PageRequest.of(offset,pageSize, Sort.by("billId").descending()));
    }

    @Override
    public void deleteBillDetail(Bill bill, Product product) {
        billDetailsRepository.deleteBillDetailByBillIdAndProductId(bill, product);
    }
}
