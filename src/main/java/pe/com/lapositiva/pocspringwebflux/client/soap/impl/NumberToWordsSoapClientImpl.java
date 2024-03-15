package pe.com.lapositiva.pocspringwebflux.client.soap.impl;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.client.soap.NumberToWordsSoapClient;
import pe.com.lapositiva.pocspringwebflux.entity.dto.client.NumberToWordRequestDto;
import pe.com.lapositiva.pocspringwebflux.entity.dto.client.NumberToWordsResponseDto;

@Slf4j
@RequiredArgsConstructor
@Component
public class NumberToWordsSoapClientImpl implements NumberToWordsSoapClient {

    @Override
    public Mono<NumberToWordsResponseDto> numberToWords(NumberToWordRequestDto request) {

        throw new UnsupportedOperationException("Unimplemented method 'numberToWords'");
    }

}
