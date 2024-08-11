package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.common.types.Amount;
import net.aniby.paymaster.common.types.payments.*;
import net.aniby.paymaster.common.types.users.Customer;
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
    @NotNull String merchantId;

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

    @SerializedName("confirmation")
    PaymentConfirmation confirmation;

    @SerializedName("paymentToken")
    PaymentToken paymentToken;
}
