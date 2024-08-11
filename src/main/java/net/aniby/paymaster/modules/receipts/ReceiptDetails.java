package net.aniby.paymaster.modules.receipts;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.common.types.Amount;
import net.aniby.paymaster.common.types.reciepts.ReceiptStatus;
import net.aniby.paymaster.common.types.reciepts.ReceiptType;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiptDetails {
    @SerializedName("id")
    @NotNull String id;

    @SerializedName("created")
    @NotNull Date created;

    @SerializedName("paymentId")
    @NotNull String paymentId;

    @SerializedName("amount")
    @NotNull Amount amount;

    @SerializedName("type")
    @NotNull ReceiptType type;

    @SerializedName("status")
    @NotNull ReceiptStatus status;
}
