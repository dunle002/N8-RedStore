package Nhom8.services;

import Nhom8.models.CustomerInfo;
import Nhom8.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerInfoService {
    CustomerInfo findByUser(User user);

    CustomerInfo findByEmail(String email);

    List<CustomerInfo> findAll();

    CustomerInfo findCustomerInfoByUserID(Integer id);

    void saveInfo(CustomerInfo info);

    void deletInfoById(Integer id);

    Page<CustomerInfo> pagingCustomerInfo(int offset, int pagesize);

    CustomerInfo getByID(Integer id);
}
