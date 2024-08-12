package net.aniby.paymaster.modules.stickers;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.modules.Amount;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StickerDetails {
    @SerializedName("id")
    @NotNull
    String id;

    @SerializedName("stickerType")
    @NotNull
    String stickerType;

    @SerializedName("cashlink")
    boolean cashLink;

    @SerializedName("productCode")
    String productCode;

    @SerializedName("paymentPurpose")
    @NotNull
    String paymentPurpose;

    @SerializedName("description")
    String description;

    @SerializedName("amount")
    Amount amount;

    @SerializedName("status")
    @NotNull
    String status;

    @SerializedName("payload")
    @NotNull
    String payload;
}
