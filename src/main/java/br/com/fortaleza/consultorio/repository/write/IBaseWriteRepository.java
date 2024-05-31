package br.com.fortaleza.consultorio.repository.write;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
import java.util.UUID;

public interface IBaseWriteRepository<T> {

    Optional<T> save(T model) throws SQLIntegrityConstraintViolationException;
    Optional<T> update(T model) throws SQLIntegrityConstraintViolationException;
    void delete(UUID id);

}
