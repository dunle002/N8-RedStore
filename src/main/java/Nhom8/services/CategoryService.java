package Nhom8.services;

import Nhom8.models.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findCategoryById(Integer id);

    Page<Category> PagingAllCategory(int offset, int pageSize);

    void saveCategory(Category category);

    void deleteCategory(int id);
}
