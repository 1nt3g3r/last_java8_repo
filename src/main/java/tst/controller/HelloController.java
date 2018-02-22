package tst.controller;

import tst.controller.entity.Role;
import tst.controller.entity.User;
import tst.controller.repository.RoleRepository;
import tst.controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/setup")
    public String setup() {
        //Users
        User user1 = new User();
        user1.setFirstName("Max");
        user1.setLastName("Lazar");
        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("Nick");
        user2.setLastName("Thompson");
        userRepository.save(user2);

        User user3 = new User();
        user3.setFirstName("Steven");
        user3.setLastName("King");
        userRepository.save(user3);

        //Roles
        Role role1 = new Role();
        role1.setName("Admin");
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setName("User");
        roleRepository.save(role2);

        Role role3 = new Role();
        role3.setName("Guest");
        roleRepository.save(role3);

        //Join users & roles
        List<Role> user1Roles = new ArrayList<>();
        user1Roles.add(role1);
        user1Roles.add(role2);
        user1Roles.add(role3);
        user1.setRoles(user1Roles);
        userRepository.save(user1);

        return "ok";
    }

    @GetMapping("/user/listAll")
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
