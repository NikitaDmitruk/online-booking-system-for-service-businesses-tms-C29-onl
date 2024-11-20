package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.audit.AuditMetadata;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_customer_service")
public class CustomerService extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String duration;
    private BigDecimal price;
    private Integer brakeAfterService;
    @ElementCollection
    private List<String> examplesOfWorks;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ServiceCategory category;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Project provider;

    @OneToMany(mappedBy = "customerService", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

}
