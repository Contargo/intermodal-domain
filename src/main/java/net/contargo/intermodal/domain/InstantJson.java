package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import tec.units.ri.quantity.Quantities;

import java.io.IOException;
import java.io.StringWriter;

import java.time.Instant;


/**
 * Custom JSON serializer for Instant.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class InstantJsonSerializer extends StdSerializer<Instant> {

    private ObjectMapper mapper = new ObjectMapper();

    public InstantJsonSerializer() {

        this(null);
    }


    public InstantJsonSerializer(Class<Instant> t) {

        super(t);
    }

    @Override
    public void serialize(Instant value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeString(value.toString());
    }
}

/**
 * Custom JSON deserializer for Quantities.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class InstantJsonDeserializer extends StdDeserializer<Instant> {

    public InstantJsonDeserializer() {

        this(null);
    }


    public InstantJsonDeserializer(Class<?> t) {

        super(t);
    }

    @Override
    public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {

        String instantString = jsonParser.getValueAsString();

        return Instant.parse(instantString);
    }
}
