package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Category;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.CategoryNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    public Category updateCategory(Category category) {
        Category updatedCategory = categoryRepository.findById(category.getId()).orElseThrow(CategoryNotFoundException::new);
        updatedCategory.setName(category.getName());
        updatedCategory.setSubCategories(category.getSubCategories());
        return categoryRepository.save(updatedCategory);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        categoryRepository.deleteById(id);
    }
}
