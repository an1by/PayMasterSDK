package net.aniby.paymaster.common.types.payment;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class PaymentConfirmation {
    @SerializedName("type")
    @NotNull String type;
    // ***		Параметры подтверждения - прописываем сами, создавая отдельный class, с extend'ом этого класса
}
