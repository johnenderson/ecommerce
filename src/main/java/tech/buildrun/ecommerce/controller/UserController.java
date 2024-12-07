package tech.buildrun.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.ecommerce.controller.dto.CreateUserDTO;
import tech.buildrun.ecommerce.entities.UserEntity;
import tech.buildrun.ecommerce.service.UserService;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> findById(@PathVariable("userId") UUID userId) {

        var user = userService.findById(userId);

        return user.isPresent() ?
                ResponseEntity.ok(user.get()) :
                ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO dto){

        var user = userService.createUser(dto);

        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).build();

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletedById(@PathVariable("userId") UUID userId) {

        var deleted = userService.deletedById(userId);

        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();

    }


}
