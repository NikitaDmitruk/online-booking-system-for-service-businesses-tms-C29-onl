package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Appointment;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.AppointmentNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Appointment appointment) {
        Appointment appointmentToUpdate = appointmentRepository.findById(appointment.getId())
                .orElseThrow(() -> new AppointmentNotFoundException("Запись на услугу не найдена."));
        appointmentToUpdate.setClient(appointment.getClient());
        appointmentToUpdate.setCustomerService(appointment.getCustomerService());
        appointmentToUpdate.setAppointmentTime(appointment.getAppointmentTime());
        appointmentToUpdate.setStatus(appointment.getStatus());
        return appointmentRepository.save(appointmentToUpdate);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Запись на услугу не найдена."));
    }

    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public void deleteAppointment(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
