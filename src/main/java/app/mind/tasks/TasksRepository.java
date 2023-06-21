package app.mind.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

    @Query("SELECT d FROM Tasks d WHERE d.dateCreated = ?1")
    Optional<Tasks> findTasksByDateCreated(LocalDate dateCreated);



}
