package br.com.fortaleza.consultorio.repository.read;

import br.com.fortaleza.consultorio.model.ClassifierModel;

import java.util.Optional;

public interface IClassifierReadRepository extends IBaseReadRepository<ClassifierModel> {
    Optional<ClassifierModel> findByType(String type);
}
