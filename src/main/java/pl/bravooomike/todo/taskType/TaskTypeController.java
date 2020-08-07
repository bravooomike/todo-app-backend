package pl.bravooomike.todo.taskType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/todo/taskType")
public class TaskTypeController {

    private TaskTypeService taskTypeService;

    @Autowired
    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<TaskTypeDto> getAll() {
        return taskTypeService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TaskTypeDto getOne(@PathVariable("id") Integer id) {
        return taskTypeService.getOne(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public TaskTypeDto save(@RequestBody TaskTypeDto taskTypeDto) {
        return taskTypeService.save(taskTypeDto);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public TaskTypeDto update(@RequestBody TaskTypeDto taskTypeDto, @PathVariable("id") Integer id) {
        return taskTypeService.save(taskTypeDto, id);
    }


}
