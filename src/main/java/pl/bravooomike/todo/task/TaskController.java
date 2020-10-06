package pl.bravooomike.todo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public Page<TaskDto> getAll(String filter, Boolean allTasks, Pageable pageable) {
//        System.out.println(filter);
//        System.out.println(allTasks);
        return taskService.getAll(filter, allTasks, pageable);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TaskDto getOne(@PathVariable("id") Integer id) {
        return taskService.getOne(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public TaskDto save(@RequestBody TaskDto taskDto) {
        return taskService.save(taskDto, null);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public TaskDto update(@PathVariable("id") Integer id, @RequestBody TaskDto taskDto) {
        return taskService.save(taskDto, id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteOne(@PathVariable("id") Integer id) {
        taskService.deleteOne(id);
    }
}
