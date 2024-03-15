package pe.com.lapositiva.pocspringwebflux.service;

import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.NumberConversionRequestDto;
import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.NumberConversionResponseDto;

public interface NumberConversionService {

    public Mono<NumberConversionResponseDto> convertNumberToWords(NumberConversionRequestDto request);

}
