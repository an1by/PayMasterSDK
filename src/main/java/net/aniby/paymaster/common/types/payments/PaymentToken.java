package net.aniby.paymaster.common.types.payment;

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
public class PaymentToken {
    @SerializedName("id")
    @NotNull
    String id;

    @SerializedName("expires")
    @NotNull Date expires;

    @SerializedName("title")
    String title;
}
