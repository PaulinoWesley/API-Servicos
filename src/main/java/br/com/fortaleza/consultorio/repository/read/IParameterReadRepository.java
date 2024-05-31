package br.com.fortaleza.consultorio.repository.read;

import br.com.fortaleza.consultorio.model.ParameterModel;

import java.util.Optional;

public interface IParameterReadRepository extends IBaseReadRepository<ParameterModel> {
    Optional<ParameterModel> findByName(String name);
}
