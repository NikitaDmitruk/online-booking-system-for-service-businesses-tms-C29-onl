package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto.ScheduleDto;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Schedule;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.mapper.ScheduleMapper;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    private final ScheduleMapper scheduleMapper;

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleDto scheduleDto) {
        Schedule schedule = scheduleMapper.toEntity(scheduleDto);
        return ResponseEntity.ok(scheduleService.createSchedule(schedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        schedule.setId(id);
        return ResponseEntity.ok(scheduleService.updateSchedule(schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteScheduleById(id);
        return ResponseEntity.noContent().build();
    }


}
