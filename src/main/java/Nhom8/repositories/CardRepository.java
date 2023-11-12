package Nhom8.repositories;

import Nhom8.models.Card;
import Nhom8.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {


    List<Card> findAllByUser(User user);
}
