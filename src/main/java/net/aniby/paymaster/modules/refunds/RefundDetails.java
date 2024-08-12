package net.aniby.paymaster.modules.refunds;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.RefundStatus;
import net.aniby.paymaster.types.Amount;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefundDetails {
    @SerializedName("id")
    @NotNull
    String id;

    @SerializedName("created")
    @NotNull
    Date created;

    @SerializedName("paymentId")
    @NotNull
    String paymentId;

    @SerializedName("amount")
    @NotNull
    Amount amount;

    @SerializedName("status")
    @NotNull
    RefundStatus status;

    @SerializedName("resultCode")
    String resultCode;
}
