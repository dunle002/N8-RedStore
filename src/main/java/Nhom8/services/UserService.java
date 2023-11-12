package Nhom8.services;

import Nhom8.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User getUserByUserNameAndPassWord(String username, String password);

    User getUserByUserName(String username);

    void saveUser(User user);
    User getUserByUserNameAndPassWordAndRole(String username,String password, int role);

    User getUserById(Integer id);

    boolean checkEdiUsername(String username, int id);

    List<User> findAll();

    void deleteUserById(Integer id);

    Page<User> pagingUser(int offset, int pagesize);

    List<User> findAllByRoleAndStatus(int role, int status);

    List<User> findUserByRole(int id);

}
