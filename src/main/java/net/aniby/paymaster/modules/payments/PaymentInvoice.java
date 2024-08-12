package net.aniby.paymaster.modules.payments;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentInvoice {
    @SerializedName("description")
    @NotNull
    String description;

    @SerializedName("orderNo")
    String orderNumber;

    @SerializedName("expires")
    Date expires;

    @SerializedName("params")
    JsonObject params;
}
