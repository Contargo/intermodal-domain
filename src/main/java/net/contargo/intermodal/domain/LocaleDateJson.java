package net.contargo.intermodal.domain;

/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

import java.time.LocalDate;


/**
 * Custom JSON serializer for Instant.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class LocalDataJsonSerializer extends StdSerializer<LocalDate> {

    private ObjectMapper mapper = new ObjectMapper();

    public LocalDataJsonSerializer() {

        this(null);
    }


    public LocalDataJsonSerializer(Class<LocalDate> t) {

        super(t);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeString(value.toString());
    }
}

/**
 * Custom JSON deserializer for Instant.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class LocalDataJsonDeserializer extends StdDeserializer<LocalDate> {

    public LocalDataJsonDeserializer() {

        this(null);
    }


    public LocalDataJsonDeserializer(Class<?> t) {

        super(t);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {

        String dateString = jsonParser.getValueAsString();

        return LocalDate.parse(dateString);
    }
}
