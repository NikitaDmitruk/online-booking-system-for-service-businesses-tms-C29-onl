package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto.ScheduleDto;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Project;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Schedule;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project, @AuthenticationPrincipal User user) {
        project.setOwner(user);
        Project createdProject = projectService.create(project);
        return ResponseEntity.ok(createdProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        project.setId(id);
        Project updatedProject = projectService.updateProject(project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable Long id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping("/projects/{id}/schedules")
//    public ResponseEntity<Schedule> createSchedule(@PathVariable Long id,
//                                                   @RequestBody ScheduleDto scheduleDto,
//                                                   @AuthenticationPrincipal User user) {
//        Project project = projectService.getProjectById(id);
//        if (project.getOwner().equals(user)) {
//
//        }
//
//    }

//    @PostMapping("/{id}/members")
//    public Project addMemberToProject(@PathVariable Long id, @RequestBody User user) {
//        // Добавляет участника к проекту
//    }
}
