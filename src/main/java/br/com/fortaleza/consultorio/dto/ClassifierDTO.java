package br.com.fortaleza.consultorio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class ClassifierDTO {
    private UUID id;
    private String value;
    private String type;
}
