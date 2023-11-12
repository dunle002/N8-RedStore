package Nhom8.repositories;

import Nhom8.models.CustomerInfo;
import Nhom8.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoRepository extends JpaRepository<CustomerInfo, Integer> {
    CustomerInfo findByUser(User user);

    CustomerInfo findByEmail(String email);

}
