package pe.com.lapositiva.pocspringwebflux.entity.dto.controller;

import lombok.Data;

@Data
public class UserAddressResponseDto {
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public UserAddressGeoResponseDto geo;
}
