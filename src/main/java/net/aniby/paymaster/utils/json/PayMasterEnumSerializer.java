package net.aniby.paymaster.utils.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import net.aniby.paymaster.utils.PayMasterEnum;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PayMasterEnumSerializer implements JsonSerializer<PayMasterEnum> {
    static String capitalize(String name) {
        return Arrays.stream(name.toLowerCase().split("_"))
                .map((s) -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(""));
    }

    @Override
    public JsonElement serialize(PayMasterEnum payMasterEnum, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(capitalize(payMasterEnum.name()));
    }
}