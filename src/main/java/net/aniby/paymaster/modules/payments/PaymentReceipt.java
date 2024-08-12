package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.utils.ItemList;
import net.aniby.paymaster.modules.receipts.ReceiptDetails;
import net.aniby.paymaster.types.Client;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentReceipt extends ItemList<ReceiptDetails> {
    @SerializedName("client")
    @NotNull
    Client client;
}