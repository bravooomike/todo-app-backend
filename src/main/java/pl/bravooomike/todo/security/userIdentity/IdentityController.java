package pl.bravooomike.todo.security.userIdentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.bravooomike.todo.user.UserRepository;

@RestController
@RequestMapping(path = "/rest/todo/auth")
public class IdentityController {

    private IdentityProviderImplementation identityProvider;
    private UserRepository userRepository;

    @Autowired
    public IdentityController(IdentityProviderImplementation identityProvider, UserRepository userRepository) {
        this.identityProvider = identityProvider;
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public UserIdentity getIdentity() {
        return this.identityProvider.get();
    }

}
