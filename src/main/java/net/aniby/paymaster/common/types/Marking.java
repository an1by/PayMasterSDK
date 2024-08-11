package net.aniby.paymaster.common.types;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
public class Marking {
    @SerializedName("code")
    private @NotNull String code;

    @SerializedName("quantity")
    private Quantity quantity;

    public Double calculateQuantity() {
        return quantity == null ? null : (double) quantity.numerator / quantity.denominator;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    public static class Quantity {
        @SerializedName("numerator")
        private int numerator;

        @SerializedName("denominator")
        private int denominator;
    }
}
