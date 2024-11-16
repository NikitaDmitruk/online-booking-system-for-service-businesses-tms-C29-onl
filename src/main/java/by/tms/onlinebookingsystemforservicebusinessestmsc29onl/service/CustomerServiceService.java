package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.CustomerService;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.CustomerServiceNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.CustomerServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceService {

    private final CustomerServiceRepository customerServiceRepository;

    public CustomerServiceService(CustomerServiceRepository customerServiceRepository) {
        this.customerServiceRepository = customerServiceRepository;
    }

    public CustomerService createService(CustomerService customerService) {
        return customerServiceRepository.save(customerService);
    }

    public CustomerService updateService(CustomerService customerService) {
        CustomerService customerServiceToUpdate = customerServiceRepository.findById(customerService.getId())
                .orElseThrow(() -> new CustomerServiceNotFoundException("Сервис для клиента не найден."));
        customerServiceToUpdate.setName(customerService.getName());
        customerServiceToUpdate.setCategory(customerService.getCategory());
        customerServiceToUpdate.setProvider(customerService.getProvider());
        customerServiceToUpdate.setAppointments(customerService.getAppointments());
        return customerServiceRepository.save(customerServiceToUpdate);
    }

    public CustomerService getCustomerServiceById(Long id) {
        return customerServiceRepository.findById(id)
                .orElseThrow(() -> new CustomerServiceNotFoundException("Сервис для клиента не найден."));
    }

    public void deleteCustomerServiceById(Long id) {
        customerServiceRepository.deleteById(id);
    }

    public void deleteCustomerService(CustomerService customerService) {
        customerServiceRepository.delete(customerService);
    }

    public List<CustomerService> getAllCustomerServices() {
        return customerServiceRepository.findAll();
    }
}
