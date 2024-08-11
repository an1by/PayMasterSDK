package net.aniby.paymaster.modules.refunds;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.common.types.Amount;
import net.aniby.paymaster.common.types.items.Item;
import net.aniby.paymaster.common.types.users.Client;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefundCreateRequest {
    @SerializedName("paymentId")
    @NotNull
    String paymentId;

    @SerializedName("amount")
    @NotNull
    Amount amount;

    @SerializedName("client")
    @NotNull
    Client client;

    @SerializedName("items")
    @NotNull
    ArrayList<Item> items;
}
