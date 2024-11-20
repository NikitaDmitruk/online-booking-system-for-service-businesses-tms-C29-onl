package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.CustomerService;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service.CustomerServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/services")
public class CustomerServiceController {

    private final CustomerServiceService customerServiceService;

    @GetMapping
    public ResponseEntity<List<CustomerService>> getAllCustomers() {
        List<CustomerService> customerServices = customerServiceService.getAllCustomerServices();
        return ResponseEntity.ok(customerServices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerService> getCustomerById(@PathVariable Long id) {
        CustomerService customerService = customerServiceService.getCustomerServiceById(id);
        return ResponseEntity.ok(customerService);
    }

    @PostMapping
    public ResponseEntity<CustomerService> createCustomer(@RequestBody CustomerService customerService) {
        CustomerService createdCustomerService = customerServiceService.createService(customerService);
        return ResponseEntity.ok(createdCustomerService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerService> updateCustomer(@PathVariable Long id, @RequestBody CustomerService customerService) {
        customerService.setId(id);
        CustomerService updatedCustomerService = customerServiceService.updateService(customerService);
        return ResponseEntity.ok(updatedCustomerService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerServiceService.deleteCustomerServiceById(id);
        return ResponseEntity.noContent().build();
    }

}
