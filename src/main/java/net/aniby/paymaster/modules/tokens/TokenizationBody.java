package net.aniby.paymaster.modules.tokens;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.PaymentMethod;
import net.aniby.paymaster.enums.TokenType;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TokenizationBody {
    @SerializedName("merchantId")
    @NotNull
    String merchantId;

    @SerializedName("testMode")
    Boolean testMode;

    @SerializedName("type")
    @NotNull
    TokenType type = TokenType.RECURRING;

    @SerializedName("purpose")
    @NotNull
    String purpose;

    @SerializedName("paymentMethod")
    @NotNull
    PaymentMethod paymentMethod;

    @SerializedName("callbackUrl")
    String callbackUrl;

    @SerializedName("returnUrl")
    String returnUrl;

    @SerializedName("customer")
    @NotNull
    TokenCustomer customer;
}