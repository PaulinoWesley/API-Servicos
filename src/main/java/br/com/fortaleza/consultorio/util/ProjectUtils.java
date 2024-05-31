package br.com.fortaleza.consultorio.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.regex.Pattern;

@Component
public class ProjectUtils {

    private final static String PATTERN_UUID = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    public static boolean isValidUuid(String uuid) {
        if (StringUtils.isEmpty(uuid))
            return false;

        Pattern pattern = Pattern.compile(PATTERN_UUID);

        return pattern.matcher(uuid).matches();
    }

    public static UUID generateUuid() {
        return UUID.randomUUID();
    }

}
