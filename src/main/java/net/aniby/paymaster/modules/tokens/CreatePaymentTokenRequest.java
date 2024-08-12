package net.aniby.paymaster.modules.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.TokenType;
import net.aniby.paymaster.modules.payments.PaymentData;
import net.aniby.paymaster.types.Protocol;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePaymentTokenRequest {
    @SerializedName("merchantId")
    @NotNull
    String merchantId;

    @SerializedName("testMode")
    Boolean testMode;

    @SerializedName("type")
    @NotNull
    TokenType type = TokenType.RECURRING;

    @SerializedName("purpose")
    @NotNull
    String purpose;

    @SerializedName("paymentData")
    @NotNull
    PaymentData paymentData;


    @SerializedName("protocol")
    Protocol protocol;

    @SerializedName("customer")
    @NotNull
    TokenCustomer customer;
}