package net.aniby.paymaster.modules.payments.confirmation;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExternalPaymentConfirmation extends PaymentConfirmation{
    @SerializedName("paymentUrl")
    String paymentUrl;

    @SerializedName("universalLink")
    Boolean universalLink;

    @SerializedName("instruction")
    String instruction;
}
