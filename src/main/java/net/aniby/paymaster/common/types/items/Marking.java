package net.aniby.paymaster.common.types.items;

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
public class Marking {
    @SerializedName("code")
    @NotNull String code;

    @SerializedName("quantity")
    Quantity quantity;

    public Double calculateQuantity() {
        return quantity == null ? null : (double) quantity.numerator / quantity.denominator;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Quantity {
        @SerializedName("numerator")
        int numerator;

        @SerializedName("denominator")
        int denominator;
    }
}
