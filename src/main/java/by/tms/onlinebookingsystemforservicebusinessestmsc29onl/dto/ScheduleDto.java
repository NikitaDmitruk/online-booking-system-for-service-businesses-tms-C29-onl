package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {

    private LocalDate date; // Конкретная дата расписания.
    private LocalTime start;
    private LocalTime end;
}
