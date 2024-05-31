package br.com.fortaleza.consultorio.business.impl;

import br.com.fortaleza.consultorio.business.IClassifierBusiness;
import br.com.fortaleza.consultorio.exception.BadRequestException;
import br.com.fortaleza.consultorio.exception.BusinessException;
import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.model.ClassifierModel;
import br.com.fortaleza.consultorio.repository.read.IClassifierReadRepository;
import br.com.fortaleza.consultorio.repository.write.IClassifierWriteRepository;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import java.util.UUID;

import static br.com.fortaleza.consultorio.util.ProjectUtils.isValidUuid;

@Component
@AllArgsConstructor
public class ClassifierBusiness implements IClassifierBusiness {

    private final IClassifierWriteRepository rwRepository;
    private final IClassifierReadRepository roRepository;


    @Override
    public ClassifierModel findById(String id) throws NotFoundException, BadRequestException {
        if (id.isEmpty() || isValidUuid(id))
            throw new BadRequestException("O identificador do classifier não foi informado ou é inválido.");

        Optional<ClassifierModel> toReturn = roRepository.findById(UUID.fromString(id));

        if (toReturn.isEmpty())
            throw new NotFoundException(String.format("O classifier de UUID(%s) não foi encontrado ou não existe.", id));

        return toReturn.get();
    }

    @Override
    public Page<ClassifierModel> list(ClassifierModel model, Pageable pageable) throws BusinessException {
        return roRepository.list(model, pageable);
    }

    @Override
    public ClassifierModel saveOrUpdate(ClassifierModel model) throws SQLIntegrityConstraintViolationException, BusinessException {
        validateValues(model);

        if (model.getId() == null) {
            model.setId(UUID.randomUUID());
            return save(model);
        }

        return update(model);
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        Optional<ClassifierModel> found = roRepository.findById(id);

        if (found.isEmpty())
            throw new NotFoundException("Identificador do classifier não foi encontrado.");

        rwRepository.delete(id);

    }

    private static void validateValues(ClassifierModel model) throws BusinessException {
        if (model.getValue().isBlank() || model.getValue().isEmpty())
            throw new BusinessException("O atributo value informado não é válido.");
        if (model.getType().isBlank() || model.getType().isEmpty())
            throw new BusinessException("O atributo type não é válido.");
    }

    private ClassifierModel save(ClassifierModel model) throws SQLIntegrityConstraintViolationException, BusinessException {
        Optional<ClassifierModel> toReturn = rwRepository.save(model);

        if (toReturn.isEmpty())
            throw new BusinessException("Não foi possível salvar o classifier.");

        return  toReturn.get();
    }

    private ClassifierModel update(ClassifierModel model) throws SQLIntegrityConstraintViolationException, BusinessException {
        Optional<ClassifierModel> toReturn = rwRepository.update(model);

        if (toReturn.isEmpty())
            throw new BusinessException("Não foi possível atualizar o classifier.");

        return toReturn.get();
    }

}
