package pe.com.lapositiva.pocspringwebflux.client.soap;

import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.client.NumberToWordRequestDto;
import pe.com.lapositiva.pocspringwebflux.entity.dto.client.NumberToWordsResponseDto;

public interface NumberToWordsSoapClient {

    public Mono<NumberToWordsResponseDto> numberToWords(NumberToWordRequestDto request);
}
