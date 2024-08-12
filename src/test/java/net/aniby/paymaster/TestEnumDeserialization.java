package net.aniby.paymaster;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.utils.json.PayMasterEnum;
import net.aniby.paymaster.utils.json.PayMasterEnumDeserializer;

public class TestEnumDeserialization {
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Something {
        @SerializedName("pay")
        Pay pay;
    }

    public enum Pay implements PayMasterEnum {
        NOT_BANK_CARD,
        BANKCARD,
        THREE_D_SECURE_FAILED
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(PayMasterEnum.class, new PayMasterEnumDeserializer())
                .create();

        // Will work
        // BankCard -> BANKCARD, BANK_CARD
        // NotBankCard -> NOTBANKCARD, NOT_BANK_CARD,
        // ThreeDSecureFailed -> THREEDSECUREFAILED, THREE_D_SECURE_FAILED
        System.out.println(gson.fromJson("{\"pay\":\"BankCard\"}", Something.class));
        System.out.println(gson.fromJson("{\"pay\":\"NotBankCard\"}", Something.class));
        System.out.println(gson.fromJson("{\"pay\":\"ThreeDSecureFailed\"}", Something.class));

        // Won't work, because:
        // NotbankCard -> NOTBANKCARD or NOT_BANKCARD
        System.out.println(gson.fromJson("{\"pay\":\"NotbankCard\"}", Something.class));
    }
}
