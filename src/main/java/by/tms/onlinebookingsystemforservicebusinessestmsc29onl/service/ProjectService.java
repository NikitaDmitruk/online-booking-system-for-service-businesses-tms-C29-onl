package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Project;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.ProjectNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;


    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) throws ProjectNotFoundException {
        Project projectToUpdate = projectRepository.findById(project.getId()).
                orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        projectToUpdate.setName(project.getName());
        projectToUpdate.setDescription(project.getDescription());
        projectToUpdate.setOwner(project.getOwner());
        projectToUpdate.setMembers(project.getMembers());
        projectToUpdate.setCompany(project.isCompany());
        projectToUpdate.setCustomerServices(project.getCustomerServices());
        return projectRepository.save(projectToUpdate);
    }

    public Project getProjectById(Long id) throws ProjectNotFoundException {
        return projectRepository.findById(id).
                orElseThrow(() -> new ProjectNotFoundException("Project not found"));
    }

    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
