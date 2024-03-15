package pe.com.lapositiva.pocspringwebflux.service;

import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.UserResponseDto;

public interface UserService {

    public Mono<UserResponseDto> getUser();

}
