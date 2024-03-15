package pe.com.lapositiva.pocspringwebflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.UserResponseDto;
import pe.com.lapositiva.pocspringwebflux.service.UserService;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Mono<UserResponseDto> getUser() {

        return userService.getUser();
    }

}
