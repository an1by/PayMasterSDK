package net.aniby.paymaster.modules.stickers;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.types.Amount;
import org.jetbrains.annotations.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterStickerBody {
    @SerializedName("merchantId")
    @NotNull
    String merchantId;

    @SerializedName("stickerType")
    @NotNull
    String stickerType;

    @SerializedName("cashlink")
    Boolean cashLink;

    @SerializedName("description")
    String description;

    @SerializedName("productCode")
    String productCode;

    @SerializedName("paymentPurpose")
    @NotNull
    String paymentPurpose;

    @SerializedName("amount")
    Amount amount;

    @SerializedName("callbackUrl")
    String callbackUrl;
}