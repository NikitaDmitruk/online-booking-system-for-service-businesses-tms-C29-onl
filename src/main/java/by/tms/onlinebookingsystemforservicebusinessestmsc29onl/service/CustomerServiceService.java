package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.CustomerService;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.CustomerServiceNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.CustomerServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceService {

    private final CustomerServiceRepository customerServiceRepository;

    public CustomerService createService(CustomerService customerService) {
        return customerServiceRepository.save(customerService);
    }

    public CustomerService updateService(CustomerService customerService) {
        CustomerService customerServiceToUpdate = customerServiceRepository.findById(customerService.getId())
                .orElseThrow(CustomerServiceNotFoundException::new);
        customerServiceToUpdate.setName(customerService.getName());
        customerServiceToUpdate.setCategory(customerService.getCategory());
        customerServiceToUpdate.setProvider(customerService.getProvider());
        customerServiceToUpdate.setAppointments(customerService.getAppointments());
        return customerServiceRepository.save(customerServiceToUpdate);
    }

    public CustomerService getCustomerServiceById(Long id) {
        return customerServiceRepository.findById(id)
                .orElseThrow(CustomerServiceNotFoundException::new);
    }

    public void deleteCustomerServiceById(Long id) {
        customerServiceRepository.findById(id).orElseThrow(CustomerServiceNotFoundException::new);
        customerServiceRepository.deleteById(id);
    }

    public void deleteCustomerService(CustomerService customerService) {
        customerServiceRepository.findById(customerService.getId()).orElseThrow(CustomerServiceNotFoundException::new);
        customerServiceRepository.delete(customerService);
    }

    public List<CustomerService> getAllCustomerServices() {
        return customerServiceRepository.findAll();
    }
}
