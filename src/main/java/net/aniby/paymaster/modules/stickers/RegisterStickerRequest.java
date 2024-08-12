package net.aniby.paymaster.modules.stickers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import com.google.gson.annotations.SerializedName;
import net.aniby.paymaster.modules.Amount;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterStickerRequest {

    @SerializedName("merchantId")
    @NotNull
    String merchantId;

    @SerializedName("stickerType")
    @NotNull String stickerType;

    @SerializedName("cashlink")
    Boolean cashLink;

    @SerializedName("description")
    String description;

    @SerializedName("productCode")
    String productCode;

    @SerializedName("paymentPurpose")
    @NotNull String paymentPurpose;

    @SerializedName("amount")
    Amount amount;

    @SerializedName("callbackUrl")
    String callbackUrl;
}