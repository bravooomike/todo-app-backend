package pl.bravooomike.todo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/todoapp/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<UserDto> getall() {
        return userService.getAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public UserDto getOne(@PathVariable("id") Integer id) {
        return userService.getOne(id);
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto, null);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public UserDto update(@RequestBody UserDto userDto, @PathVariable("id") Integer id) {
        return userService.save(userDto, id);
    }
}
