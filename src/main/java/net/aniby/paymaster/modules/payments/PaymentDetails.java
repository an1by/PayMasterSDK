package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.PaymentStatus;
import net.aniby.paymaster.types.Amount;
import net.aniby.paymaster.modules.payments.confirmation.PaymentConfirmation;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentDetails {
    // Partial
    @SerializedName("id")
    @NotNull
    String id;

    @SerializedName("created")
    @NotNull
    Date created;

    @SerializedName("status")
    @NotNull
    PaymentStatus status;

    @SerializedName("merchantId")
    @NotNull
    String merchantId;

    @SerializedName("invoice")
    @NotNull
    PaymentInvoice invoice;

    @SerializedName("amount")
    @NotNull
    Amount amount;

    @SerializedName("paymentData")
    PaymentData paymentData;

    // Full
    @SerializedName("testMode")
    Boolean testMode;

    @SerializedName("resultCode")
    String resultCode;

    @SerializedName("message")
    String message;

    @SerializedName("customer")
    Customer customer;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Customer {
        @SerializedName("ip")
        String ip;
    }

    @SerializedName("confirmation")
    PaymentConfirmation confirmation;

    @SerializedName("paymentToken")
    PaymentToken paymentToken;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class PaymentToken {
        @SerializedName("id")
        @NotNull
        String id;

        @SerializedName("expires")
        @NotNull
        Date expires;

        @SerializedName("title")
        String title;
    }
}
