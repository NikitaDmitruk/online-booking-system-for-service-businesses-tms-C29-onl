package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.ServiceCategory;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.ServiceCategoryNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.ServiceCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCategoryService {

    private final ServiceCategoryRepository serviceCategoryRepository;


    public ServiceCategory createServiceCategory(ServiceCategory serviceCategory) {
        return serviceCategoryRepository.save(serviceCategory);
    }

    public ServiceCategory updateServiceCategory(ServiceCategory serviceCategory) {
        ServiceCategory serviceCategoryToUpdate = serviceCategoryRepository.findById(serviceCategory.getId())
                .orElseThrow(ServiceCategoryNotFoundException::new);
        serviceCategoryToUpdate.setName(serviceCategory.getName());
        return serviceCategoryRepository.save(serviceCategoryToUpdate);
    }

    public ServiceCategory getServiceCategoryById(Long id) {
        return serviceCategoryRepository.findById(id)
                .orElseThrow(ServiceCategoryNotFoundException::new);
    }

    public void deleteServiceCategoryById(Long id) {
        serviceCategoryRepository.findById(id).orElseThrow(ServiceCategoryNotFoundException::new);
        serviceCategoryRepository.deleteById(id);
    }

    public void deleteServiceCategory(ServiceCategory serviceCategory) {
        serviceCategoryRepository.findById(serviceCategory.getId()).orElseThrow(ServiceCategoryNotFoundException::new);
        serviceCategoryRepository.delete(serviceCategory);
    }

    public List<ServiceCategory> getAllServiceCategory() {
        return serviceCategoryRepository.findAll();
    }

}
