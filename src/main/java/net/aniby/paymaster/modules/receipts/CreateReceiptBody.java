package net.aniby.paymaster.modules.receipts;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.ReceiptType;
import net.aniby.paymaster.types.Amount;
import net.aniby.paymaster.types.Item;
import net.aniby.paymaster.types.Client;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateReceiptBody {
    @SerializedName("paymentId")
    @NotNull
    String paymentId;

    @SerializedName("amount")
    @NotNull
    Amount amount;

    @SerializedName("type")
    @NotNull
    ReceiptType type;

    @SerializedName("client")
    @NotNull
    Client client;

    @SerializedName("items")
    @NotNull
    ArrayList<Item> items;
}
