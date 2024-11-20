package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Schedule;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.validation.SchemaFactoryConfigurationError;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(SchemaFactoryConfigurationError::new);
    }

    public Schedule updateSchedule(Schedule schedule) {
        Schedule updatedSchedule = scheduleRepository.findById(schedule.getId()).orElseThrow(SchemaFactoryConfigurationError::new);
        updatedSchedule.setProvider(schedule.getProvider());
        updatedSchedule.setDate(schedule.getDate());
        updatedSchedule.setStart(schedule.getStart());
        updatedSchedule.setEnd(schedule.getEnd());
        updatedSchedule.setAvailableSlots(schedule.getAvailableSlots());
        updatedSchedule.setUnavailableSlots(schedule.getUnavailableSlots());
        updatedSchedule.setAppointments(schedule.getAppointments());
        return scheduleRepository.save(updatedSchedule);
    }

    public void deleteScheduleById(Long id) {
        scheduleRepository.findById(id).orElseThrow(SchemaFactoryConfigurationError::new);
        scheduleRepository.deleteById(id);
    }
}
