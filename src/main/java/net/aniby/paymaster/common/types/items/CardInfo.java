package net.aniby.paymaster.common.types.items;

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
public class CardInfo {
    @SerializedName("brand")
    String brand;

    @SerializedName("issuer")
    String issuer;

    @SerializedName("country")
    String country;

    @SerializedName("type")
    String type;

    @SerializedName("category")
    String category;
}
