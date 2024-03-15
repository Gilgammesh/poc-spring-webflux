package pe.com.lapositiva.pocspringwebflux.entity.dto.controller;

import lombok.Data;

@Data
public class UserResponseDto {
    public int id;
    public String name;
    public String username;
    public String email;
    public UserAddressResponseDto address;
    public String phone;
    public String website;
    public UserCompanyResponseDto company;
}