package com.bede.users.rest;

import com.bede.users.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static final Map<String, UserDto> users = new HashMap<>();
    private final Map<String, UserDto> loggedUsers = new HashMap<>();

    static {
        users.put("raissa", createUser("raissa", "miki94", "Raissa", "Fadhlaoui"));
        users.put("hamza", createUser("hamza", "bejito94", "Hamza", "Benketaf"));
        users.put("rayan", createUser("rayan", "rarayan", "Rayan", "Fadhlaoui"));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> get(@RequestBody UserDto userDto) {
        UserDto loadedUserDto = users.get(userDto.getName().toLowerCase());
        if (!loadedUserDto.getPassword().equals(userDto.getPassword())) {
            loadedUserDto = new UserDto();
        } else {
            loggedUsers.put(userDto.getName().toLowerCase(), userDto);
        }
        return ResponseEntity.ok(loadedUserDto);
    }

    @RequestMapping(value = "/loggedUsers", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getLoggedUsers() {
        return ResponseEntity.ok(new ArrayList<>(loggedUsers.values()));
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<Void> logout(@RequestBody UserDto userDto) {
        loggedUsers.remove(userDto.getName());
        return ResponseEntity.noContent().build();
    }

    private static UserDto createUser(String name, String password, String firstName, String lastName) {
        UserDto userDto = new UserDto();
        userDto.setName(name);
        userDto.setPassword(password);
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        return userDto;
    }
}