package pe.com.lapositiva.pocspringwebflux.entity.dto.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FeatureResponseDto {
    @JsonProperty("Codigo")
    private String codigo;

    @JsonProperty("Servicio")
    private String servicio;

}
