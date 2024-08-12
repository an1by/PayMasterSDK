package net.aniby.paymaster.types.items;

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
public class Product {
    @SerializedName("country")
    String country;

    @SerializedName("declaration")
    String declaration;
}
