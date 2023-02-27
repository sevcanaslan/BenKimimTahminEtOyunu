package com.maraton.controller;

import com.maraton.dto.request.UserLoginRequestDto;
import com.maraton.dto.request.UserRegisterRequestDto;
import com.maraton.dto.response.UserFindAllResponseDto;
import com.maraton.repository.entity.User;
import com.maraton.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.maraton.constants.RestEndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+USER)
public class UserController {
    private final UserService userService;

    @PostMapping(REGISTER)
    public ResponseEntity<UserRegisterRequestDto> register(@RequestBody UserRegisterRequestDto dto){
        userService.register(dto);
        return ResponseEntity.ok(UserRegisterRequestDto.builder().state(true).build());
    }

    @PostMapping(LOGIN)
    public ResponseEntity<UserLoginRequestDto> userLogin(@RequestBody UserLoginRequestDto dto){
        userService.login(dto);
        return ResponseEntity.ok(UserLoginRequestDto.builder().state(true).build());

    }
    @GetMapping("/findall")
    public List<UserFindAllResponseDto> findAllUsers() {
        return userService.findAllUsers();

    }
    @GetMapping("/orderbyname")
    public ResponseEntity< List<User>> findAllByOrderByName(){

        return ResponseEntity.ok(userService.findAllByOrderByName());
    }
    @GetMapping("/findbynamewithlike")
    public ResponseEntity< List<User>> findAllByNameLike(String name){

        return ResponseEntity.ok(userService.findAllByNameLike("%"+name+"%"));
    }

}
