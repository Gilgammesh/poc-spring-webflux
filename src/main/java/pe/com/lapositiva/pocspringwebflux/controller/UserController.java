package pe.com.lapositiva.pocspringwebflux.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.UserResponseDto;
import pe.com.lapositiva.pocspringwebflux.service.UserService;

@RequiredArgsConstructor
@RestController
@SuppressWarnings("null")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public Mono<ResponseEntity<UserResponseDto>> getUser() {

        return userService.getUser().map(f -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(f))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
