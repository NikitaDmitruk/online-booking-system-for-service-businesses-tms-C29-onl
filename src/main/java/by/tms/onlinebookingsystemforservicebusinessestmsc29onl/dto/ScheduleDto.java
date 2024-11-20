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

    private LocalDate shiftDate; // Конкретная дата расписания.
    private LocalTime startTime; // Время начала рабочего дня
    private LocalTime endTime; // Время окончания рабочего дня
}
