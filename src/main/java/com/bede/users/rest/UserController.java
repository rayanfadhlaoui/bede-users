package com.bede.users.rest;

import com.bede.users.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("raissa", "miki94");
        users.put("hamza", "bejito94");
        users.put("rayan", "rarayan");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> get(@RequestBody UserDto userDto) {
        String password = users.get(userDto.getName().toLowerCase());
        ResponseEntity<UserDto> responseEntity;
        if (password == null) {
            userDto.setId(1);
            responseEntity = ResponseEntity.ok(userDto);
        } else {
            responseEntity = ResponseEntity.badRequest().build();
        }

        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> usersDto = users.entrySet()
                .stream()
                .map(entry -> {
                    UserDto userDto = new UserDto();
                    userDto.setName(entry.getKey());
                    userDto.setPassword(entry.getValue());
                    return userDto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(usersDto);
    }
}