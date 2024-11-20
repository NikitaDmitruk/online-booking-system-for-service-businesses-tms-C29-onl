package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto.ScheduleDto;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Schedule;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {

//    @PostMapping
//    public ResponseEntity<Schedule> createSchedule(@RequestBody ScheduleDto scheduleDto,
//                                                   @AuthenticationPrincipal User user) {
//
//    }

}
