package net.aniby.paymaster.modules.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.ReceiptMethod;
import net.aniby.paymaster.enums.TokenType;
import net.aniby.paymaster.modules.payments.PaymentProtocol;
import net.aniby.paymaster.types.items.CardInfo;
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

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class PaymentData {
        @SerializedName("paymentMethod")
        ReceiptMethod paymentMethod;

        @SerializedName("paymentInstrumentTitle")
        String paymentInstrumentTitle;

        @SerializedName("agreement")
        String agreement;

        @SerializedName("cardInfo")
        CardInfo cardInfo;
    }


    @SerializedName("protocol")
    PaymentProtocol protocol;

    @SerializedName("customer")
    @NotNull
    TokenCustomer customer;
}