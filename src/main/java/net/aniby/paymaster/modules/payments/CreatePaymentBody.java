package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.ReceiptMethod;
import net.aniby.paymaster.enums.TokenType;
import net.aniby.paymaster.modules.Amount;
import net.aniby.paymaster.types.users.Client;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePaymentBody {
    @SerializedName("merchantId")
    String merchantId;

    @SerializedName("dualMode")
    Boolean dualMode;

    @SerializedName("testMode")
    Boolean testMode;

    @SerializedName("tokenization")
    Tokenization tokenization;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Tokenization {
        @SerializedName("type")
        @NotNull
        TokenType type;

        @SerializedName("purpose")
        String purpose;

        @SerializedName("callbackUrl")
        String callbackUrl;
    }

    @SerializedName("invoice")
    @NotNull
    PaymentInvoice invoice;

    @SerializedName("amount")
    @NotNull
    Amount amount;

    @SerializedName("paymentData")
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

        @SerializedName("card")
        PaymentCard card;

        @SerializedName("authorizationCode")
        String authorizationCode;

        @SerializedName("account")
        String account;

        @SerializedName("phone")
        String phone;

        @SerializedName("token")
        Token token;

        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        @Getter
        @Accessors(fluent = true)
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public class Token {
            @SerializedName("id")
            @NotNull
            String id;
        }

        @SerializedName("stickerId")
        String stickerId;
    }

    @SerializedName("protocol")
    PaymentProtocol protocol;

    @SerializedName("customer")
    Client customer;

    @SerializedName("device")
    Device device;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Device {
        @SerializedName("language")
        @NotNull String language;

        @SerializedName("acceptHeader")
        @NotNull String acceptHeader;

        @SerializedName("userAgent")
        @NotNull String userAgent;

        @SerializedName("colorDepth")
        @NotNull String colorDepth;

        @SerializedName("screenHeight")
        @NotNull String screenHeight;

        @SerializedName("screenWidth")
        @NotNull String screenWidth;

        @SerializedName("utcOffsetMinutes")
        @NotNull String utcOffsetMinutes;
    }

    @SerializedName("receipt")
    PaymentReceipt receipt;
}
