package br.com.fortaleza.consultorio.factory;

import br.com.fortaleza.consultorio.dto.ClassifierDTO;
import br.com.fortaleza.consultorio.model.ClassifierModel;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ClassifierFactory {

    public ClassifierModel toModel(ClassifierDTO dto) {
        return ClassifierModel.builder()
                .id(dto.getId())
                .type(dto.getType())
                .value(dto.getValue())
                .build();
    }

    public ClassifierDTO toDTO(ClassifierModel model) {
        return ClassifierDTO.builder()
                .id(model.getId())
                .value(model.getValue())
                .type(model.getValue())
                .build();
    }

    public Page<ClassifierDTO> toPageDTO(Page<ClassifierModel> page) {
        return !page.isEmpty() && page.getSize() > 0
                ? page.map(this::toDTO)
                : null;
    }

}
