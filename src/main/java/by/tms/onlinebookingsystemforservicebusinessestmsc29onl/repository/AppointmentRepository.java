package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
