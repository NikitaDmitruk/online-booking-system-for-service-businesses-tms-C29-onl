package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.audit.AuditMetadata;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.embedded.ProjectAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_project")
public class Project extends AuditMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ElementCollection
    private List<String> interiorPhotos;
    @ElementCollection
    private List<String> examplesOfWorks;
    @ElementCollection
    private List<String> messages;


    @Embedded
    private ProjectAddress projectAddress;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToMany
    @JoinTable(name = "tb_project_members",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> members;

    private boolean isCompany;

    @OneToMany(mappedBy = "provider")
    private List<CustomerService> customerServices;

    @OneToMany(mappedBy = "provider")
    private List<Schedule> schedules;


}
