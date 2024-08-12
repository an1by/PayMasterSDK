package net.aniby.paymaster.utils.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import net.aniby.paymaster.enums.PaymentMethod;

import java.lang.reflect.Type;

public class PaymentMethodSerializer implements JsonSerializer<PaymentMethod> {
    @Override
    public JsonElement serialize(PaymentMethod paymentMethod, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(paymentMethod.name().toLowerCase());
    }
}