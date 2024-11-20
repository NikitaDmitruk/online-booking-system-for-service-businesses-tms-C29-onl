package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date; // Конкретная дата расписания.
    private LocalTime start;
    private LocalTime end;

    @ElementCollection
    private List<LocalTime> availableSlots;// Список доступных временных слотов.

    @ElementCollection
    private List<LocalTime> unavailableSlots;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Appointment> appointments; // Список бронирований на это расписание.

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Project provider; // Проект, предоставляющий услугу.
}
