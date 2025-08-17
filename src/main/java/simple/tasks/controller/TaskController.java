package simple.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple.tasks.model.Tasks;
import simple.tasks.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    //Create a task
    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestParam String title, @RequestParam String description) {

        Tasks task = taskService.createTask(title, description);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    //Get all tasks
    @GetMapping
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    //Get tasks by id
    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable Long id) {
       Tasks task = taskService.getTaskById(id);

       if (task == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(HttpStatus.OK);
    }

    //Mark as task DONE
    @PutMapping("/{id}/done")
    public ResponseEntity<Tasks> markTaskAsDone(@PathVariable Long id) {
      Tasks task = taskService.updateTasksStatus(id);

      if (task == null) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(HttpStatus.OK);
    }

    //Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
       boolean isDeleted = taskService.deleteTask(id);

       if (!isDeleted) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
