package simple.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simple.tasks.model.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long> {


}
