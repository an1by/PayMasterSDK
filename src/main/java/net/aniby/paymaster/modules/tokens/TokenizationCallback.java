package net.aniby.paymaster.modules.tokens;

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
public class TokenizationCallback {
    @SerializedName("tokenId")
    @NotNull
    String tokenId;

    @SerializedName("url")
    String url;
}