package Nhom8.services;

import Nhom8.models.Card;
import Nhom8.models.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CardService {
    List<Card> findAllByUser(User user);

    List<Card> findAll();

    Card getById(Integer id);

    void deleteCardById(Integer id);

    void saveCard(Card card);

    Page<Card> pagingCard(int offset, int pagesize);
}
