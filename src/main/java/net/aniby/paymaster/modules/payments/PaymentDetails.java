package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.common.types.payment.PaymentData;
import net.aniby.paymaster.common.types.user.Customer;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentDetails extends PaymentPartialDetails {
    @SerializedName("testMode")
    boolean testMode;

    @SerializedName("resultCode")
    String resultCode;

    @SerializedName("message")
    String message;

    @SerializedName("customer")
    Customer customer;

    @SerializedName("paymentData")
    PaymentData paymentData;
}
