package Nhom8.services;

import Nhom8.models.Address;
import Nhom8.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AddressService {

    List<Address> findAllByUser(User user);

    List<Address> findAll();

    Address getById(Integer id);

    void deleteAddressById(Integer id);

    void saveAddress(Address address);

    Page<Address> pagingAddress(int offset, int pagesize);
}
