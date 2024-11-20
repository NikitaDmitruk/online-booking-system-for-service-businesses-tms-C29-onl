package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.audit.AuditMetadata;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_user")
public class User extends AuditMetadata implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    private String email;
    @Column(unique = true, nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    private String avatar;
    @ElementCollection
    private List<String> messages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnore
    private Set<Role> roles;

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private List<Project> ownedProjects;

    @ManyToMany(mappedBy = "members")
    @JsonIgnore
    private List<Project> projects;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
}
