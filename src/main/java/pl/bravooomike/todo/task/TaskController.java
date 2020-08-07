package pl.bravooomike.todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/todo/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<TaskDto> getAll() {
        return taskService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TaskDto getOne(@PathVariable("id") Integer id) {
        return taskService.getOne(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public TaskDto save(@RequestBody TaskDto taskDto) {
        return taskService.save(taskDto, null);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public TaskDto update(@RequestBody TaskDto taskDto, @PathVariable("id") Integer id) {
        return taskService.save(taskDto, id);
    }
}
