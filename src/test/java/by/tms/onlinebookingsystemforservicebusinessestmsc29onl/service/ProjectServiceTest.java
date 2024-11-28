package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;


import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Project;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @InjectMocks
    ProjectService projectService;

    @Mock
    ProjectRepository projectRepository;

    @Test
    void create() {
        Project project = new Project();
        project.setName("test");
        Mockito.when(projectRepository.save(project)).thenReturn(project);
        Assertions.assertNotNull(projectService.create(project));
        Assertions.assertEquals(project.getName(), projectService.create(project).getName());
    }
}