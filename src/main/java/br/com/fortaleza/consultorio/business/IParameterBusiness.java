package br.com.fortaleza.consultorio.business;

import br.com.fortaleza.consultorio.exception.NotFoundException;
import br.com.fortaleza.consultorio.model.ParameterModel;


public interface IParameterBusiness extends IBaseBusiness<ParameterModel> {
    ParameterModel findByName(String name) throws NotFoundException;
}
