package Nhom8.repositories;

import Nhom8.models.Address;
import Nhom8.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddresRepository extends JpaRepository<Address, Integer> {

    List<Address> findAllByUser(User user);

}
