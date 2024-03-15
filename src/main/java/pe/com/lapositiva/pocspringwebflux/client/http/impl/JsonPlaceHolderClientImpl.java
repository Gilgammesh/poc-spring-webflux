package pe.com.lapositiva.pocspringwebflux.client.http.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.UserResponseDto;
import pe.com.lapositiva.pocspringwebflux.client.http.JsonPlaceHolderHttpClient;

@Slf4j
@SuppressWarnings("null")
@RequiredArgsConstructor
@Component
public class JsonPlaceHolderClientImpl implements JsonPlaceHolderHttpClient {

    private WebClient webClient;

    @Value("${http.address}")
    private String httpAddress;

    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder().baseUrl(httpAddress).build();
    }

    @Override
    public Mono<UserResponseDto> getUser() {

        log.info("Servicio HTTP Consumido es: {}", httpAddress);

        return webClient.get().retrieve().bodyToMono(String.class).map(this::jsonToDto);

    }

    private UserResponseDto jsonToDto(String json) {
        log.info("Respuesta Consulta HTTP: {}", json);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, UserResponseDto.class);

        } catch (Exception e) {
            throw new RuntimeException("Error al convertir JSON a DTO", e);
        }
    }

}
