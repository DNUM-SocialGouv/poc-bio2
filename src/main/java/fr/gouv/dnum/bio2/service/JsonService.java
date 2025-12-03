package fr.gouv.dnum.bio2.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonService {

    public ObjectMapper getObjectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .featuresToDisable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
                .build();
    }

}
