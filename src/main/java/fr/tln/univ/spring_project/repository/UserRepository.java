package fr.tln.univ.spring_project.repository;

import fr.tln.univ.spring_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    Optional<T> findByUsername(String username);
    Optional<T> findByNationalCode(long nationalCode);
}
