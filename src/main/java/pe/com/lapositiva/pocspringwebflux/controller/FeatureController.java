package pe.com.lapositiva.pocspringwebflux.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.entity.dto.controller.FeatureResponseDto;
import pe.com.lapositiva.pocspringwebflux.service.FeatureService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureService featureService;

    @GetMapping()
    public Mono<ResponseEntity<List<FeatureResponseDto>>> listAll() {
        return featureService.listAll().collectList()
                .map(list -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(list));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<FeatureResponseDto>> getById(@PathVariable String id) {
        return featureService.getById(id)
                .map(f -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(f))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
