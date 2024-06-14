package br.com.fortaleza.consultorio.mapper;

import br.com.fortaleza.consultorio.model.ClassifierModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ClassifierMapper implements ResultSetExtractor<List<ClassifierModel>> {

    @Override
    public List<ClassifierModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<ClassifierModel> resultList = new ArrayList<>();
        if (rs.next()) {
            ClassifierModel result = new ClassifierModel();
            result.setId(UUID.fromString(rs.getString("id")));
            result.setType(rs.getString("type"));
            result.setValue(rs.getString("value"));

            resultList.add(result);
        }

        return resultList;
    }

}
