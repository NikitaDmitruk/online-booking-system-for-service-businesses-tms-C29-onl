package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByOwnerId(Long owner_id);
    boolean existsByIdAndOwnerId(Long id, Long owner_id);
}
