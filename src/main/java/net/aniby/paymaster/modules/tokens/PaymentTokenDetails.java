package net.aniby.paymaster.modules.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.PaymentTokenStatus;
import net.aniby.paymaster.types.confirmation.ExternalPaymentConfirmation;
import net.aniby.paymaster.types.CardInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentTokenDetails {
    @SerializedName("id")
    @NotNull
    String id;

    @SerializedName("status")
    @NotNull
    PaymentTokenStatus status;

    @SerializedName("title")
    String title;

    @SerializedName("expires")
    Date expires;

    @SerializedName("cardInfo")
    CardInfo cardInfo;

    @SerializedName("confirmation")
    ExternalPaymentConfirmation confirmation;
}
