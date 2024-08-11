package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.common.types.Amount;
import net.aniby.paymaster.common.types.payment.PaymentData;
import net.aniby.paymaster.common.types.payment.PaymentInvoice;
import net.aniby.paymaster.common.types.payment.PaymentStatus;
import net.aniby.paymaster.common.types.user.Customer;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentPartialDetails {
    @SerializedName("id")
    @NotNull String id;

    @SerializedName("created")
    @NotNull Date created;

    @SerializedName("status")
    @NotNull PaymentStatus status;

    @SerializedName("merchantId")
    @NotNull String merchantId;

    @SerializedName("invoice")
    @NotNull PaymentInvoice invoice;

    @SerializedName("amount")
    @NotNull Amount amount;

    @SerializedName("paymentData")
    PaymentData paymentData;


}
