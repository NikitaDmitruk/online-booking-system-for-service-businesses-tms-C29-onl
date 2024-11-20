package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.Constants;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Schedule;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.validation.SchemaFactoryConfigurationError;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {
        List<LocalTime> availableSlots = new ArrayList<>();
        List<LocalTime> unavailableSlots = new ArrayList<>();
        Duration shift = Duration.between(schedule.getStartTime(), schedule.getEndTime());
        for (long i = 0; i < shift.toMinutes(); i = i + Constants.SLOT_TIME_IN_MINUTES) {
            availableSlots.add(schedule.getStartTime().plusMinutes(i));
        }
        schedule.setAvailableSlots(availableSlots);
        schedule.setUnavailableSlots(unavailableSlots);
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
        updatedSchedule.setShiftDate(schedule.getShiftDate());
        updatedSchedule.setStartTime(schedule.getStartTime());
        updatedSchedule.setEndTime(schedule.getEndTime());
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
