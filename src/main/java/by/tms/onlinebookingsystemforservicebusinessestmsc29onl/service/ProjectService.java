package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.service;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.Project;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.exception.ProjectNotFoundException;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) {
        Project projectToUpdate = projectRepository.findById(project.getId())
                .orElseThrow(ProjectNotFoundException::new);
        projectToUpdate.setName(project.getName());
        projectToUpdate.setDescription(project.getDescription());
        projectToUpdate.setOwner(project.getOwner());
        projectToUpdate.setMembers(project.getMembers());
        projectToUpdate.setCompany(project.isCompany());
        projectToUpdate.setCustomerServices(project.getCustomerServices());
        projectToUpdate.setInteriorPhotos(project.getInteriorPhotos());
        projectToUpdate.setExamplesOfWorks(project.getExamplesOfWorks());
        projectToUpdate.setMessages(project.getMessages());
        projectToUpdate.setProjectAddress(project.getProjectAddress());
        projectToUpdate.setSubCategory(project.getSubCategory());
        projectToUpdate.setSchedules(project.getSchedules());
        return projectRepository.save(projectToUpdate);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(ProjectNotFoundException::new);
    }

    public void deleteProjectById(Long id) {
        projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);
        projectRepository.deleteById(id);
    }

    public void deleteProject(Project project) {
        projectRepository.findById(project.getId()).orElseThrow(ProjectNotFoundException::new);
        projectRepository.delete(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectsByOwnerId(Long ownerId) {
        return projectRepository.findAllByOwnerId(ownerId);
    }
}
