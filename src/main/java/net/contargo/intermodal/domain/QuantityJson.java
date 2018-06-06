package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import tec.units.ri.quantity.Quantities;

import java.io.IOException;

import javax.measure.Quantity;


/**
 * Custom JSON serializer for Quantities.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class QuantityJsonSerializer extends StdSerializer<Quantity<?>> {

    public QuantityJsonSerializer() {

        this(null);
    }


    public QuantityJsonSerializer(Class<Quantity<?>> t) {

        super(t);
    }

    @Override
    public void serialize(Quantity<?> quantity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
        throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("value", quantity.getValue().doubleValue());
        jsonGenerator.writeStringField("unit", quantity.getUnit().toString());
        jsonGenerator.writeEndObject();
    }


    @Override
    public void serializeWithType(Quantity<?> quantity, JsonGenerator jsonGenerator, SerializerProvider serializers,
        TypeSerializer typeSer) throws IOException {

        typeSer.writeTypePrefixForObject(quantity, jsonGenerator);
        serialize(quantity, jsonGenerator, serializers);
        typeSer.writeTypeSuffixForObject(quantity, jsonGenerator);
    }
}

/**
 * Custom JSON deserializer for Quantities.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class QuantityJsonDeserializer extends StdDeserializer<Quantity<?>> {

    public QuantityJsonDeserializer() {

        this(null);
    }


    public QuantityJsonDeserializer(Class<?> t) {

        super(t);
    }

    @Override
    public Quantity<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {

        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        double value = node.get("value").doubleValue();
        String unit = node.get("unit").asText();

        return Quantities.getQuantity(value, UnitConverter.symbolToUnit(unit));
    }
}
