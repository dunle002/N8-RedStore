package Nhom8.services.implement;

import Nhom8.models.Category;
import Nhom8.services.CategoryService;
import Nhom8.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CategoryServiceImplement implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Page<Category> PagingAllCategory(int offset, int pageSize) {
        return categoryRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by("id")));
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteCategoryById(id);
    }
}
