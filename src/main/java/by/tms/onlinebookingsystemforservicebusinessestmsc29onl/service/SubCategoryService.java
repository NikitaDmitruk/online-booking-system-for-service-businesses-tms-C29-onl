package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.SubCategory;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.SubCategoryNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public List<SubCategory> getAllSubCategory() {
        return subCategoryRepository.findAll();
    }

    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id).orElseThrow(SubCategoryNotFoundException::new);
    }

    public SubCategory createSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public SubCategory updateSubCategory(SubCategory subCategory) {
        SubCategory updatedSubCategory = subCategoryRepository.findById(subCategory.getId()).orElseThrow(SubCategoryNotFoundException::new);
        updatedSubCategory.setName(subCategory.getName());
        updatedSubCategory.setCategory(subCategory.getCategory());
        updatedSubCategory.setProjectList(subCategory.getProjectList());
        return subCategoryRepository.save(updatedSubCategory);
    }

    public void deleteSubCategoryById(Long id) {
        subCategoryRepository.findById(id).orElseThrow(SubCategoryNotFoundException::new);
        subCategoryRepository.deleteById(id);
    }
}
