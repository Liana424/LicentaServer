package ubb.licenta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import ubb.licenta.entity.User;
import ubb.licenta.service.UserService;

import java.util.List;

@RestController
@CrossOrigin // pt cand facem request de pe front end care ruleaza de pe alt port
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/login")
    public User logIn() {
        return userService.loadCurrentUser();
    }


    @PostMapping()
    public Integer insert(@RequestBody User user) {
        Integer id = userService.insert(user);

        return id;
    }

    // cu toate ca aceste 2 metode de mai jos sunt ambele de tip Get
    // controllerul stie pe care sa o cheme in functie de path, adica in functie de ce ii dupa /
    // aici de exemplu avem denumire care asteapta un String
    @GetMapping(value = "/username={username}")
    public User findByUsername(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);

        return user;
    }

    // iar aici avem un Integer
    @GetMapping(value = "/id={id}")
    public User findById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);

        return user;
    }

    @GetMapping()
    public List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping(value = "/id={id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }
}
