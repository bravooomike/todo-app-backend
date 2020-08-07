package pl.bravooomike.todo.taskStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/todo/taskStatus")
public class TaskStatusController {

    private TaskStatusService taskStatusService;

    @Autowired
    public TaskStatusController(TaskStatusService taskStatusService) {
        this.taskStatusService = taskStatusService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<TaskStatusDto> getAll() {
        return taskStatusService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TaskStatusDto getOne(@PathVariable("id") Integer id) {
        return taskStatusService.getOne(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public TaskStatusDto save(@RequestBody TaskStatusDto taskStatusDto) {
        return taskStatusService.save(taskStatusDto);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public TaskStatusDto update(@RequestBody TaskStatusDto taskStatusDto, @PathVariable("id") Integer id) {
        return taskStatusService.save(taskStatusDto, id);
    }
}
