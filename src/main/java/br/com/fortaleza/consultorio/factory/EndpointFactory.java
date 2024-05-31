package br.com.fortaleza.consultorio.factory;

import br.com.fortaleza.consultorio.dto.EndpointDTO;
import br.com.fortaleza.consultorio.model.EndpointModel;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EndpointFactory {

    private final ClassifierFactory classifierFactory;

    public EndpointModel toModel(EndpointDTO dto) {
        return EndpointModel.builder()
                .id(dto.getId())
                .classifier(classifierFactory.toModel(dto.getClassifier()))
                .key(dto.getKey())
                .description(dto.getDescription())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .token(dto.getToken())
                .url(dto.getUrl())
                .build();
    }

    public EndpointDTO toDTO(EndpointModel model) {
        return EndpointDTO.builder()
                .id(model.getId())
                .classifier(classifierFactory.toDTO(model.getClassifier()))
                .key(model.getKey())
                .description(model.getDescription())
                .username(model.getUsername())
                .password(model.getPassword())
                .token(model.getToken())
                .url(model.getUrl())
                .build();
    }

    public Page<EndpointDTO> toPageDTO(Page<EndpointModel> page) {
        return !page.isEmpty() && page.getSize() > 0
                ? page.map(this::toDTO)
                : null;
    }

}
