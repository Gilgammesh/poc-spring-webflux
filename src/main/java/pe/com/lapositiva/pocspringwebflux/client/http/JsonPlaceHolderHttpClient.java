package pe.com.lapositiva.pocspringwebflux.client.http;

import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.UserResponseDto;

public interface JsonPlaceHolderHttpClient {

    public Mono<UserResponseDto> getUser();

}
