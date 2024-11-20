package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.ServiceCategory;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service.ServiceCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class ServiceCategoryController {

    private final ServiceCategoryService serviceCategoryService;

    @GetMapping
    public ResponseEntity<List<ServiceCategory>> getAllServiceCategories() {
        List<ServiceCategory> serviceCategories = serviceCategoryService.getAllServiceCategory();
        return ResponseEntity.ok(serviceCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCategory> getServiceCategoryById(@PathVariable Long id) {
        ServiceCategory serviceCategory = serviceCategoryService.getServiceCategoryById(id);
        return ResponseEntity.ok(serviceCategory);
    }

    @PostMapping
    public ResponseEntity<ServiceCategory> createServiceCategory(@RequestBody ServiceCategory serviceCategory) {
        ServiceCategory createdServiceCategory = serviceCategoryService.createServiceCategory(serviceCategory);
        return ResponseEntity.ok(createdServiceCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceCategory> updateServiceCategory(@PathVariable Long id, @RequestBody ServiceCategory serviceCategory) {
        serviceCategory.setId(id);
        ServiceCategory updatedServiceCategory = serviceCategoryService.updateServiceCategory(serviceCategory);
        return ResponseEntity.ok(updatedServiceCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServiceCategory(@PathVariable Long id) {
        serviceCategoryService.deleteServiceCategoryById(id);
        return ResponseEntity.noContent().build();
    }

}
