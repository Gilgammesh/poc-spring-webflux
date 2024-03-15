package pe.com.lapositiva.pocspringwebflux.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.client.http.JsonPlaceHolderHttpClient;
import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.UserResponseDto;
import pe.com.lapositiva.pocspringwebflux.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final JsonPlaceHolderHttpClient jsonPlaceHolderHttpClient;

    @Override
    public Mono<UserResponseDto> getUser() {

        return jsonPlaceHolderHttpClient.getUser();
    }

}
