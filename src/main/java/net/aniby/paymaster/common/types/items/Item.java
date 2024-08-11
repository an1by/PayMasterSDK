package net.aniby.paymaster.common.types.items;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import net.aniby.paymaster.common.types.payments.PaymentMethod;
import net.aniby.paymaster.common.types.payments.PaymentSubject;
import net.aniby.paymaster.common.types.users.AgentType;
import net.aniby.paymaster.common.types.users.Supplier;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
public class Item {
    @SerializedName("name")
    private @NotNull String name;

    @SerializedName("quantity")
    private double quantity;

    @SerializedName("price")
    private double price;

    @SerializedName("measure")
    private Measure measure;

    @SerializedName("excise")
    private Double excise;

    @SerializedName("product")
    private Product product;

    @SerializedName("vatType")
    private @NotNull VatType vatType;

    @SerializedName("paymentSubject")
    private @NotNull PaymentSubject paymentSubject;

    @SerializedName("paymentMethod")
    private @NotNull PaymentMethod paymentMethod;

    @SerializedName("marking")
    private Marking marking;

    @SerializedName("agentType")
    private AgentType agentType;

    @SerializedName("supplier")
    private Supplier supplier;
}
