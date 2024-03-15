package pe.com.lapositiva.pocspringwebflux.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.FeatureResponseDto;

public interface FeatureService {

    public Flux<FeatureResponseDto> listAll();

    public Mono<FeatureResponseDto> getById(String id);

}
