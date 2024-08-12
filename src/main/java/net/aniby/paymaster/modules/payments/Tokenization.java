package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.TokenType;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tokenization {
    @SerializedName("type")
    @NotNull
    TokenType type;

    @SerializedName("purpose")
    String purpose;

    @SerializedName("callbackUrl")
    String callbackUrl;
}
