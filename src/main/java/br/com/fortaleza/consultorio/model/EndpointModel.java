package br.com.fortaleza.consultorio.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.UUID;

@Getter
@Setter
@Data
@Builder
public class EndpointModel {
    private UUID id;
    private ClassifierModel classifier;
    private String key;
    private String description;
    private String token;
    private String url;

    public static String getTableName() {
        return "endpoint";
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
