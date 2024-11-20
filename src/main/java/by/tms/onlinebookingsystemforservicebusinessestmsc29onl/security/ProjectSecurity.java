package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.security;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.ProjectRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class ProjectSecurity {

    private final ProjectRepository projectRepository;

    public ProjectSecurity(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean hasAccessToProject(Long projectId, Authentication authentication) {
        Long userId = ((User) authentication.getPrincipal()).getId();
        return projectRepository.existsByIdAndOwnerId(projectId, userId); // Проверяем, что пользователь владелец проекта
    }
}
