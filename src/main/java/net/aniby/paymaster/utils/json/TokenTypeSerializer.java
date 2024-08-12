package net.aniby.paymaster.utils.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import net.aniby.paymaster.enums.PaymentMethod;
import net.aniby.paymaster.enums.TokenType;

import java.lang.reflect.Type;

public class TokenTypeSerializer implements JsonSerializer<TokenType> {
    @Override
    public JsonElement serialize(TokenType paymentMethod, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(paymentMethod.name().toLowerCase());
    }
}