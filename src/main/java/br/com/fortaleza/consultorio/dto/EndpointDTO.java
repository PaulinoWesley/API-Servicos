package br.com.fortaleza.consultorio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class EndpointDTO {
    private UUID id;
    private ClassifierDTO classifier;
    private String key;
    private String description;
    private String token;
    private String url;
}
