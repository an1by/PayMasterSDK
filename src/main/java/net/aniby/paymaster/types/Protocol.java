package net.aniby.paymaster.types;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Protocol {
    @SerializedName("returnUrl")
    String returnUrl;

    @SerializedName("callbackUrl")
    String callbackUrl;

    @SerializedName("threeDSCompleteUrl")
    String threeDSCompleteUrl;
}
