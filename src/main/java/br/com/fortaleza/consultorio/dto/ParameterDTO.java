package br.com.fortaleza.consultorio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ParameterDTO {
    private UUID id;
    private String name;
    private String value;
    private String description;
}
