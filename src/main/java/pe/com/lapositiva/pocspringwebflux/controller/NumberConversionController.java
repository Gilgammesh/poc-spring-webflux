package pe.com.lapositiva.pocspringwebflux.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.NumberConversionRequestDto;
import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.NumberConversionResponseDto;
import pe.com.lapositiva.pocspringwebflux.service.NumberConversionService;

@RequiredArgsConstructor
@RestController
@SuppressWarnings("null")
@RequestMapping("/conversion")
public class NumberConversionController {

    private final NumberConversionService numberConversionService;

    @PostMapping()
    public Mono<ResponseEntity<NumberConversionResponseDto>> convertNumberToWords(
            @RequestBody NumberConversionRequestDto request) {
        return numberConversionService.convertNumberToWords(request)
                .map(response -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response));
    }

}
