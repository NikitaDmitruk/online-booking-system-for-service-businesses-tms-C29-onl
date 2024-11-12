package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.repository;


import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
