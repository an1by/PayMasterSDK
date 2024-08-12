package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompletePaymentBody {
    @SerializedName("code")
    String code;

    @SerializedName("threeDSCompInd")
    String threeDSCompInd;

    @SerializedName("cres")
    String cres;

    @SerializedName("PARes")
    String PARes;
}
