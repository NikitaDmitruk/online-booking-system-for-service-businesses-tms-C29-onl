package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Appointment;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.AppointmentNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Appointment appointment) {
        Appointment appointmentToUpdate = appointmentRepository.findById(appointment.getId())
                .orElseThrow(AppointmentNotFoundException::new);
        appointmentToUpdate.setClient(appointment.getClient());
        appointmentToUpdate.setCustomerService(appointment.getCustomerService());
        appointmentToUpdate.setAppointmentTime(appointment.getAppointmentTime());
        appointmentToUpdate.setStatus(appointment.getStatus());
        return appointmentRepository.save(appointmentToUpdate);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(AppointmentNotFoundException::new);
    }

    public void deleteAppointmentById(Long id) {
        appointmentRepository.findById(id).orElseThrow(AppointmentNotFoundException::new);
        appointmentRepository.deleteById(id);
    }

    public void deleteAppointment(Appointment appointment) {
        appointmentRepository.findById(appointment.getId()).orElseThrow(AppointmentNotFoundException::new);
        appointmentRepository.delete(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
