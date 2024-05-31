package br.com.fortaleza.consultorio.factory;

import br.com.fortaleza.consultorio.dto.ParameterDTO;
import br.com.fortaleza.consultorio.model.ParameterModel;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ParameterFactory {

    public ParameterModel toModel(ParameterDTO dto) {
        return ParameterModel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .value(dto.getValue())
                .description(dto.getDescription())
                .build();
    }

    public ParameterDTO toDTO(ParameterModel model) {
        return ParameterDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .value(model.getValue())
                .description(model.getDescription())
                .build();
    }

    public Page<ParameterDTO> toPageDTO(Page<ParameterModel> page) {
        return !page.isEmpty() && page.getSize() > 0
                ? page.map(this::toDTO)
                : null;
    }

}
