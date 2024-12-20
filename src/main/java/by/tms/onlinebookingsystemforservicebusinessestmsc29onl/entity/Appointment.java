package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.audit.AuditMetadata;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_appointment")
public class Appointment extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String notes;

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

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule; // Расписание, к которому привязана запись.

    public enum AppointmentStatus {
        PENDING, REJECTED, CANCELLED, CLIENT_ABSENT, APPROVED;
    }

}
