package net.aniby.paymaster.modules.notifications;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.PaymentTokenStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentTokenStatusRequest {
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
}
