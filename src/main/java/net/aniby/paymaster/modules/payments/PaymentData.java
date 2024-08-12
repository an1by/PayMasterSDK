package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.ReceiptMethod;
import net.aniby.paymaster.types.items.CardInfo;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentData {
    @SerializedName("paymentMethod")
    ReceiptMethod paymentMethod;

    @SerializedName("paymentInstrumentTitle")
    String paymentInstrumentTitle;

    @SerializedName("agreement")
    String agreement;

    @SerializedName("cardInfo")
    CardInfo cardInfo;
}
