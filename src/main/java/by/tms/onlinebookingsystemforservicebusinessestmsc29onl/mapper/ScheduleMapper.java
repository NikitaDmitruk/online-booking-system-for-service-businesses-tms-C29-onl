package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.mapper;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto.ScheduleDto;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    ScheduleDto toDto(Schedule schedule);
    Schedule toEntity(ScheduleDto scheduleDto);
}
