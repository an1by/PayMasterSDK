package net.aniby.paymaster.common.types;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
public class Product {
    @SerializedName("country")
    private String country;

    @SerializedName("declaration")
    private String declaration;
}
