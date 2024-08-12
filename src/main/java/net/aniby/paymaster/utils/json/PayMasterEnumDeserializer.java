package net.aniby.paymaster.utils.json;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PayMasterEnumDeserializer implements JsonDeserializer<PayMasterEnum> {
    private static final Gson CLEAR_GSON = new Gson();

    private static ArrayList<String> variants(String name) {
        String upperCased = name.toUpperCase();
        String delimited = Arrays.stream(name.split("(?=\\p{Lu})"))
                .map(String::toUpperCase)
                .collect(Collectors.joining("_"));
        return new ArrayList<>(List.of(delimited, upperCased));
    }

    @Override
    public PayMasterEnum deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        for (String value : variants(element.getAsString())) {
            System.out.println(value);
            PayMasterEnum result = CLEAR_GSON.fromJson(new JsonPrimitive(value), type);
            if (result != null) {
                return result;
            }
        }
        throw new JsonParseException("Invalid JSON element: " + element);
    }
}