package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_customer_service")
public class CustomerService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ServiceCategory category;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Project provider;

    @OneToMany(mappedBy = "customerService", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}
