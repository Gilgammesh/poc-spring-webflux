package pe.com.lapositiva.pocspringwebflux.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.FeatureResponseDto;
import pe.com.lapositiva.pocspringwebflux.service.FeatureService;

@RequiredArgsConstructor
@Service
public class FeatureServiceImpl implements FeatureService {

    private static final List<FeatureResponseDto> ListFeatures = Arrays.asList(
            new FeatureResponseDto("16001", "Validar Distribucion Soat"),
            new FeatureResponseDto("16002", "Obtener Tarifa Soat"),
            new FeatureResponseDto("16003", "Emitir Poliza SOAT - Reg Cliente"),
            new FeatureResponseDto("16005", "Generar Documento Autorizado"),
            new FeatureResponseDto("16006", "Procesar Planilla"));

    @Override
    public Flux<FeatureResponseDto> listAll() {
        return Flux.fromIterable(ListFeatures);
    }

    @Override
    public Mono<FeatureResponseDto> getById(String id) {
        return Mono.justOrEmpty(ListFeatures.stream().filter(f -> f.getCodigo().equals(id)).findFirst());
    }

}
