package simple.tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import simple.tasks.model.Tasks;
import simple.tasks.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ConcurrentHashMap<Long, Tasks> taskCache = new ConcurrentHashMap<>();

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //create a task
    public Tasks createTask(String title, String description) {
        Tasks task = new Tasks(title, description);
        return taskRepository.save(task);
    }

    //Get all tasks (check cache first)
    public List<Tasks> getAllTasks() {

        //check cache first
        if(taskCache.isEmpty()){
            loadCache();
        }
        return taskRepository.findAll();
    }

    //Get task by ID, first cache check
    public Tasks getTaskById(Long id) {
        if (taskCache.containsKey(id)) {
            return taskCache.get(id);
        }

        Optional<Tasks> task = taskRepository.findById(id);
        return task.orElse(null); //return null if not found
    }

    //Mark task as DONE
    public Tasks updateTasksStatus(Long id){
        Tasks task = getTaskById(id);
        if (task != null && task.getStatus() != Tasks.TaskStatus.DONE) {
            task.setStatus(Tasks.TaskStatus.DONE);
            taskRepository.save(task);
            taskCache.put(id, task);
        }
        return task;
    }

    //delete a task
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);

            return true;
        }
        return false;
    }


    private void loadCache() {
        List<Tasks> tasks = taskRepository.findAll();
        for (Tasks task: tasks) {
            taskCache.put(task.getId(), task);
        }
    }
}
