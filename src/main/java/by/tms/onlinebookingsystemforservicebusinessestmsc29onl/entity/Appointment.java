package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String notes;
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "customer_service_id")
    private CustomerService customerService;

    public enum AppointmentStatus {
        CONFIRMED, PENDING, APPROVED, REJECTED;
    }

}
