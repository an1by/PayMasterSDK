package net.aniby.paymaster.common.types.payment;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.common.types.CardInfo;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentData {
    @SerializedName("paymentMethod")
    PaymentMethod paymentMethod;

    @SerializedName("paymentInstrumentTitle")
    String paymentInstrumentTitle;

    @SerializedName("agreement")
    String agreement;

    @SerializedName("cardInfo")
    CardInfo cardInfo;
}
