package pe.com.lapositiva.pocspringwebflux.service.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.client.soap.NumberToWordsSoapClient;
import pe.com.lapositiva.pocspringwebflux.entity.dto.client.NumberToWordRequestDto;
import pe.com.lapositiva.pocspringwebflux.entity.dto.client.NumberToWordsResponseDto;
import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.NumberConversionRequestDto;
import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.NumberConversionResponseDto;
import pe.com.lapositiva.pocspringwebflux.service.NumberConversionService;

@RequiredArgsConstructor
@Service
public class NumberConversionServiceImpl implements NumberConversionService {

    private final NumberToWordsSoapClient numberToWordsSoapClient;

    @Override
    public Mono<NumberConversionResponseDto> convertNumberToWords(NumberConversionRequestDto request) {
        NumberToWordRequestDto numberToWordRequestDto = new NumberToWordRequestDto();
        numberToWordRequestDto.setUbiNum(request.getNumber());

        return numberToWordsSoapClient.numberToWords(numberToWordRequestDto).map(this::numberConversionResponseDto);
    }

    private NumberConversionResponseDto numberConversionResponseDto(NumberToWordsResponseDto response) {
        NumberConversionResponseDto numberConversionResponseDto = new NumberConversionResponseDto();
        numberConversionResponseDto.setResult(response.getNumberToWordsResult());
        return numberConversionResponseDto;

    }

}
