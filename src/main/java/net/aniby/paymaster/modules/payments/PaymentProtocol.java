package net.aniby.paymaster.modules.payments;

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
public class PaymentProtocol {
    @SerializedName("returnUrl")
    String returnUrl;

    @SerializedName("callbackUrl")
    String callbackUrl;

    @SerializedName("threeDSCompleteUrl")
    String threeDSCompleteUrl;
}
