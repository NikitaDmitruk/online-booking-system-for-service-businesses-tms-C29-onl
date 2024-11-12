package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.ServiceCategory;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.ServiceCategoryNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.ServiceCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategoryService {

    private final ServiceCategoryRepository serviceCategoryRepository;

    public ServiceCategoryService(ServiceCategoryRepository serviceCategoryRepository) {
        this.serviceCategoryRepository = serviceCategoryRepository;
    }

    public ServiceCategory createServiceCategory(ServiceCategory serviceCategory) {
        return serviceCategoryRepository.save(serviceCategory);
    }

    public ServiceCategory updateServiceCategory(ServiceCategory serviceCategory) throws ServiceCategoryNotFoundException {
        ServiceCategory serviceCategoryToUpdate = serviceCategoryRepository.findById(serviceCategory.getId()).
                orElseThrow(() -> new ServiceCategoryNotFoundException("Service Category Not Found!"));
        serviceCategoryToUpdate.setName(serviceCategory.getName());
        return serviceCategoryRepository.save(serviceCategoryToUpdate);
    }

    public ServiceCategory getServiceCategoryById(Long id) throws ServiceCategoryNotFoundException {
        return serviceCategoryRepository.findById(id).
                orElseThrow(() -> new ServiceCategoryNotFoundException("Service Category Not Found!"));
    }

    public void deleteServiceCategoryById(Long id) {
        serviceCategoryRepository.deleteById(id);
    }

    public void deleteServiceCategory(ServiceCategory serviceCategory) {
        serviceCategoryRepository.delete(serviceCategory);
    }

    public List<ServiceCategory> getAllServiceCategory() {
        return serviceCategoryRepository.findAll();
    }

}
