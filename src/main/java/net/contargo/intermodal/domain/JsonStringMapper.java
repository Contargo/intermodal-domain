package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class JsonStringMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String map(Object object) throws JsonProcessingException {

        return mapper.writeValueAsString(object);
    }
}
